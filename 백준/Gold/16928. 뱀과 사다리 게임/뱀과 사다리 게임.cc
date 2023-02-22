#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <unordered_set>
#include <unordered_map>
using namespace std;

typedef struct node {
	int curPos;
	int cost;
}Node;

int dp[101];
unordered_map<int, int> snakes;
unordered_map<int, int> ladders;

void bfs() {

	queue<Node> nextNode;
	nextNode.push({ 1,0 });

	while (nextNode.empty() != true) {
		Node curNode = nextNode.front();
		nextNode.pop();

		if (dp[curNode.curPos] == -1)
			dp[curNode.curPos] = curNode.cost;
		else {
			if (dp[curNode.curPos] > curNode.cost) {
				dp[curNode.curPos] = curNode.cost;
			}
			else
				continue;
		}

		if (curNode.curPos <= 100){

			auto iterOfLadders = ladders.find(curNode.curPos);
			if(iterOfLadders != ladders.end()){
				int nextPos = iterOfLadders->second;
				nextNode.push({ nextPos,curNode.cost});
			}

			auto iterOfSnakes = snakes.find(curNode.curPos);
			if (iterOfSnakes != snakes.end()) {
				int nextPos = iterOfSnakes->second;
				nextNode.push({ nextPos,curNode.cost });
			}

			else {
				
				for (int i = 1; i <= 6; i++) {
					int nextPos = curNode.curPos + i;
					if(nextPos <= 100)
						nextNode.push({ nextPos, curNode.cost + 1 });
				}
			}
		}
	}
}

int main() {

	for (int i = 0; i < 101; i++)
		dp[i] = -1;

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		int startPos, endPos;
		cin >> startPos >> endPos;
		ladders.insert(make_pair(startPos, endPos));
	}

	for (int i = 0; i < m; i++) {
		int startPos, endPos;
		cin >> startPos >> endPos;
		snakes.insert(make_pair(startPos,endPos));
	}
	
	bfs();

	cout << dp[100];
}