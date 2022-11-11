#include <vector>
#include <iostream>
#include <stack>
#include <queue>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

bool isOutOfBound(int x, int y, vector<vector<int>> &maps, vector<vector<bool>> &isVisit) 
{
    int n = maps.size();
    int m = maps[0].size();
    if(0 <= x && x < n && 0 <= y && y < m){
        if(isVisit[x][y] == false && maps[x][y] != 0){
            return true;
        }
        else
            return false;
    }
    else 
        return false;
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    vector<vector<bool>> isVisit;
    vector<vector<int>> distance;
    vector<int> costs;
    queue<int> bfs;

    //초기값 초기화
    for(int i = 0; i<maps.size(); i++)
    {
        vector<bool> temp;
        vector<int> temp2;
        for(int j = 0; j < maps[0].size(); j++){
            temp.push_back(false);
            temp2.push_back(-1);
            
        }
        isVisit.push_back(temp);
        distance.push_back(temp2);
    }

    vector<int> dx = {1,-1,0,0};
    vector<int> dy = {0,0,1,-1};
    distance[0][0] = 1;
    
    bfs.push(0);
    bfs.push(0);
    
    int n = maps.size()-1;
    int m = maps[0].size()-1;
    
    while(bfs.empty() != true){
        int cur_x = bfs.front(); bfs.pop();
        int cur_y = bfs.front(); bfs.pop();
        
        if(cur_x == n && cur_y == m)
            break;
        
        isVisit[cur_x][cur_y] = true;
        
        for(int i = 0; i< 4; i++){
            int next_x = cur_x+ dx[i];
            int next_y = cur_y+ dy[i];
            if(isOutOfBound(next_x,next_y,maps,isVisit)){
                bfs.push(next_x);
                bfs.push(next_y);
                isVisit[next_x][next_y] = true;
                if(distance[next_x][next_y] == -1)
                    distance[next_x][next_y] = distance[cur_x][cur_y] + 1;
            }
        }
    }

    
    answer = distance[n][m];
    return answer;
}