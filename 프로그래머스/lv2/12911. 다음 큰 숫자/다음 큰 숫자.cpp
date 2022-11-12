#include <string>
#include <vector>

using namespace std;

int countOfOne(int n)
{
    int value = 0;
    
    while(n != 0)
    {
        if(n%2 == 1)
            value++;
        n = n/2;
    }
    
    return value;
}

int solution(int n) {
    int answer = 0;
    
    int target = countOfOne(n);
    n = n+1;
    while(n)
    {
        if(target == countOfOne(n))
        {
            answer = n;
            break;
        }
        n++;
    }
    
    
    return answer;
}