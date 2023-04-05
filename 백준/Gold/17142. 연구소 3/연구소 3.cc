#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

typedef struct virus {
	int i;
	int j;
}Virus;

typedef struct node {
	int i;
	int j;
	int length;
}Node;

bool isInBoundary(int i, int j, int N) {
	return 0 <= i && i < N && 0 <= j && j < N;
}

bool flag = false;

bool check(vector<vector<int>>& map, vector<vector<bool>>& visited) {

	int N = map.size();

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			if (visited[i][j] == false && map[i][j] != 1)
				return false;
	flag = true;
	return true;
}

int getLength(vector<vector<int>> map, vector<Virus> viruses) {
	
	int N = map.size();
	int dir[][2] = { {-1,0},{1,0},{0,1},{0,-1} };
	
	queue<Node> nextNode;
	vector<vector<bool>> visited(N, vector<bool>(N, false));
	int length = 0;
	
	for (int i = 0; i < viruses.size(); i++) {
		
		nextNode.push({ viruses[i].i,viruses[i].j,0 });
		visited[viruses[i].i][viruses[i].j] = true;
	}

	while (nextNode.empty() != true) {
		Node curNode = nextNode.front(); nextNode.pop();

		if(map[curNode.i][curNode.j] != 2)
			length = max(length, curNode.length);

		for (int i = 0; i < 4; i++) {
			int nextI = curNode.i + dir[i][0];
			int nextJ = curNode.j + dir[i][1];
			int nextLength = curNode.length + 1;

			if (isInBoundary(nextI, nextJ, N) != true)
				continue;

			if (visited[nextI][nextJ] == true)
				continue;

			if (map[nextI][nextJ] == 1)
				continue;

			visited[nextI][nextJ] = true;
			nextNode.push({ nextI,nextJ,nextLength });

		}
	}
	
	if (check(map,visited) == false)
		return 2500;
	else
		return length;
}

void getCombination(vector<int> selectIndex, int cnt,int M, vector<Virus>& viruses, vector<vector<Virus>>& selectedViruses) {
	if (cnt == M) {
		
		vector<Virus> selectedVirus;
		for (int i = 0; i < cnt; i++)
			selectedVirus.push_back(viruses[selectIndex[i]]);

		selectedViruses.push_back(selectedVirus);
	}
	else {

		int curIndex = cnt == 0 ? -1 : selectIndex[cnt - 1];

		for (int i = curIndex + 1; i < viruses.size(); i++) {
			selectIndex[cnt] = i;
			getCombination(selectIndex, cnt + 1, M, viruses, selectedViruses);
		}
	}
}

void getSelectedVirus(vector<Virus>& viruses, vector<vector<Virus>>& seletedViruses,int M) {
	
	vector<int> selectIndex(M);
	getCombination(selectIndex, 0, M, viruses, seletedViruses);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int N, M;
	cin >> N >> M;

	vector<Virus> viruses;
	vector<vector<int>> map(N, vector<int>(N, 0));


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int input; cin >> input;

			if (input == 2) 
				viruses.push_back({ i,j });
			
			map[i][j] = input;
		}
	}
	
	int minLength = 2100000000;

	vector<vector<Virus>> seletedViruses;
	getSelectedVirus(viruses,seletedViruses,M);

	for (int i = 0; i < seletedViruses.size(); i++)
		minLength = min(minLength, getLength(map, seletedViruses[i]));


	if (flag == false)
		minLength = -1;

	cout << minLength;
}