#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for(int i = 0; i<commands.size();i++){
        int start = commands[i][0] - 1;
        int end = commands[i][1] - 1;
        int k = commands[i][2] - 1;

        vector<int> list;

        for(int j = start; j <= end; j++)
            list.push_back(array[j]);
        sort(list.begin(),list.end());
        answer.push_back(list[k]);
    }

    return answer;
}


// int main() {
//     solution(11,2);
//     return 0;
// }
