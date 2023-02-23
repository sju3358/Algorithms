#include <iostream>
#include <vector>
#include <queue>
using namespace std;



int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	vector<int> parents;
	vector<vector<int>> map;
	vector<bool> visited;


	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		parents.push_back(0);
		visited.push_back(false);
		map.push_back({});
	}

	for (int i = 0; i < n - 1; i++) {
		int a, b;
		cin >> a >> b;

		map[a - 1].push_back(b - 1);
		map[b - 1].push_back(a - 1);
	}


	queue<int> nextNode;
	nextNode.push(0);
	visited[0] = true;

	while (nextNode.empty() != true) {
		int curNode = nextNode.front(); nextNode.pop();

		for (int i = 0; i < map[curNode].size(); i++) {
			if (visited[map[curNode][i]] == false) {
				visited[map[curNode][i]] = true;
				parents[map[curNode][i]] = curNode+1;
				nextNode.push(map[curNode][i]);
			}
		}
	}

	for (int i = 1; i < n; i++)
		cout << parents[i] << "\n";
}