#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

typedef struct node{
    int node;
    int cost;
}Node;

struct compare{
    bool operator()(Node a, Node b){
        return a.cost > b.cost;
    }
};

void getMinTime(vector<vector<int>>& map, vector<vector<int>>& dp, int start){


    priority_queue<Node, vector<Node>, compare> nextNode;

    dp[start][start] = 0;
    nextNode.push({start,dp[start][start]});

    while(nextNode.empty() != true){

        Node curNode = nextNode.top(); nextNode.pop();

        for(int i = 0; i < map.size(); i++){

            if(map[curNode.node][i] > 10000)
                continue;

            if(dp[start][i] > map[curNode.node][i] + curNode.cost) {
                dp[start][i] = map[curNode.node][i] + curNode.cost;
                nextNode.push({i,dp[start][i]});
            }
        }

    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n,m,x;
    cin >> n >> m >> x;


    vector<vector<int>> map(n, vector<int>(n,10001));
    vector<vector<int>> dp(n, vector<int>(n,2100000000));


    for(int i = 0; i < m; i++){
        int from,to,weight;
        cin >> from >> to >> weight;

        map[from-1][to-1] = min(map[from-1][to-1],weight);
    }

    int target = x-1;
    for(int i = 0; i < n; i++){
        getMinTime(map,dp,i);
    }

    int maxTime = -1;
    for(int i = 0; i < n; i++)
        maxTime = max(maxTime, dp[i][target] + dp[target][i]);

    cout << maxTime;
}