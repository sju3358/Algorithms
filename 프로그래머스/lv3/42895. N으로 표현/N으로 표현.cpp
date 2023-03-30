#include <string>
#include <vector>
#include <iostream>
#include <set>
using namespace std;

int solution(int N, int number) {

	set<int> dp[9];

	//n, nn, nnn, nnnn...
	for (int cnt = 1, number = N; cnt <= 8; cnt++) {
		dp[cnt].insert(number);
		number = number * 10 + N;
	}
	
	//dp[3] = dp[2] + dp[1]
	//dp[2] = dp[1] + dp[1] ....

	for (int n = 2; n <= 8; n++) {
		
		for (int index = 1; index < n; index++) {
			
			for(auto iter1 = dp[index].begin(); iter1 != dp[index].end(); iter1++)
				for (auto iter2 = dp[n - index].begin(); iter2 != dp[n - index].end(); iter2++) {
					int num1 = *iter1;
					int num2 = *iter2;
					

					dp[n].insert(num1*num2);

					if(num1 + num2 != 0)
						dp[n].insert(num1 + num2);
					
					if ((num1 - num2) != 0)
						dp[n].insert(num1 - num2);

					if ((num1 / num2) > 0)
						dp[n].insert(num1 / num2);
				}
		}
	}

	for (int i = 1; i <= 8; i++) {
		auto iter = dp[i].find(number);
		if (iter != dp[i].end())
			return i;
	}

	return -1;
	
}

int main() {
	cout << solution(5, 12) << "\n";
	cout << solution(2, 11) << "\n";
}