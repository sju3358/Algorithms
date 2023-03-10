#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

typedef struct Node {
	int i;
	int j;
};

int dir[][2] = { {-1,0},{1,0},{0,-1},{0,1} };



vector<vector<Node>> tableBlocks;
vector<vector<Node>> gameboardBlocks;

bool isInBoundary(int i, int j, int n) {
	return 0 <= i && i < n && 0 <= j && j < n;
}
void moveBlockToZero(vector<vector<Node>>& blocks) {
	for (int i = 0; i < blocks.size(); i++) {
		vector<Node> block = blocks[i];

		int minI = 2100000000;
		int minJ = 2100000000;
		for (int j = 0; j < block.size(); j++) {
			if (minI > block[j].i)
				minI = block[j].i;
			if (minJ > block[j].j)
				minJ = block[j].j;
		}

		for (int j = 0; j < block.size(); j++) {
			blocks[i][j].i = blocks[i][j].i - minI;
			blocks[i][j].j = blocks[i][j].j - minJ;
		}
	}
}
void rotateTableBlock(vector<Node>& tableBlock) {
	
	vector<vector<int>> origin(50, vector<int>(50, 0));
	vector<vector<int>> rotated(50, vector<int>(50, 0));
	
	//배열에 현재 블록 좌표 넣기
	for (int i = 0; i < tableBlock.size(); i++) {
		Node node = tableBlock[i];
		origin[node.i][node.j] = 1;
	}

	int n = rotated.size();
	
	//회전
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			rotated[i][j] = origin[n - j - 1][i];
		}
	}



	//시작점 찾기
	int startI, startJ;
	for (int i = 0; i < rotated.size(); i++) {
		for (int j = 0; j < rotated.size(); j++) {
			if (rotated[i][j] == 1){
				startI = i;
				startJ = j;

				//break;
				i = rotated.size();
				j = rotated.size();
			}
		}
	}


	//bfs로 block 좌표 구하기
	vector<vector<bool>> visited(rotated.size(), vector<bool>(rotated.size(), false));
	tableBlock.clear();
	
	queue<Node> nextNode;
	nextNode.push({ startI,startJ });
	visited[startI][startJ] = true;

	while (nextNode.empty() != true) {

		Node curNode = nextNode.front(); nextNode.pop();

		tableBlock.push_back(curNode);

		for (int i = 0; i < 4; i++) {
			int nextI = curNode.i + dir[i][0];
			int nextJ = curNode.j + dir[i][1];

			if (isInBoundary(nextI, nextJ, visited.size()) == true) {
				if (rotated[nextI][nextJ] == 1 && visited[nextI][nextJ] != true) {
					visited[nextI][nextJ] = true;
					nextNode.push({ nextI,nextJ });
				}
			}
		}
	}

	//원점으로 모으기


	int minI = 2100000000;
	int minJ = 2100000000;
	for (int i = 0; i < tableBlock.size(); i++) {
		if (minI > tableBlock[i].i)
			minI = tableBlock[i].i;
		if (minJ > tableBlock[i].j)
			minJ = tableBlock[i].j;
	}

	for (int i = 0; i < tableBlock.size(); i++) {
		tableBlock[i].i = tableBlock[i].i - minI;
		tableBlock[i].j = tableBlock[i].j - minJ;
	}
	
		
}
void bfs(Node startNode,vector<vector<int>> map, vector<vector<bool>>& visited, int target, vector<vector<Node>>& blocks) {
	queue<Node> nextNode;
	nextNode.push(startNode);

	vector<Node> block;

	while (nextNode.empty() != true) {
		
		Node curNode = nextNode.front(); nextNode.pop();

		block.push_back(curNode);

		for (int i = 0; i < 4; i++) {
			int nextI = curNode.i + dir[i][0];
			int nextJ = curNode.j + dir[i][1];

			if (isInBoundary(nextI, nextJ, visited.size()) == true) {
				if (map[nextI][nextJ] == target && visited[nextI][nextJ] != true) {
					visited[nextI][nextJ] = true;
					nextNode.push({ nextI,nextJ });
				}
			}
		}
	}

	blocks.push_back(block);
}
void getTableBlocks(vector<vector<int>> table) {
	
	vector<vector<bool>> visited(table.size(), vector<bool>(table.size(), false));

	for (int i = 0; i < table.size(); i++) {
		for (int j = 0; j < table.size(); j++) {
			if (visited[i][j] != true && table[i][j] == 1) {
				visited[i][j] = true;
				bfs({ i,j }, table, visited, 1, tableBlocks);
			}
		}
	}

	moveBlockToZero(tableBlocks);
}
void getGameBoardBlocks(vector<vector<int>> gameBoard) {
	
	vector<vector<bool>> visited(gameBoard.size(), vector<bool>(gameBoard.size(), false));

	for (int i = 0; i < gameBoard.size(); i++) {
		for (int j = 0; j < gameBoard.size(); j++) {
			if (visited[i][j] != true && gameBoard[i][j] == 0) {
				visited[i][j] = true;
				bfs({ i,j }, gameBoard, visited, 0, gameboardBlocks);
			}
		}
	}

	moveBlockToZero(gameboardBlocks);
}
bool checkBlock(vector<Node> tableBlock, vector<Node> gameboardBlock) {

	if (tableBlock.size() != gameboardBlock.size())
		return false;

	for (int i = 0; i < tableBlock.size(); i++)
		if (tableBlock[i].i != gameboardBlock[i].i || tableBlock[i].j != gameboardBlock[i].j)
			return false;

	return true;
}
int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
	
	int answer = 0;

	

	getGameBoardBlocks(game_board);
	getTableBlocks(table);

	vector<bool> inserted(tableBlocks.size(), false);

	for (int i = 0; i < gameboardBlocks.size(); i++) {
		vector<Node> gameboardBlock = gameboardBlocks[i];

		for (int j = 0; j < tableBlocks.size(); j++) {
			vector<Node> tableBlock = tableBlocks[j];

			for (int k = 0; k < 4; k++) {
				if (inserted[j] != true && checkBlock(gameboardBlock, tableBlock) == true) {
					answer += tableBlock.size();
					inserted[j] = true;

					j = tableBlocks.size();
					break;
				}
				else
					rotateTableBlock(tableBlock);
			}
		}
	}
	return answer;
}

int main() {
	cout << solution({ 
		{1, 1, 0, 0, 1, 0},
		{0, 0, 1, 0, 1, 0},
		{0, 1, 1, 0, 0, 1},
		{1, 1, 0, 1, 1, 1},
		{1, 0, 0, 0, 1, 0},
		{0, 1, 1, 1, 0, 0} }, 
		{ {1, 0, 0, 1, 1, 0},
		{1, 0, 1, 0, 1, 0},
		{0, 1, 1, 0, 1, 1},
		{0, 0, 1, 0, 0, 0},
		{1, 1, 0, 1, 1, 0},
		{0, 1, 0, 0, 0, 0} });
}