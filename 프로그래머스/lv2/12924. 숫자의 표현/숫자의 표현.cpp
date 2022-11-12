#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int sum = 0;
    
    for(int i = 1; i<= n ; i++)
    {
        for(int j = i; j<=n; j++)
        {
            sum = sum+j;
            if(sum == n)
            {
                answer++;
                break;
            }
            else if(sum > n)
                break;
        }
        sum = 0;
    }
    
    return answer;
}