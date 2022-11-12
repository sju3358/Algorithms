#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int row, col;
    
    for(int i = 1; i<= yellow; i++)
    {
        if(yellow % i == 0)
        {
            int temp1 = i;
            int temp2 = yellow / i;
            
            int flag = 4 + temp1*2 + temp2*2;
            
            if(flag == brown)
            {
                row = temp1 > temp2 ? temp1 : temp2;
                col = temp1 > temp2 ? temp2 : temp1;
                row += 2;
                col += 2;
                break;
            }
            
        }
    }
    answer.push_back(row);
    answer.push_back(col);
    
    return answer;
}