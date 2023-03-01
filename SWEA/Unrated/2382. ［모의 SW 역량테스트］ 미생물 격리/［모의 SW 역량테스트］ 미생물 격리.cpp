#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int dirs[][2] = {{-1,0},{1,0},{0,-1},{0,1}};

typedef struct group{
    int i;
    int j;
    int size;
    int dir; //0 : 상, 1 : 하, 2 : 좌, 3 : 우
}Group;

int changeDir(int dir){
    if(dir == 0)
        return 1;
    else if(dir == 1)
        return 0;
    else if(dir == 2)
        return 3;
    else if(dir == 3)
        return 2;
}

bool isOnBoundary(int i, int j, int n){
    return i == 0 || j == 0 || j == n-1 || i == n-1;
}

void moveGroup(vector<vector<queue<Group>>>& map){

    int N = map.size();

    //군집 리스트 생성
    vector<Group> groupList;
    for(int i = 0; i < map.size(); i++){
        for(int j = 0; j < map.size(); j++){
            while(map[i][j].empty() != true) {
                groupList.push_back(map[i][j].front());
                map[i][j].pop();
            }
        }
    }

    //군집 리스트 이동
    for(int i = 0; i < groupList.size(); i++) {
        Group &group = groupList[i];

        int nextI = group.i + dirs[group.dir][0];
        int nextJ = group.j + dirs[group.dir][1];


        if (isOnBoundary(nextI, nextJ, N) == true) {
            group.dir = changeDir(group.dir);
            group.size = group.size / 2;
        }

        if(group.size > 0)
            map[nextI][nextJ].push({nextI,nextJ,group.size,group.dir});
    }

    //겹친 군집 하나로 묶기
    for(int i = 0; i < map.size(); i++){
        for(int j = 0; j < map.size(); j++){
            if(map[i][j].empty() != true){

                int max = -1;
                int maxDir = -1;
                int sumOfSize = 0;

                while(map[i][j].empty() != true){
                    Group curGroup = map[i][j].front(); map[i][j].pop();
                    if(max < curGroup.size){
                        max = curGroup.size;
                        maxDir = curGroup.dir;
                    }
                    sumOfSize+= curGroup.size;
                }

                map[i][j].push({i,j,sumOfSize,maxDir});
            }
        }
    }
}

int main(){

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int T; cin >> T;

    for(int t = 1; t <=T; t++){

        int N; cin >> N;
        int M; cin >> M;
        int K; cin >> K;

        vector<vector<queue<Group>>> map;

        for(int i = 0 ; i < N; i++){
            vector<queue<Group>> temp;
            for(int j  = 0; j < N; j++){
                queue<Group> temp2;
                temp.push_back(temp2);
            }
            map.push_back(temp);
        }


        for(int k = 0; k< K; k++){
            int i,j,size,dir;
            cin >> i >> j >> size >> dir;
            map[i][j].push({i,j,size,dir-1});
        }

        for(int m = 0; m < M; m++)
            moveGroup(map);

        int sum = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                while(map[i][j].empty() != true) {
                    sum += map[i][j].front().size;
                    map[i][j].pop();
                }
        }

        cout << "#" << t << " " << sum << "\n";
    }
}