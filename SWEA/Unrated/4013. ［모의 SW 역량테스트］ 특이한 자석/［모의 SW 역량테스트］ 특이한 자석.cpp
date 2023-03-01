#include <deque>
#include <iostream>
#include <vector>
#include <queue>

using namespace  std;

typedef struct roateInfo{
    int magnetIndex;
    int dir;
}RotateInfo;

void rotateMagnets(int magnetIndex, int dir, vector<deque<int>>& magnets){

    bool visited[4] = {false,false,false,false};
    queue<RotateInfo> nextRotate;
    visited[magnetIndex] = true;
    nextRotate.push({magnetIndex,dir});

    while(nextRotate.empty() != true){
        RotateInfo curRotate = nextRotate.front(); nextRotate.pop();

        //왼쪽 자석
        if(curRotate.magnetIndex - 1 >= 0){
            int nextIndex = curRotate.magnetIndex - 1;

            if(visited[nextIndex] != true) {

                visited[nextIndex] = true;

                if (magnets[nextIndex][2] != magnets[curRotate.magnetIndex][6])
                    nextRotate.push({nextIndex, curRotate.dir * -1});
            }
        }


        //오른쪽 자석
        if(curRotate.magnetIndex + 1 < 4){
            int nextIndex = curRotate.magnetIndex + 1;

            if(visited[nextIndex] != true) {
                
                visited[nextIndex] = true;

                if (magnets[nextIndex][6] != magnets[curRotate.magnetIndex][2])
                    nextRotate.push({nextIndex, curRotate.dir * -1});
            }
        }

        //현재자석 돌리기.
        if(curRotate.dir == 1){
            int temp = magnets[curRotate.magnetIndex].back();
            magnets[curRotate.magnetIndex].pop_back();
            magnets[curRotate.magnetIndex].push_front(temp);
        }

        if(curRotate.dir == -1){
            int temp = magnets[curRotate.magnetIndex].front();
            magnets[curRotate.magnetIndex].pop_front();
            magnets[curRotate.magnetIndex].push_back(temp);
        }
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int T; cin >> T;

    for(int t = 1 ; t <= T; t++){

        int k; cin >> k;

        vector<deque<int>> magnets;

        for(int i = 0; i < 4; i++){
            deque<int> magnet;
            for(int j = 0 ; j < 8; j++){
                int pole; cin >> pole;
                magnet.push_back(pole);
            }
            magnets.push_back(magnet);
        }

        while(k--){
            int magnetIndex; cin >> magnetIndex;
            int dir; cin >> dir;
            rotateMagnets(magnetIndex-1,dir,magnets);
        }

        int score = 0;
        if(magnets[0].front() == 1)
            score += 1;
        if(magnets[1].front() == 1)
            score += 2;
        if(magnets[2].front() == 1)
            score += 4;
        if(magnets[3].front() == 1)
            score += 8;

        cout << "#" << t << " " << score << "\n";
    }
}