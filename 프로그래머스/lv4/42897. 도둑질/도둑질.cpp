#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> money) {
	
	vector<int> dp(money.size(), 0);

	int answer = 0;

	dp[0] = money[0];
	dp[1] = money[0];
	
	for (int i = 2; i < dp.size() - 1; i++)
		dp[i] = max(dp[i - 2] + money[i], dp[i - 1]);
	dp[dp.size() - 1] = dp[dp.size() - 2];

	answer = max(answer, dp[dp.size() - 1]);

	dp[0] = 0;
	dp[1] = money[1];

	for (int i = 2; i < dp.size(); i++)
		dp[i] = max(dp[i - 2] + money[i], dp[i - 1]);

	answer = max(answer, dp[dp.size() - 1]);
	
	return answer;
}

int main() {
	cout << solution({ 1,2,3,1 });
}