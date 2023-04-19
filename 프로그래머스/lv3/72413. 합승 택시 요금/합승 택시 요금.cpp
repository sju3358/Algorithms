#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {

    vector<vector<int>> dp(n, vector<int>(n,2000001));

    for(int i = 0; i < n; i++)
        dp[i][i] = 0;

    for(int i = 0; i < fares.size(); i++){
        int from = fares[i][0] - 1;
        int to = fares[i][1] - 1;
        int weight = fares[i][2];
        dp[from][to] = dp[to][from] = weight;
    }

    for(int k = 0; k < n; k++)
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j]);


    int minCost = dp[s-1][a-1] + dp[s-1][b-1];
    
    for(int i = 0; i < n; i++)
        minCost = min(minCost, dp[s-1][i] + dp[i][a-1] + dp[i][b-1]);
    
    return minCost;
}