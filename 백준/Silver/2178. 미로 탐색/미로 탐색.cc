#include <iostream>
#include <vector>
#include <queue>
#include <string>
using namespace std;

typedef struct index {
	int i;
	int j;
	int cost;
}Index;


vector<vector<int>> maze;
vector<vector<bool>> isVisit;
int n, m;

int dir[][2] = {{1,0},{-1,0},{0,1},{0,-1}};

int isInBoundary(int i, int j) {
	return 0 <= i && i < n && 0 <= j && j < m;
}


int getMinLength() {
	
	queue<Index> nextIndex;
	nextIndex.push({ 0,0,1});
	isVisit[0][0] = true;
	
	int max = 2100000000;

	while (nextIndex.empty() != true){
		Index curIndex = nextIndex.front();
		nextIndex.pop();

		if (curIndex.i == n - 1 && curIndex.j == m - 1) {
			if (max > curIndex.cost)
				max = curIndex.cost;
			continue;
		}

		for (int i = 0; i < 4; i++) {
			int nextI = curIndex.i + dir[i][0];
			int nextJ = curIndex.j + dir[i][1];

			if (isInBoundary(nextI, nextJ)) {
				if (isVisit[nextI][nextJ] == false && maze[nextI][nextJ] == 1) {
					isVisit[nextI][nextJ] = true;
					nextIndex.push({ nextI, nextJ, curIndex.cost + 1 });
				}
			}
		}

	}

	return max;
}

void input() {
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		
		vector<int> mazeInfo;
		vector<bool> visited;

		string input; cin >> input;
		
		for (int j = 0; j < m; j++) {
			
			int temp = input[j] - '0';
			
			mazeInfo.push_back(temp);
			
			temp == 0 ? visited.push_back(true) : visited.push_back(false);
			
		}
		maze.push_back(mazeInfo);
		isVisit.push_back(visited);
	}
}

int main() {

	input();
	
	cout << getMinLength();
}