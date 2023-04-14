#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> dp(1001,vector<int>(1001,-1));

int nCm(int n, int m){

    if(m == 0 || n== m)
        return 1;

    if(dp[n][m] != -1)
        return dp[n][m];

    return dp[n][m] = (nCm(n-1,m-1) + nCm(n-1,m))%10007;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int n,m; cin >> n >> m;
    cout << nCm(n,m);

}