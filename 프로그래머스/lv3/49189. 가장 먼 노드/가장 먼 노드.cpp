#include <string>
#include <vector>
#include <queue>
#include <iostream>

#define INF 2100000000

using namespace std;

int solution(int n, vector<vector<int>> edge) {

	
	vector<vector<int>> map(n);

	for (int i = 0; i < edge.size(); i++) {
		
		int node1 = edge[i][0] - 1;
		int node2 = edge[i][1] - 1;

		map[node1].push_back(node2);
		map[node2].push_back(node1);
	}

	vector<int> distance(map.size(), INF);
	vector<bool> visited(map.size(), false);

	distance[0] = 0;
	
	queue<int> nextNode; nextNode.push(0);

	while (nextNode.empty() != true) {

		int curNode = nextNode.front(); nextNode.pop();

		for (int i = 0; i < map[curNode].size(); i++) {
			
			int targetNode = map[curNode][i];

			if (visited[targetNode] == true)
				continue;
			
			visited[targetNode] = true;
			nextNode.push(targetNode);

			if (distance[targetNode] > distance[curNode] + 1)
				distance[targetNode] = distance[curNode] + 1;
		}
	}

	int maxLength = -1;

	for (int i = 0; i < distance.size(); i++)
		if (maxLength < distance[i])
			maxLength = distance[i];

	int answer = 0;

	for (int i = 0; i < distance.size(); i++)
		if (distance[i] == maxLength)
			answer++;
	
	return answer;
	
}	

int main() {
	solution(6, { {3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2} });
}