#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    answer.push_back(arr[0]);
    int curValue = -1;
    
    for(int i = 1; i< arr.size(); i++){
        if(arr[i] == arr[i-1])
            continue;
        else
            answer.push_back(arr[i]);
    }
    
    return answer;
}