#include <string>
#include <vector>
#include <queue>

using namespace std;

long long solution(int n, vector<int> works) {
    
    priority_queue<int> works_priority;
    vector<int>::iterator iter;
    long long answer = 0;

    for(iter=works.begin(); iter!= works.end(); iter++)
        works_priority.push(*iter);

    for(int i = 0; i<n; i++)
    {
        if (works_priority.top() == 0){            
            continue;;
        }
        int temp = works_priority.top();
        works_priority.pop();
        works_priority.push(temp - 1);
    }
    
    while(!works_priority.empty()){
        int temp = works_priority.top();
        answer += temp * temp;
        works_priority.pop();
    }
    
    return answer;
}