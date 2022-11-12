#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    bool isEmpty = true;
    for(int i = 0; i < s.length(); i++)
    {
        if(s.at(i) == ' '){
            isEmpty = true;
            answer += ' ';
            continue;
        }
        
         char temp = s.at(i);
        
        if(isEmpty){  
            if('a' <= temp && temp <= 'z')
                temp = temp - 32;
            isEmpty = false;
        }
        else
        {
            if('A' <= temp && temp <= 'Z')
                temp = temp + 32;
        }
        answer += temp;
    }
    
    return answer;
}