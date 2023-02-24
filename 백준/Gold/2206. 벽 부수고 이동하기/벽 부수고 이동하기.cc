#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;

typedef struct node {
	int i;
	int j;
	int length;
	bool brokenBrick;
}Node;

typedef struct brick {
	int i;
	int j;
}Brick;


vector<vector<vector<bool>>> visited;
vector<Brick> bricks;
vector<vector<int>> map;

bool isArrived = false;

int dir[][2] = { {0,1},{0,-1},{1,0},{-1,0} };

bool isInBoundary(int i, int j) {
	return 0 <= i && i < map.size() && 0 <= j && j < map[0].size();
}

int minLength = 2100000000;

void bfs() {



	queue<Node> nextNode;
	nextNode.push({ 0,0,1,false });


	visited[0][0][0] = true;

	while (nextNode.empty() != true) {

		Node curNode = nextNode.front(); nextNode.pop();

		if (curNode.i == map.size() - 1 && curNode.j == map[0].size() - 1) {
			if (minLength > curNode.length)
				minLength = curNode.length;
			isArrived = true;
		}
		else {
			for (int i = 0; i < 4; i++) {
				int nextI = curNode.i + dir[i][0];
				int nextJ = curNode.j + dir[i][1];
				if (isInBoundary(nextI, nextJ)) {

					if (curNode.brokenBrick == true) {

						if (map[nextI][nextJ] == 0 && visited[nextI][nextJ][1] == false) {
							visited[nextI][nextJ][1] = true;
							nextNode.push({ nextI, nextJ, curNode.length + 1,curNode.brokenBrick });
						}

					}
					else {
						if (map[nextI][nextJ] == 0) {
							if (visited[nextI][nextJ][0] == false) {
								visited[nextI][nextJ][0] = true;
								nextNode.push({ nextI, nextJ, curNode.length + 1, curNode.brokenBrick });
							}
						}
						else {
							if (visited[nextI][nextJ][1] == false) {
								visited[nextI][nextJ][1] = true;
								nextNode.push({ nextI, nextJ, curNode.length + 1, true });
							}
						}
					}
				}

			}
		}
	}
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, m; cin >> n >> m;

	for (int i = 0; i < n; i++) {
		vector<int> temp;
		vector<vector<bool>> temp2;
		string input; cin >> input;
		for (int j = 0; j < m; j++) {
			temp.push_back(input[j] - '0');
			if (input[j] - '0' == 1)
				bricks.push_back({ i,j });
			vector<bool> temp3 = { false,false };
			temp2.push_back(temp3);
		}
		map.push_back(temp);
		visited.push_back(temp2);
	}

	
	bfs();
	

	if (isArrived == true)
		cout << minLength;
	else
		cout << -1;
	
}