#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


int solution(vector<int> numbers) {
    int arr[10] = {0,};
    int answer = 0;
    for(int i = 0; i<numbers.size(); i++){
        arr[numbers[i]] = 1;
    }

    for(int i = 0; i<=9; i++){
        if(arr[i] == 0)
            answer += i;
    }

    return answer;
}


// int main() {
//     solution({1,2,3,4,6,7,8,0});
//     return 0;
// }
