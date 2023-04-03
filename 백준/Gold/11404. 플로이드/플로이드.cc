#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define INF 10000001

int main() {
	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n, m;
	
	cin >> n >> m;

	vector<vector<int>> map(n, vector<int>(n, INF));
	
	for (int i = 0; i < n; i++)
		map[i][i] = 0;

	for (int i = 0; i < m; i++) {
		int x, y, cost;
		cin >> x >> y >> cost;
		map[x-1][y-1] = min(map[x-1][y-1],cost);
	}

	for (int k = 0; k < n; k++)
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {

				map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
			}

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			if (map[i][j] == INF)
				map[i][j] = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << map[i][j] << " ";
		}
		cout << "\n";
	}
}