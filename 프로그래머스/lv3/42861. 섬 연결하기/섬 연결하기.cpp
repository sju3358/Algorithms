#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

struct compare{
	bool operator()(vector<int> a, vector<int> b){
		return a[2] > b[2];
	}
};

int getParent(int node, vector<int>& parent) {
	if (parent[node] == node) return node;
	return getParent(parent[node], parent);
}

//두 노드를 작은값을 기준으로 연결합니다. 
void unionParent(int node1, int node2, vector<int>& parent) {
	node1 = getParent(node1, parent);
	node2 = getParent(node2, parent);
	if (node1 < node2) parent[node2] = node1;
	else parent[node1] = node2;
}

//싸이클이 존재하면 true, 아니면 false를 반환
bool isCycle(int node1, int node2, vector<int>& parent) {
	node1 = getParent(node1, parent);
	node2 = getParent(node2, parent);
	if (node1 == node2) return true;
	else return false;
}


int solution(int n, vector<vector<int>> costs) {
	int answer = 0;

	priority_queue < vector<int>, vector<vector<int>>, compare> edgeList;

	for (int i = 0; i < costs.size(); i++)
		edgeList.push(costs[i]);

	vector<int> parent;
	for (int i = 0; i < n; i++)
		parent.push_back(i);

	while (edgeList.empty() != true) {
		vector<int> curEdge = edgeList.top();
		edgeList.pop();

		if (isCycle(curEdge[0], curEdge[1], parent) == false) {
			answer += curEdge[2];
			unionParent(curEdge[0], curEdge[1], parent);
		}
	}

	return answer;
}

int main() {
	solution(4, { {0, 1, 1},{0, 2, 2},{1, 2, 5},{1, 3, 1},{2, 3, 8} });
}