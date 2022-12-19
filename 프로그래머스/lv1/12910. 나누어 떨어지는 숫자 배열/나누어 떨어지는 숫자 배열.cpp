#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    for(int i = 0; i<arr.size(); i++){
        if(arr[i] % divisor == 0)
            answer.push_back(arr[i]);
    }
    if(answer.size() == 0)
        answer.push_back(-1);
    sort(answer.begin(),answer.end());
    return answer;
}


// int main() {
//     solution({{1},{2}},{{3},{4}});
//     return 0;
// }
