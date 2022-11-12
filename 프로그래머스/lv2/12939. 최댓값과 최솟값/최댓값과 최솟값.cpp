#include <string>
#include <vector>
#include <sstream>
#include <limits>

using namespace std;

string solution(string s) {
    string answer;
    size_t index = 0;
    size_t current;
    current = s.find(' ');
    vector<long long> intBuffer;
    long long min = 9000000000000000000;
    long long max = -9000000000000000000;
    
    s =  s + ' ';
    
    while(current != string::npos){
        intBuffer.push_back(stoll(s.substr(index, current - index)));
        index = current + 1;
        current = s.find(' ',index);
    }
    
    for(int i = 0; i<intBuffer.size(); i++)
    {
        if(intBuffer[i] < min)
            min = intBuffer[i];
        if(intBuffer[i] > max)
            max = intBuffer[i];
    }
    
    
    answer = to_string(min) + " " + to_string(max);
    return answer;
}