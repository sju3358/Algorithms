#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    
    int r = s % n;
    int q = s / n;
    
    if(n > s)
        answer.push_back(-1);
    else
    {
        for(int i = 0; i < n-r ; i++)
            answer.push_back(q);
        for(int i = 0; i < r ; i++)
            answer.push_back(q+1);
    }
    return answer;
}