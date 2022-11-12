#include <string>
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    
    int answer = 0;
    int dp[101][101] = {1, };
    

    //초기화
    for(int i = 0; i<101; i++)
        for(int j = 0; j<101; j++)
            dp[i][j] = -1;
    
    //웅덩이 설정
    for(int i = 0; i<puddles.size(); i++)
    {
        dp[puddles[i][1]][puddles[i][0]] = 0;
    }

    //탐색
    dp[1][1] = 1;
    for(int i = 1; i<= n; i++)
    {
        for(int j = 1; j<=m; j++)
        {
            if(dp[i][j] == -1)
            {
                int temp1, temp2;
                if(i > 1)
                    temp1 = dp[i-1][j];
                else
                    temp1 = 0;

                if( j > 1)
                    temp2 = dp[i][j-1];
                else
                    temp2 = 0;
                
                dp[i][j] = (temp1 + temp2) % 1000000007;
            }
        }
    }

    answer = dp[n][m];
    
    return answer;
}