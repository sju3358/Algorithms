#include <string>
#include <vector>
#include <iostream>
using namespace std;

int dp[1000001];

bool isPrime(int n) {
	for (int i = 2; i*i <= n; i++)
		if (n % i == 0)
			return false;
	return true;
}


int solution(int n) {
	int answer = 0;

	for (int i = 0; i < 1000001; i++)
		dp[i] = -1;

	for (int i = 2; i <= n; i++) {
		
		if (dp[i] != -1) {
			if (dp[i] == 1)
				answer++;
		}
		else {
			bool isFlag = isPrime(i);
			if (isFlag == true) {
				answer++;
				dp[i] = true;
				
				for (int j = 2; i*j <= n; j++)
					dp[i*j] = 0;
			}
		}

	}

	return answer;
}

// int main() {
	
// 	cout << solution(5);
// }
