#include<string>
#include <iostream>
#include <vector>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<char> charStack;
    
    for(int i = 0; i<s.length(); i++)
    {
        char temp = s.at(i);
        
        if(temp == '(')
            charStack.push_back(temp);
        else if(temp == ')')
        {
            if(charStack.size() == 0)
                charStack.push_back(temp);
            else
            {
                if(charStack.back() == '(')
                    charStack.pop_back();
                else
                    charStack.push_back(temp);
            }
        }
    }
    
    if(charStack.size() == 0)
        answer = true;
    else
        answer = false;

    return answer;
}