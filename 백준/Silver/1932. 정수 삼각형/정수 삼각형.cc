#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;






int solution(int n ,vector<int> inputs) {

	vector<int> dp;
	int cnt = 0;
	dp.push_back(inputs[cnt]);
	cnt++;

	for (int i = 1; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			
			if (j == 0)
				dp.push_back(dp[cnt-i] + inputs[cnt]);
			else if (j == i)
				dp.push_back(dp[cnt - (i+1)] + inputs[cnt]);
			else {
				dp.push_back(max(dp[cnt - (i + 1)], dp[cnt - i]) + inputs[cnt]);
			}

			cnt++;
		}
	}

	int max = -1;
	for (int i = 0; i < dp.size(); i++)
		if (max < dp[i])
			max = dp[i];

	return max;
}

int main() {

	int n;
	vector<int> inputs;

	cin >> n;

	for(int i = 0; i < n; i ++)
		for (int j = 0; j <= i; j++){
			int input;
			cin >> input;
			inputs.push_back(input);
		}

	cout << solution(n,inputs) << endl;
}
