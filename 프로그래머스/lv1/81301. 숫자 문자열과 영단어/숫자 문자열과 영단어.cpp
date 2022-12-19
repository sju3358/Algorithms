#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


int stringToInteger(string str){
    string map[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    for(int i = 0; i<10; i++){
        if(str.compare(map[i]) == 0)
            return i;
    }
    return -1;
}


int solution(string s) {

    int answer = 0;
    string temp = "";
    stack<int> result;

    for(int i = 0; i<s.length();i++){

        if('0'<= s[i] && s[i] <= '9')
            result.push(s[i] - '0');
        else{
            temp += s[i];
            int resultOfSToI = stringToInteger(temp);

            if(resultOfSToI != -1){
                result.push(resultOfSToI);
                temp = "";
            }
        }
    }

    int i = 1;
    while(!result.empty()){
        answer += result.top()*i;
        result.pop();
        i *= 10;
    }

    return answer;
}


// int main() {
//     cout << solution("one4seveneight") << endl;
//     cout << solution("23four5six7") << endl;
//     cout << solution("2three45sixseven") << endl;
//     cout << solution("123") << endl;
//     return 0;
// }
