#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct node{
    int node;
    int cost;
}Node;

typedef struct dpNode{

    int cost;
    vector<int> history;
}DpNode;

struct compare{
    bool operator()(Node x, Node y){
        return x.cost > y.cost;
    }
};

DpNode solution(vector<vector<Node>> map, int start, int end){

    vector<DpNode> dp(map.size(),{100000001,vector<int>(0)});
    dp[start].cost = 0;
    dp[start].history.push_back(start);
    priority_queue<Node, vector<Node>, compare> nextNode;
    nextNode.push({start,0});

    while(nextNode.empty() != true){
        Node curNode = nextNode.top(); nextNode.pop();

        if(curNode.cost > dp[curNode.node].cost)
            continue;

        for(int i = 0; i < map[curNode.node].size(); i++){

            Node next = map[curNode.node][i];

            if(dp[next.node].cost > curNode.cost + next.cost){
                dp[next.node].cost = curNode.cost + next.cost;
                dp[next.node].history = dp[curNode.node].history;
                dp[next.node].history.push_back(next.node);
                nextNode.push({next.node, dp[next.node].cost});
            }
        }
    }

    return dp[end];
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n,m; cin >> n >> m;
    vector<vector<Node>> map(n, vector<Node>(0));

    for(int i = 0; i < m; i++){
        int from,to,cost; cin >> from >> to >> cost;
        map[from-1].push_back({to-1,cost});
    }

    int start,end; cin >> start >> end;
    DpNode result = solution(map,start-1,end-1);
    cout << result.cost << "\n";
    cout << result.history.size() << "\n";
    for(int i = 0; i < result.history.size(); i++)
        cout << result.history[i]+1 << " ";


}