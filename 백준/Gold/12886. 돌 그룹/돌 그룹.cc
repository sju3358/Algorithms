#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;


int solution(vector<int> stones){

    vector<vector<bool>> visited(1001, vector<bool>(1001, false));

    sort(stones.begin(), stones.end());
    queue<vector<int>> nextStones; nextStones.push(stones);
    visited[stones[0]][stones[1]] = true;

    bool canMake = false;

    while(nextStones.empty() != true){

        vector<int> curStones = nextStones.front(); nextStones.pop();

        if(curStones[0] == curStones[1] && curStones[1] == curStones[2]){
            canMake = true;
            break;
        }

        sort(curStones.begin(),curStones.end());


        if(curStones[0] != curStones[1] &&  curStones[0]*2 <= 1000){
            int i = curStones[0]*2;
            int j = curStones[1] - curStones[0];
            int k = curStones[2];
            if(visited[i][j] != true) {
                nextStones.push({i, j, k});
                visited[i][j] = true;
            }
        }

        if(curStones[1] != curStones[2] && curStones[1]*2 <= 1000){
            int i = curStones[0];
            int j = curStones[1]*2;
            int k = curStones[2]- curStones[1];
            if(visited[i][j] != true) {
                nextStones.push({i, j, k});
                visited[i][j] = true;
            }
        }

        if(curStones[0] != curStones[2] && curStones[0]*2 <= 1000){
            int i = curStones[0]*2;
            int j = curStones[1] ;
            int k = curStones[2]- curStones[0];
            if(visited[i][j] != true) {
                nextStones.push({i, j, k});
                visited[i][j] = true;
            }
        }



    }

    if(canMake == false)
        return 0;
    else
        return 1;
}

int main(){

    vector<int> stones(3);
    for(int i = 0; i <3; i++)
        cin >> stones[i];

    cout << solution(stones);
}