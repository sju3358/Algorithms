#include <iostream>
#include <queue>

using namespace std;

int n;
int k;
int minCost = 2100000000;
int dp[200001];

typedef struct Node{
	int curPos;
	int cost;
}Node;

void findK(int curPos, int cost) {

	queue<Node> dfs_queue;

	dfs_queue.push({ curPos,cost });

	while (dfs_queue.empty() != true) {
		Node curNode = dfs_queue.front();
		dfs_queue.pop();


		if (curNode.curPos == k) {
			if (minCost > curNode.cost)
				minCost = curNode.cost;
		}
		

		if (curNode.curPos < k) {
			if (curNode.curPos * 2 < 2 * k) {
				if (dp[curNode.curPos * 2] == -1 || dp[curNode.curPos] > curNode.curPos) {
					dp[curNode.curPos] = curNode.cost;
					dfs_queue.push({ curNode.curPos * 2, curNode.cost});
				}
			}

			if (curNode.curPos + 1 <= k + 1) {
				if (dp[curNode.curPos + 1] == -1 || dp[curNode.curPos] > curNode.curPos) {
					dp[curNode.curPos] = curNode.cost;
					dfs_queue.push({ curNode.curPos + 1, curNode.cost + 1 });
				}
			}
		}

		if (curNode.curPos - 1 > 0) {
			if (dp[curNode.curPos  -1] == -1 || dp[curNode.curPos] > curNode.curPos) {
				dp[curNode.curPos] = curNode.cost;
				dfs_queue.push({ curNode.curPos - 1, curNode.cost + 1 });
			}

		}
	}
}

int main() {

	cin >> n >> k;

	for (int i = 0; i < 200001; i++)
		dp[i] = -1;
	
	if (n >= k)
		cout << n - k;
	else {
		if (n == 0)
			findK(1, 1);
		else
			findK(n, 0);

		cout << minCost;
	}

	

}