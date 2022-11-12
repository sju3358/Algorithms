#include <iostream>
#include <string>
#include <vector>
using namespace std;

int solution(string s)
{
    int answer = -1;
  vector<char> stringStack;

    for(int i = 0; i<s.length(); i++)
    {
        if(stringStack.empty())
            stringStack.push_back(s.at(i));
        else 
        {
            if(stringStack.back()  == s.at(i))
                stringStack.pop_back();
            else
                stringStack.push_back(s.at(i));
        }   
    }

    if(stringStack.size() > 0)
        answer =0;
    else
        answer = 1;

    return answer;
}