#include <string>
#include <vector>
#include <queue>
#include <sstream>
#include <stdio.h>
#include <iostream>


using namespace std;

bool isInBoundary(int x, int n)
{
    if(0 <= x && x < n)
        return true;
    else
        return false;
}


void bfs(int n, vector<vector<int>> computers, vector<bool> &isVisit, queue<int> &bfs_queue)
{
    if(bfs_queue.empty() == true)
        return;
    

    int node = bfs_queue.front();
    isVisit[node] = true;
    bfs_queue.pop();

    for(int i = 0; i < n; i++){
        if( i == node)
            continue;
        if(computers[node][i] == 1 && isVisit[i] == false){
            bfs_queue.push(i);
        }
    }

    bfs(n, computers, isVisit, bfs_queue);
}


int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    vector<bool> isVisit;
    
   //map 초기화
    for(int i = 0; i<n ; i++){
        isVisit.push_back(false);
    }


    for(int i = 0; i<n; i++){
       if(isVisit[i] == false){
        queue<int> bfs_queue;
        bfs_queue.push(i);
        bfs(n,computers,isVisit,bfs_queue);
        answer++;
       } 
    }
    return answer;
}