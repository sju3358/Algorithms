#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
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

int solution(vector<vector<int>>& map, vector<int>& dp, int start, int end){


    priority_queue<Node, vector<Node>, compare> nextNode;

    dp[start] = 0;
    nextNode.push({start,0});

    while(nextNode.empty() != true){

        Node curNode = nextNode.top(); nextNode.pop();

        int node = curNode.node;
        int cost = curNode.cost;

        for(int i = 0; i < dp.size(); i++){

            if(map[node][i] == -1)
                continue;

            if(dp[i] > map[node][i] + cost){
                dp[i] = map[node][i] + cost;
                nextNode.push({i,dp[i]});
            }
        }

    }

    return dp[end];
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n,m;
    cin >> n;
    cin >> m;

    vector<int> dp(n,2100000000);
    vector<vector<int>> map(n,vector<int>(n,-1));

    for(int i = 0; i < m ; i++){
        int from, to, weight;
        cin >> from >> to >> weight;
        if(map[from-1][to-1] == -1)
            map[from-1][to-1] = weight;
        else
            map[from-1][to-1] = min(map[from-1][to-1],weight);
    }

    int start, end;
    cin >> start >> end;

    cout << solution(map,dp,start-1,end-1);
}