#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;


void bfs_search(vector<vector<bool>>& graph, vector<bool>& map,vector<int>& result, int curNode)
{
    for (int i = 1; i < graph.size(); i++)
    {
        if (graph[curNode][i] && !map[i] && curNode != i)
        {
            map[i] = true;
            result.push_back(i);
            bfs_search(graph, map, result, i);
        }
    }
}


void bfs(vector<vector<bool>>& graph, int start)
{
    vector<bool> map(graph.size(), false);
    vector<int> result;

    map[start] = true;
    result.push_back(start);

    bfs_search(graph, map, result, start);
    
    for (int i = 0; i < result.size(); i++)
        cout << result[i] << ' ';

}




void dfs(vector<vector<bool>>& graph, int start)
{
    vector<bool> map(graph.size());
    queue<int> dfsQueue;
    vector<int> result;

    map[start] = true;
    dfsQueue.push(start);
    result.push_back(start);

    while (!dfsQueue.empty())
    {
        int cur = dfsQueue.front();
        dfsQueue.pop();
        for (int i = 1; i < graph.size(); i++)
        {
            if (graph[cur][i] && !map[i] && cur != i)
            {
                dfsQueue.push(i);
                map[i] = true;
                result.push_back(i);
            }
        }
    }

    for (int i = 0; i < result.size(); i++)
        cout << result[i] << ' ';
}




int main(void)
{
    int N, M, start;
    int temp1, temp2;

    cin >> N;
    cin >> M;
    cin >> start;

    vector<vector<bool>> graph(N + 1, vector<bool>(N + 1, false));

    for (int i = 0; i < M; i++)
    {
        cin >> temp1;
        cin >> temp2;
        graph[temp1][temp2] = true;
        graph[temp2][temp1] = true;
    }
    
    
    bfs(graph, start);
    cout << endl;
    dfs(graph, start);
}