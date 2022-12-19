#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


string solution(string phone_number) {
    for(int i = 0 ; i<phone_number.length()-4;i++){
        phone_number[i] = '*';
    }
    return phone_number;
}


// int main() {
//     solution(11,2);
//     return 0;
// }
