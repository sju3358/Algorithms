#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

typedef struct node{
    int pos;
    int cost;
}Node;

vector<int> dp(200001,100001);

int minCost = 200001;
int minCostCount = 0;

void search(int start, int target){

    queue<Node> nextPos;

    nextPos.push({start,0});
    dp[start] = 0;

    while(nextPos.empty() != true){
        Node curPos = nextPos.front(); nextPos.pop();

        if(curPos.pos == target) {
            if (curPos.cost == minCost) {
                minCostCount++;
                continue;
            }
            else if (curPos.cost < minCost) {
                minCostCount = 1;
                minCost = curPos.cost;
                continue;
            }
            else
                continue;
        }
        else {

            if (curPos.pos > 0 && curPos.pos * 2 <= target * 2 && dp[curPos.pos*2] >= curPos.cost+1){
                dp[curPos.pos * 2] = curPos.cost+1;
                nextPos.push({curPos.pos*2,curPos.cost+1});
            }

            if(curPos.pos + 1 <= target && dp[curPos.pos + 1] >= curPos.cost+1){
                dp[curPos.pos + 1] = curPos.cost+1;
                nextPos.push({curPos.pos+1,curPos.cost+1});
            }

            if(curPos.pos-1 >= 0 && dp[curPos.pos - 1] >= curPos.cost+1){
                dp[curPos.pos - 1] = curPos.cost+1;
                nextPos.push({curPos.pos-1,curPos.cost+1});
            }
        }
    }
}

int main(void){
    int start, target; cin >> start >> target;

    search(start,target);

    cout << minCost << "\n";
    cout << minCostCount << "\n";
}