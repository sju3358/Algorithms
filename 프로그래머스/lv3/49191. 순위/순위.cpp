#include <string>
#include <vector>
#include <queue>
#include <iostream>

#define INF 2100000000

using namespace std;

bool dfs(vector<vector<bool>> players, int startNode, vector<vector<bool>> &resultMap) {

	vector<bool> visited(players.size(), false);

	queue<int> nextNode;
	nextNode.push(startNode);
	visited[startNode] = true;

	while (nextNode.empty() != true) {
		int curNode = nextNode.front(); nextNode.pop();

		for (int i = 0; i < players.size(); i++) {
			
			if (visited[i] == true)
				continue;

			if (players[curNode][i] == true) {
				visited[i] = true;
				resultMap[startNode][i] = true;
				nextNode.push(i);
			}
		}
	}
	

	return true;
}

bool isAnswer(vector<vector<bool>> resultMap, int player) {

	
	for (int i = 0; i < resultMap.size(); i++) {
		if (resultMap[player][i] == false) {
			if (resultMap[i][player] == true)
				continue;
			else
				return false;
		}
	}

	return true;
}

int solution(int n, vector<vector<int>> results) {

	
	vector<vector<bool>> players(n, vector<bool>(n,false));
	vector<vector<bool>> resultMap(n, vector<bool>(n, false));

	for (int i = 0; i < n; i++) {
		players[i][i] = true;
		resultMap[i][i] = true;
	}

	for (int i = 0; i < results.size(); i++) {
		int winner = results[i][0] - 1;
		int loser = results[i][1] - 1;
		players[loser][winner] = true;
	}

	for (int i = 0; i < n; i++)
		dfs(players,i, resultMap);
	
	int answer = 0;
	
	for (int i = 0; i < n; i++)
		if (isAnswer(resultMap,i))
			answer++;

	return answer;
}	

int main() {
	cout << solution(5, { {4, 3},{4, 2},{3, 2},{1, 2},{2, 5} });
}