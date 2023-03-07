#include <iostream>
#include <queue>
#include <vector>

using namespace std;


typedef struct node {
	int i;
	int j;
	int distance;
}Node;

int dir[][2] = { {1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

vector<vector<int>> map(501, vector<int>(501));

bool isInBoundary(int i, int j, int n) {
	return 0 <= i && i < n && 0 <= j && j < n;
}

bool isInOutLine(int curI, int curJ, int n) {

	int flag = 0;

	for (int i = 0; i < 8; i++) {
		int nextI = curI + dir[i][0];
		int nextJ = curJ + dir[i][1];

		if (isInBoundary(nextI, nextJ, n) == false) {
			flag++;
			continue;
		}

		if (map[nextI][nextJ] == 0)
			flag++;
	}

	if (flag > 0)
		return true;
	else
		return false;
}




void makeMap(vector<vector<int>> rectangles) {

	for (int index = 0; index < rectangles.size(); index++) {
		vector<int> rectangle = rectangles[index];

		for (int i = rectangle[1]*2; i <= rectangle[3]*2; i++)
			for (int j = rectangle[0]*2; j <= rectangle[2]*2; j++)
				map[i][j] = 1;
	}
}


int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
	
	int minLength = 2100000000;
	int n = map.size();

	vector<vector<bool>> visited(n, vector<bool>(n));
	

	makeMap(rectangle);

	int startX = characterY * 2;
	int startY = characterX * 2;
	int targetX = itemY * 2;
	int targetY = itemX * 2;

	queue<Node> nextNode;
	nextNode.push({ startX, startY,0 });
	visited[startX][startY] = true;

	while (nextNode.empty() != true) {

		Node curNode = nextNode.front(); nextNode.pop();

		if (isInOutLine(curNode.i, curNode.j, map.size()) == false)
			continue;

 		if (curNode.i == targetX && curNode.j == targetY)
			if (minLength > curNode.distance)
				minLength = curNode.distance/2;

		for (int i = 0; i < 4; i++) {
			int nextI = curNode.i + dir[i][0];
			int nextJ = curNode.j + dir[i][1];

			if (isInBoundary(nextI, nextJ, n) == false)
				continue;

			if (map[nextI][nextJ] == 0)
				continue;

			if (visited[nextI][nextJ] == true)
				continue;

			visited[nextI][nextJ] = true;
			nextNode.push({ nextI,nextJ,curNode.distance + 1});
			
		}
	}

	return minLength;
}

int main() {
	cout << solution({ {1, 1, 5, 7} }, 1, 1, 4, 7);
	cout << solution({ {1, 1, 7, 4},{3, 2, 5, 5},{4, 3, 6, 9},{2, 6, 8, 8} }, 1, 3, 7,8);
}