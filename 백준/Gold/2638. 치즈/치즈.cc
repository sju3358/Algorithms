#include <vector>
#include <queue>
#include <iostream>

using namespace std;

typedef struct node{
    int i;
    int j;
}Node;

int N,M;


bool check(vector<vector<int>> map){
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            if(map[i][j] != 0)
                return false;
    return true;
}

bool isInBoundary(int i, int j){
    return 0 <= i && i < N && 0 <= j && j < M;
}

void searchBlankSpaces(vector<vector<int>>& map, vector<vector<bool>>& visited){


    queue<Node> nextNode;
    int dir[][2] = {{-1,0},{1,0},{0,1},{0,-1}};
    nextNode.push({0,0});
    visited[0][0] = true;

    while(nextNode.empty() != true){
        Node curNode = nextNode.front(); nextNode.pop();

        for(int i = 0; i <4; i++){
            int nextI = curNode.i + dir[i][0];
            int nextJ = curNode.j + dir[i][1];

            if(isInBoundary(nextI,nextJ) != true)
                continue;

            if(visited[nextI][nextJ] == true)
                continue;

            if(map[nextI][nextJ] == 1)
                continue;

            map[nextI][nextJ] = 0;
            visited[nextI][nextJ] = true;

            nextNode.push({nextI,nextJ});
        }
    }
}

void searchInnerSpaces(vector<vector<int>>&map, vector<vector<bool>>& visited){
    for(int i = 0; i < N; i++)
        for(int j = 0; j < M; j++)
            if(map[i][j] == 0 && visited[i][j] == false) {
                map[i][j] = 2;
                visited[i][j] = true;
            }
}

vector<Node> searchTargetCheeses(vector<vector<int>> map, vector<vector<bool>>& visited,int startI,int startJ){

    queue<Node> nextNode;
    int dir[][2] = {{-1,0},{1,0},{0,1},{0,-1}};
    nextNode.push({startI,startJ});
    visited[startI][startJ] = true;

    vector<Node> cheeses;

    while(nextNode.empty() != true){
        Node curNode = nextNode.front(); nextNode.pop();

        int cnt = 0;

        for(int i = 0; i <4; i++){
            int nextI = curNode.i + dir[i][0];
            int nextJ = curNode.j + dir[i][1];

            if(isInBoundary(nextI,nextJ) != true)
                continue;

            if(map[nextI][nextJ] == 0)
                cnt++;

            if(visited[nextI][nextJ] == true)
                continue;

            if(map[nextI][nextJ] != 1)
                continue;

            visited[nextI][nextJ] = true;

            nextNode.push({nextI,nextJ});
        }

        if(cnt >= 2)
            cheeses.push_back(curNode);
    }

    return cheeses;
}


int main(){
    cin >> N >> M;

    vector<vector<int>> map(N,vector<int>(M));

    for(int i = 0; i < N; i++)
        for(int j = 0; j < M ; j++)
            cin >> map[i][j];


    int time = 0;

    while(check(map) != true) {
        vector<vector<bool>> visited(N, vector<bool>(M,false));

        searchBlankSpaces(map,visited); // 빈칸 찾기. --> 0인부분 방문체크, 2인곳 0으로 변경
        searchInnerSpaces(map,visited); // 치즈 내부공간 찾기. --> 0인데 방문안한곳 2로 변경

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++){
                if(visited[i][j] == true)
                    continue;

                // 녹을 치즈 리스트 찾기.
                vector<Node> targetCheeses = searchTargetCheeses(map,visited,i,j);

                // 녹을 치즈 0으로 변경
                for(int k = 0; k < targetCheeses.size(); k++)
                    map[targetCheeses[k].i][targetCheeses[k].j] = 0;
            }
        time++;
    }

    cout << time;
}