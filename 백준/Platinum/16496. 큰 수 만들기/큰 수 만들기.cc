#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;



bool compare(string a, string b) {

    string targetA = a + b;
    string targetB = b + a;

    return targetA > targetB;
}


string solution(vector<int>& numbers){

    string answer = "";

    vector<string> stringsOfNumbers;
    for (int i = 0; i < numbers.size(); i++) {
        stringsOfNumbers.push_back(to_string(numbers[i]));
    }

    sort(stringsOfNumbers.begin(), stringsOfNumbers.end(), compare);

    for (int i = 0; i < stringsOfNumbers.size(); i++)
        answer += stringsOfNumbers[i];

    if (answer[0] == '0')
        answer = "0";

    return answer;

}

int main(void) {
    int n; cin >> n;
    vector<int> numbers(n);
    for(int i = 0; i < n; i++){
        int number; cin >> number;
        numbers[i] = number;
    }
    cout << solution(numbers);
}