#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int dp[1000001] = {0,1};
    
    int answer = 0;
    
    if(n == 0)
        answer = 0;
    else if(n == 1)
        answer = 1;
    else{
        for(int i = 2; i<=n; i++)
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        answer = dp[n];
    }
        
    
    
    return answer;
}