#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

typedef struct node{
    int i;
    int j;
    int cost;
}Node;

struct compare{
    bool operator()(Node a, Node b){
        return a.cost > b.cost;
    }
};

int dir[][2] = {{1,0},{-1,0},{0,1},{0,-1}};

bool isInBoundary(int i, int j, int n){
    return 0 <= i && i < n && 0 <= j && j < n;
}

int solution(vector<vector<int>>& map, vector<vector<int>>& dp){


    priority_queue<Node, vector<Node>, compare> nextNode;

    dp[0][0] = map[0][0];
    nextNode.push({0,0,dp[0][0]});

    while(nextNode.empty() != true){

        Node curNode = nextNode.top(); nextNode.pop();

        for(int i = 0; i < 4; i++){
            int nextI = curNode.i + dir[i][0];
            int nextJ = curNode.j + dir[i][1];

            if(isInBoundary(nextI,nextJ,dp.size()) != true)
                continue;

            if(dp[nextI][nextJ] > map[nextI][nextJ] + curNode.cost){
                dp[nextI][nextJ] = map[nextI][nextJ] + curNode.cost;
                nextNode.push({nextI,nextJ,dp[nextI][nextJ]});
            }
        }

    }

    int n = dp.size();
    return dp[n-1][n-1];
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int t = 1;
    while(true) {

        int n; cin >> n;

        if(n == 0)
            break;
        vector<vector<int>> dp(n, vector<int>(n,2100000000));
        vector<vector<int>> map(n, vector<int>(n));

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cost; cin >> cost;
                map[i][j] = cost;
            }
        }

        string result = "Problem " + to_string(t++) + ": " + to_string(solution(map, dp)) ;
        cout << result << "\n";
    }
}