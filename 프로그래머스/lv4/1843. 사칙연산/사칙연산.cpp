#include <vector>
#include <string>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<string> arr){
    int countOfOperand = arr.size() / 2 + 1;

    vector<vector<int>> maxDp(countOfOperand, vector<int>(countOfOperand, -2100000000));
    vector<vector<int>> minDp(countOfOperand, vector<int>(countOfOperand,  2100000000));

    for(int i = 0; i < countOfOperand; i++)
        minDp[i][i] = maxDp[i][i] = stoi(arr[i*2]);


    for(int cnt = 1; cnt < countOfOperand; cnt++)
        for(int from = 0; from < countOfOperand - cnt; from++) {

            int to = from + cnt;

            for (int pivot = from; pivot < to; pivot++) {

                int operand = pivot*2+1;

                if(arr[operand].compare("+") == 0){
                    maxDp[from][to] = max(maxDp[from][to], maxDp[from][pivot] + maxDp[pivot+1][to]);
                    minDp[from][to] = min(minDp[from][to], minDp[from][pivot] + minDp[pivot+1][to]);
                }
                else{
                    maxDp[from][to] = max(maxDp[from][to], maxDp[from][pivot] - minDp[pivot+1][to]);
                    minDp[from][to] = min(minDp[from][to], minDp[from][pivot] - maxDp[pivot+1][to]);
                }
            }
        }

    return maxDp[0][countOfOperand-1];
}

// int main(void){
//     cout << solution({"5", "-", "3", "+", "1", "+", "2", "-", "4"}	);
// }