#include <iostream>
#include <vector>
#include <queue>
#include <string>
using namespace std;

#define INF 5000000

bool solution(vector<vector<int>> distance) {

	//플루이드워셜
	for (int k = 0; k < distance.size(); k++)
		for (int i = 0; i < distance.size(); i++)
			for (int j = 0; j < distance.size(); j++)
				distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j]);



	//사이클 검출
	for (int i = 0; i < distance.size(); i++)
		if (distance[i][i] < 0)
			return true;
	return false;
}

int main() {
	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	vector<string> answer;

	int T; cin >> T;

	while (T--) {

		int N, M, W;
		
		cin >> N >> M >> W;
		
		vector<vector<int>> distance(N, vector<int>(N, INF));

		for (int i = 0; i < N; i++)
			distance[i][i] = 0;

		for (int i = 0; i < M; i++) {
			int s, e, w;
			cin >> s >> e >> w;
			distance[s - 1][e - 1] = min(distance[s - 1][e - 1], w);
			distance[e - 1][s - 1] = min(distance[e - 1][s - 1], w);
		}

		for (int i = 0; i < W; i++) {
			int s, e, w;
			cin >> s >> e >> w;
			distance[s - 1][e - 1] = min(distance[s - 1][e - 1], w * (-1));
		}

		if (solution(distance) == true)
			answer.push_back("YES");
		else
			answer.push_back("NO");
	}

	for (int i = 0; i < answer.size(); i++)
		cout << answer[i] << "\n";
}