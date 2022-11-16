#include <string>
#include <vector>

using namespace std;

int solution(int order) {
    int answer = 0;
    
    while(order){
        int temp = order % 10;
        if(temp == 3 || temp == 6 || temp == 9)
            answer ++;
        order = order / 10;
    }
    
    return answer;
}