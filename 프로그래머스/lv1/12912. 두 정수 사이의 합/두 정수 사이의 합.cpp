#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


long long solution(int a, int b) {
    long long answer = 0;
    int start = a < b ? a : b;
    int end = a > b ? a : b;
    for(long i = start; i <=end; i++)
        answer += i;
    return answer;
}


// int main() {
//     solution({{1},{2}},{{3},{4}});
//     return 0;
// }
