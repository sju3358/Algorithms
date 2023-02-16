#include <iostream>
#include <vector>

using namespace std;

int dp[50001];
vector<int> v;


int dfs(int n) {

	if (n < 0)
		return 2100000000;

	if (dp[n] != -1)
		return dp[n];
	else {
		int min = 5;

		for (int i = v.size()-1; i >= 0; i--) {
			int cost = dfs(n - v[i]) + 1;
			if (min > cost)
				min = cost;
		}

		return dp[n] = min;
	}
}

int main() {

	int n; cin >> n;

	dp[0] = 0;
	for (int i = 1; i < 50001; i++)
		dp[i] = -1;

	for (int i = 1; i*i <= n; i++)
		v.push_back(i*i);

	cout << dfs(n);

}