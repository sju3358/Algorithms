#include <iostream>
#include <vector>

using namespace std;

int count = 0;
int N;

bool isInBoundary(int i, int j, int N){
    return 0 <= i && i < N && 0 <= j && j < N;
}

int dir[][2] = {{0,1},{1,1},{1,0}};

// 0 : 가로 , 1 : 대각, 2 : 세로
void movePiPE(vector<vector<int>>& map, int curI, int curJ, int curDir){

    if(curI == N-1 && curJ == N-1){
        count++;
        return;
    }else{
        int start = 0,end = 0;
        if(curDir == 0){
            start = 0;
            end = 2;
        }
        else if(curDir == 1){
            start = 0;
            end = 3;
        }
        else if(curDir == 2){
            start = 1;
            end = 3;
        }

        for(int i = start; i < end; i++){

            int nextI = curI + dir[i][0];
            int nextJ = curJ + dir[i][1];
            int nextDir = i;

            if(isInBoundary(nextI,nextJ,N) != true)
                continue;
            if(map[nextI][nextJ] == 1)
                continue;

            if(nextDir == 1){

                if(isInBoundary(nextI-1,nextJ,N) != true)
                    continue;
                if(isInBoundary(nextI,nextJ-1,N) != true)
                    continue;
                if(map[nextI-1][nextJ] == 1)
                    continue;
                if(map[nextI][nextJ-1] == 1)
                    continue;
            }

            movePiPE(map,nextI,nextJ,nextDir);
        }
    }
}

int main(){

    cin >> N;
    vector<vector<int>> map(N, vector<int>(N,0));

    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            cin >> map[i][j];

    movePiPE(map,0,1,0);

    cout << count;
}