#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


bool solution(string s) {
    if(s.length() != 4 && s.length() != 6)
        return false;
    for(int i = 0; i < s.length(); i++)
        if(s[i] < '0' || '9' < s[i])
            return false;
    return true;
}


// int main() {
//     solution(11,2);
//     return 0;
// }
