#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>

using namespace std;

int answer;
set<int> s;
set<int>::iterator iter;

bool isPrime(int num){

    if(num < 2)
        return false;

    for(int i = 2; i*i <= num; i++)
        if(num % i == 0)
            return false;
    return true;
}

int stringToInt(string number){
    int num = 0;

    int pivot = 1;
    for(int i = number.length()-1; i>=0; i--){
        num += pivot * (number[i] - '0');
        pivot *= 10;
    }
    return num;
}


void getPrime(string number, vector<char> inputs, vector<bool> isVisit,int visitiedIndex){
    if(number.length() > inputs.size())
        return;
    
    int numberToInt = stringToInt(number);
    iter = s.find(numberToInt);
    if(iter != s.end())
        return;

    if(visitiedIndex != -1)
        isVisit[visitiedIndex] = true;

    s.insert(numberToInt);
    
    if(isPrime(numberToInt))
        answer++;
    
    
    for(int i = 0; i < inputs.size(); i++){
        if(isVisit[i] == true)
            continue;
        getPrime(number+inputs[i],inputs,isVisit,i);
    }
}



int solution(string number) {
    
    answer = 0;
    s.clear();
    
    vector<char> inputs;
    vector<bool> isVisited;
    for(int i = 0; i <number.length(); i++){
        inputs.push_back(number[i]);
        isVisited.push_back(false);
    }

    getPrime("",inputs,isVisited,-1);
    return answer;
}

int main (void){
    cout << solution("17") << endl;
    cout << solution("011") << endl;
}