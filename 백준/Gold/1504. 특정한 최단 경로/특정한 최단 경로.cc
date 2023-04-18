#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;




int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n,m;
    cin >> n >> m;

    vector<vector<int>> dp(n, vector<int>(n,20000001));


    for(int i = 0; i < m; i++){
        int from,to,weight;
        cin >> from >> to >> weight;

        dp[from-1][to-1] = dp[to-1][from-1] = weight;
    }

    for(int i = 0; i < n ; i++)
        dp[i][i] = 0;

    for(int mid = 0; mid < n; mid++)
        for(int from = 0; from < n; from++)
            for(int to = 0;  to < n; to++)
                dp[from][to] = min(dp[from][to], dp[from][mid] + dp[mid][to]);


    int l1,l2;
    cin >> l1 >> l2;

    int cost1 = 0;
    cost1 += dp[0][l1-1];
    cost1 += dp[l1-1][l2-1];
    cost1 += dp[l2-1][n-1];

    int cost2 = 0;
    cost2 += dp[0][l2-1];
    cost2 += dp[l2-1][l1-1];
    cost2 += dp[l1-1][n-1];

    int cost = min(cost1,cost2);
    
    if(cost > 20000000)
        cout << -1;
    else
        cout << cost;
}