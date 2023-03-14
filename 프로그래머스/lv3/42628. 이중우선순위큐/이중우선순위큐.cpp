#include <string>
#include <vector>
#include <set>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    multiset<int> dualPrioirtyQueue;

    for(int i = 0; i < operations.size(); i++){
        string input = operations[i];

        if(input[0] =='I'){
            input = input.substr(2);
            dualPrioirtyQueue.insert(stoi(input));
        }
        else{
            input = input.substr(2);

            if(stoi(input) == 1){
                if(dualPrioirtyQueue.empty() != true){
                    auto iter = dualPrioirtyQueue.end();
                    iter--;
                    dualPrioirtyQueue.erase(iter);
                }
            }
            else{
                if(dualPrioirtyQueue.empty() != true){
                    auto iter = dualPrioirtyQueue.begin();
                    dualPrioirtyQueue.erase(iter);
                }
            }
        }
    }


    if(dualPrioirtyQueue.empty() == true){
        answer.push_back(0);
        answer.push_back(0);
    }
    else{
        auto iter = dualPrioirtyQueue.end(); iter--;
        answer.push_back(*iter);
        iter = dualPrioirtyQueue.begin();
        answer.push_back(*iter);
    }

    return answer;
}

int main(){
    for(int num : solution({"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))
        cout << num;
}