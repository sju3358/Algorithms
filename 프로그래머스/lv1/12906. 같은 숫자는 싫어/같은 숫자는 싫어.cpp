#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    int curValue = -1;    
    for(int i = 0; i< arr.size(); i++){
        if(arr[i] == curValue){
            continue;
        }
        else{
            curValue = arr[i];
            answer.push_back(curValue);
        }
    }

    

    return answer;
}