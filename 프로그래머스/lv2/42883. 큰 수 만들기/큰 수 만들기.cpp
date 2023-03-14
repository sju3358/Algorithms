#include <string>
#include <vector>
#include <iostream>
#include <stack>

using namespace std;

string solution(string number, int k) {

    stack<char> numbers;

    for(int i = 0; i < number.length(); i++){

        if(k == 0){
            numbers.push(number[i]);
            continue;
        }

        if(numbers.empty() == true) {
            numbers.push(number[i]);
        }
        else{
            if(numbers.top() >= number[i])
                numbers.push(number[i]);
            else{
                while(numbers.empty() != true && k > 0){
                    if(numbers.top() < number[i]){
                        k--;
                        numbers.pop();
                    }
                    else
                        break;
                }
                numbers.push(number[i]);
            }
        }
    }

    while(k > 0){
        numbers.pop();
        k--;
    }
    string answer = "";

    while(numbers.empty() != true){
        answer = numbers.top() + answer;
        numbers.pop();
    }

    
    return answer;

}

int main(void){
    cout << solution("1924",2) << endl;
    cout << solution("54525",2) << endl;
}