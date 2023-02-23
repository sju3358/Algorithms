#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;



int main() {
	int T; cin >> T;

	while (T--) {
		int n; cin >> n;
		
		int maxSum = 0;

		vector<vector<int>> stickers;
		vector<vector<int>> dp;


		//input
		for (int i = 0; i < 2; i++) {
			vector<int> temp;
			vector<int> temp2;
			for (int j = 0; j < n; j++) {
				int cost; cin >> cost;
				temp.push_back(cost);
				temp2.push_back(0);
			}
			stickers.push_back(temp);
			dp.push_back(temp2);
		}



		dp[0][0] = stickers[0][0];
		dp[1][0] = stickers[1][0];


		dp[0][1] = dp[1][0] + stickers[0][1];
		dp[1][1] = dp[0][0] + stickers[1][1];

		int maxCost = 0;
		int cost1, cost2;

		for (int i = 2; i < n; i++) {
			
			maxCost = 0;

			cost1 = dp[1][i - 2] + stickers[0][i];
			cost2 = dp[1][i - 1] + stickers[0][i];
			
			maxCost = max(maxCost, cost1);
			maxCost = max(maxCost, cost2);

			dp[0][i] = maxCost;


			maxCost = 0;

			cost1 = dp[0][i - 2] + stickers[1][i];
			cost2 = dp[0][i - 1] + stickers[1][i];
			
			maxCost = max(maxCost, cost1);
			maxCost = max(maxCost, cost2);
			
			dp[1][i] = maxCost;
		}

		cout << max(dp[1][n - 1], dp[0][n - 1]) << "\n";
	}
}