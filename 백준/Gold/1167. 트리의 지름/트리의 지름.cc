#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef struct treeInfo {
	int nextNode;
	int length;
};

typedef struct Node {
	int curNode;
	int length;
};
vector<vector<treeInfo>> tree;


int maxLength = -1;

int index = 0;

void getMaxLength(int startNode) {

	vector<bool> visited;
	for (int i = 0; i < tree.size(); i++)
		visited.push_back(false);

	queue<Node> nextNode;
	nextNode.push({startNode, 0 });
	visited[startNode] = true;

	while (nextNode.empty() != true) {
		
		Node curNode = nextNode.front(); nextNode.pop();

		if (maxLength < curNode.length) {
			maxLength = curNode.length;
			index = curNode.curNode;
		}

		for (int i = 0; i < tree[curNode.curNode].size(); i++) {
			if (visited[tree[curNode.curNode][i].nextNode] != true) {
				visited[tree[curNode.curNode][i].nextNode] = true;
				Node node = { tree[curNode.curNode][i].nextNode,tree[curNode.curNode][i].length };
				nextNode.push({ node.curNode, curNode.length + node.length });
			}
		}
	}
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n;

	for(int i = 0; i < n; i++)
		tree.push_back({});


	for (int i = 0; i < n; i++) {
		int node; cin >> node;

		node = node - 1;

		while (true) {
			int nextNode; cin >> nextNode;
			
			
			if (nextNode == -1)
				break;

			nextNode = nextNode - 1;

			int length; cin >> length;

			tree[node].push_back({nextNode, length });
		}
	}

	
	getMaxLength(0);
	getMaxLength(index);

	cout << maxLength;
}