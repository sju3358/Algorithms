#include <iostream>
#include <vector>
#include <queue>

#define INTEGER_MAX_VALUE 2100000000

using namespace std;

typedef struct node {
	int i;
	int j;
	int length;
}Node;

int dir_i[] = {0, 0, 1,-1};
int dir_j[] = {1,-1, 0, 0};


bool isInBoundary(int i, int j, int n, int m) {
	return 0 <= i && i < n && 0 <= j && j < m;
}

int solution(vector<vector<int> > maps){

	vector<vector<bool>> isVisit;

	int N = maps.size();
	int M = maps[0].size();
	int minLength = INTEGER_MAX_VALUE;

	for (int i = 0; i < N; i++) {
		vector<bool> temp;
		for (int j = 0; j < M; j++) {
			temp.push_back(false);
		}
		isVisit.push_back(temp);
	}

	queue<Node> nextNode;
	nextNode.push({ 0,0,1 });
	isVisit[0][0] = true;


	bool isArrived = false;

	while (nextNode.empty() != true) {
		Node curNode = nextNode.front(); nextNode.pop();

		if (curNode.i == N - 1 && curNode.j == M - 1) {
			if (minLength > curNode.length)
				minLength = curNode.length;

			isArrived = true;
		}
		else {
			for (int i = 0; i < 4; i++) {
				int nextI = curNode.i + dir_i[i];
				int nextJ = curNode.j + dir_j[i];

				if (isInBoundary(nextI, nextJ, N, M)) {
					if (maps[nextI][nextJ] == 1 && isVisit[nextI][nextJ] == false) {
						isVisit[nextI][nextJ] = true;
						nextNode.push({ nextI, nextJ, curNode.length + 1 });
					}
				}

			}
		}
	}

	return isArrived != false ? minLength : -1;
}

int main() {

}