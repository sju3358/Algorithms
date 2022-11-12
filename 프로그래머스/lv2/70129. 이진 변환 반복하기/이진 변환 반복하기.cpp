#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    string target = "1";
    int count = 0;
    int sumOfZero = 0;
    
    while(true)
    {
        count++;
        
        //0모두 제거 
        for(int i = 0; i< s.length(); i++)
            if(s.at(i) == '0')
            {
                s = s.substr(0, i) + s.substr(i+1, s.length() - (i+1) );
                sumOfZero++;
                i--;
            }
        
        //s의 길이
        int temp = s.length();
        s = "";    
        
        //s의 길이를 2진수로 표현
        while(temp != 0)
        {
            if(temp % 2 == 0)
                s = "0" + s;
            else
                s = "1" + s;
            temp = temp/2;
        }
        
        if(s.compare(target) == 0)
        {
            answer.push_back(count);
            answer.push_back(sumOfZero);
            break;
        }
    }
    
    
    return answer;
}