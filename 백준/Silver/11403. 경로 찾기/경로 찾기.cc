#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<vector<int>> answer;
vector<vector<int>> G;


void dfs(int startNode){
    vector<int> lines;
    queue<int> nextNode;
    nextNode.push(startNode);
    vector<bool> isVisit;
    bool canBackToStartNode;

    for(int i = 0; i <G.size(); i++)
        isVisit.push_back(false);


    while(nextNode.empty() != true){
        int node = nextNode.front();
        nextNode.pop();
        isVisit[node] = true;

        for(int i = 0; i <isVisit.size(); i++){
            if(isVisit[i] == false && G[node][i] == 1){
                isVisit[i] = true;
                answer[startNode][i] = 1;
                nextNode.push(i);
            }
        }
    }
}

int main(void){
    int n; cin>>n;

    for(int i = 0; i < n; i++) {
        vector<int> inputs;
        vector<int> temps;
        for (int j = 0; j < n; j++){
            int input; cin >> input;
            inputs.push_back(input);
            temps.push_back(0);
        }
        G.push_back(inputs);
        answer.push_back(temps);
    }

    for(int i = 0; i<n; i++)
            dfs(i);

    for(int i = 0; i <n; i++){
        for(int j = 0; j < n; j++) {

            if(i==j)
                continue;

            if (answer[i][j] == 1 && answer[j][i] == 1)
                    answer[i][i] = 1;
            
        }
    }
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            cout << answer[i][j] << " ";
        cout << '\n';
    }

}

