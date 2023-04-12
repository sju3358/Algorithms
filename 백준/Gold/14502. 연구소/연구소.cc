#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

typedef struct node{
    int i;
    int j;
}Node;

int dir[][2] = {{-1,0},{1,0},{0,-1},{0,1}};

bool isInBoundary(int i, int j, int N, int M){
    return 0 <= i && i < N && 0 <= j && j < M;
}

int getSafeZone(vector<vector<int>> map){
    int safeZone = 0;

    for(int i = 0; i < map.size(); i++)
        for(int j = 0; j < map[0].size(); j++)
            if(map[i][j] == 0)
                safeZone++;
    return safeZone;
}

int trySolution(vector<vector<int>> map, vector<Node> walls){

    queue<Node> nextNode;

    for(int i = 0; i < walls.size(); i++)
        map[walls[i].i][walls[i].j] = 1;

    for(int i = 0; i <map.size(); i++)
        for(int j = 0; j < map[0].size(); j++)
            if(map[i][j] == 2)
                nextNode.push({i,j});

    while(nextNode.empty() != true){
        Node curNode = nextNode.front(); nextNode.pop();

        for(int i = 0; i< 4; i++){
            int nextI = curNode.i + dir[i][0];
            int nextJ = curNode.j + dir[i][1];

            if(isInBoundary(nextI,nextJ,map.size(),map[0].size()) != true)
                continue;

            if(map[nextI][nextJ] != 0)
                continue;

            map[nextI][nextJ] = 2;
            nextNode.push({nextI,nextJ});
        }
    }

    return getSafeZone(map);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int N, M;
    cin >> N >> M;

    vector<vector<int>> map(N, vector<int>(M, -0));
    vector<Node> notWalls;
    vector<Node> viruses;

    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++) {
            int input;
            cin >> input;
            map[i][j] = input;
            if (input == 0)
                notWalls.push_back({i, j});
            if (input == 2)
                viruses.push_back({i, j});
        }

    int maxValue = -1;
    for (int i = 0; i < notWalls.size() - 2; i++) {
        for (int j = i + 1; j < notWalls.size() - 1; j++)
            for (int k = j + 1; k < notWalls.size(); k++) {
                vector<Node> selectedWallsIndexes;
                selectedWallsIndexes.push_back(notWalls[i]);
                selectedWallsIndexes.push_back(notWalls[j]);
                selectedWallsIndexes.push_back(notWalls[k]);

                int safezone = trySolution(map,selectedWallsIndexes);
                if(maxValue < safezone)
                    maxValue = safezone;
            }
    }

    cout << maxValue;
}