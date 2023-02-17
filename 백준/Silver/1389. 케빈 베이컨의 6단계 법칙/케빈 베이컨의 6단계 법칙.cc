#include <iostream>
#include <vector>
#include <queue>

using namespace std;

#define INT_MAX_VALUE 2100000000;

vector<vector<bool>> friends;
vector<vector<int>> kevins;
int n, m;
int minValue = INT_MAX_VALUE;
int minIndex = INT_MAX_VALUE;

void init() {
	
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < n; i++) {
		vector<bool> init;
		vector<int> init2;
		for (int j = 0; j < n; j++) {
			init.push_back(false);
			init2.push_back(-1);
		}
		friends.push_back(init);
		kevins.push_back(init2);
	}
}

typedef struct Index {
	int index;
	int length;
};

int dfs(int startI) {

	queue<Index> nextIndex;
	
	nextIndex.push({ startI,0});
	
	while (nextIndex.empty() != true) {

		Index curIndex = nextIndex.front(); nextIndex.pop();

		if (kevins[startI][curIndex.index] == -1 || kevins[startI][curIndex.index] > curIndex.length)
			kevins[startI][curIndex.index] = curIndex.length;
		else
			continue;

		for (int i = 0; i < n; i++) {
			if (friends[curIndex.index][i] == true) {
					nextIndex.push({ i, curIndex.length + 1 });
			}
		}
	}

	int kevin = 0;
	for (int i = 0; i < kevins.size(); i++)
		kevin += kevins[startI][i];

	return kevin;
}


int solution() {

	for (int i = 0; i < friends.size(); i++) {
		int kevin = dfs(i);
		if (minValue > kevin) {
			minValue = kevin;
			minIndex = i;
		}
		else if (minValue == kevin) {
			if (minIndex > i)
				minIndex = i;
		}
	}

	return minIndex + 1;
}




int main(void) {
	
	cin >> n >> m;
	init();

	for (int i = 0; i < m; i++) {
		int friend1, friend2;
		cin >> friend1 >> friend2;

		friends[friend1 - 1][friend2 - 1] = true;
		friends[friend2 - 1][friend1 - 1] = true;
	}

	cout << solution();
}