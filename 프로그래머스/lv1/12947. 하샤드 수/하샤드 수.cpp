#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


bool solution(int x) {
    bool answer = true;
    int hashard = 0;
    int input = x;
    while(input){
        hashard += input % 10;
        input /= 10;
    }
    if(x % hashard == 0)
        answer = true;
    else
        answer = false;
    return answer;
}


// int main() {
//     solution(11);
//     return 0;
// }
