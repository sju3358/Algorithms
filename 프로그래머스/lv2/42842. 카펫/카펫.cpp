#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;

vector<int> solution(int brown, int yellow) {

    vector<int> answer;

    for(int i = 1; i*i <= yellow ; i++)
    {
        if(yellow % i == 0) { // yellow 타일의 개수를 소인수분해 하여 따져본다.

            int heightOfYellow = i;
            int widthOfBrown = yellow / i;

            int sumOfBrown = 4 + heightOfYellow * 2 + widthOfBrown * 2;

            if (sumOfBrown == brown) {
                //i*i <= yellow 일때까지만 비교하므로 항상 heightOfYellow <= widthOfBrown
                answer.push_back(widthOfBrown + 2);
                answer.push_back(heightOfYellow + 2);
                break;
            }

        }
    }


    return answer;
}

// int main(){
//     for(int sol : solution(10,2))
//         cout << sol << " ";
//     cout << endl;

//     for(int sol : solution(8,1))
//         cout << sol << " ";
//     cout << endl;

//     for(int sol : solution(24,24))
//         cout << sol << " ";
//     cout << endl;
// }
