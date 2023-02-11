#include <iostream>
#include <queue>
#include <vector>
using namespace  std;

int main (){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


    int dp[11] = {0,};

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;



    for(int i =4; i <11; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i-3];
    }

    int n; cin>>n;
    for(int i  =0; i <n; i++) {
        int m; cin >> m;
        cout << dp[m] << '\n';
    }
}