#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int solution(vector<int> arr){

}

int main (void){

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n; cin >> n;

    int dp[1000] = {0,};
    dp[0] = 1;
    dp[1] = 2;

    for(int i = 2; i <n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2])%10007;
    }
    cout << dp[n-1];
}