#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<bool> isVisit;
vector<vector<bool>> G;
int sum = 0;

void dfs(int startNode){

    queue<int> nextNode;
    nextNode.push(startNode);
    isVisit[startNode] = true;

    while(nextNode.empty() != true){
        int node = nextNode.front();
        nextNode.pop();


        for(int i = 0; i <isVisit.size(); i++){
            if(isVisit[i] == false && G[node][i] == true){
                isVisit[i] = true;
                nextNode.push(i);
            }
        }
    }
}

int main (){
    int n, m;

    cin >> n >> m;

    for(int i = 0; i < n; i++){
        vector<bool> temp;
        for(int j = 0; j < n; j++){
            temp.push_back(false);
        }
        G.push_back(temp);
        isVisit.push_back(false);
    }

    for(int i = 0; i <m; i++){
        int node1;
        int node2;
        cin >> node1 >> node2;
        G[node1-1][node2-1] = G[node2-1][node1-1] = true;
    }


    for(int i = 0; i < n; i++){
        if(isVisit[i] == false){
            dfs(i);
            sum++;
        }
    }

    cout << sum;

}