#include <iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;


int dir_i[] = {0, 0, 1,-1};
int dir_j[] = {1,-1, 0, 0};

typedef struct Node
{
	int i;
	int j;
}Node;

bool isInBoundary(int i, int j, int n) {
	return 0 <= i && i < n && 0 <= j && j < n;
}


//적록색약X
int dfs1(vector<vector<char>> map) {
	

	int cnt = 0;
	int n = map.size();
	vector<vector<bool>> isVisit;
	for (int i = 0; i < n; i++) {
		vector<bool> temp;
		for (int j = 0; j < n; j++) {
			temp.push_back(false);
		}
		isVisit.push_back(temp);
	}

	

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (isVisit[i][j] != true) {
				cnt++;
				queue<Node> index;
				index.push({ i,j });
				
				char pivot = map[i][j];
				isVisit[i][j] = true;
				
				while (index.empty() != true) {
					Node curNode = index.front();
					index.pop();

					for (int i = 0; i < 4; i++) {
						int next_i = curNode.i + dir_i[i];
						int next_j = curNode.j + dir_j[i];

						if (isInBoundary(next_i, next_j, n)) {
							bool flag1 = map[next_i][next_j] == pivot;
							bool flag2 = isVisit[next_i][next_j] != true;
							if (flag1 && flag2) {
								isVisit[next_i][next_j] = true;
								index.push({ next_i,next_j });
							}
						}
					}
				}
			}
		}
	}

	return cnt;

}

//적록색약
int dfs2(vector<vector<char>> map) {
	
	int cnt = 0;
	int n = map.size();
	vector<vector<bool>> isVisit;
	for (int i = 0; i < n; i++) {
		vector<bool> temp;
		for (int j = 0; j < n; j++) {
			temp.push_back(false);
		}
		isVisit.push_back(temp);
	}



	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (isVisit[i][j] != true) {
				cnt++;
				queue<Node> index;
				index.push({ i,j });

				char pivot = map[i][j];
				isVisit[i][j] = true;

				while (index.empty() != true) {
					Node curNode = index.front();
					index.pop();

					for (int i = 0; i < 4; i++) {
						int next_i = curNode.i + dir_i[i];
						int next_j = curNode.j + dir_j[i];

						if (isInBoundary(next_i, next_j, n) && isVisit[next_i][next_j] != true) {
							if (pivot == 'B' && map[next_i][next_j] == pivot) {
								isVisit[next_i][next_j] = true;
								index.push({ next_i,next_j });
							}
							else if (pivot != 'B' && map[next_i][next_j] != 'B') {
								isVisit[next_i][next_j] = true;
								index.push({ next_i,next_j });
							}
						}
					}
				}
			}
		}
	}

	return cnt;
}


int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n;

	vector<vector<char>> map;

	for (int i = 0; i < n; i++) {
		vector<char> inputs;
		string input; cin >> input;
		for (int j = 0; j < n; j++)
			inputs.push_back(input[j]);
		map.push_back(inputs);
	}

	int answer1 = dfs1(map);
	int answer2 = dfs2(map);

	cout << answer1 << " " << answer2;

}