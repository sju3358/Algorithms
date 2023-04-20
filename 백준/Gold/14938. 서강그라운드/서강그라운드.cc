#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int maxItemCount = -1;
    int n, lengthLimit, m; cin >> n >> lengthLimit >> m;
    vector<int> items(n);

    for(int i = 0; i < n; i++){
        int item; cin >> item;
        items[i] = item;
    }

    vector<vector<int>> map(n,vector<int>(n,10000));

    for(int i = 0; i<m; i++){
        int from,to,length;
        cin >> from >> to >> length;
        map[from-1][to-1] = map[to-1][from-1] = min(map[from-1][to-1],length);
    }

    for(int i = 0; i < n ; i++)
        map[i][i] = 0;

    for(int k = 0; k < n; k++)
        for(int i = 0; i < n; i++)
            for(int j = 0; j <n; j++)
                map[i][j] = min(map[i][j], map[i][k] + map[k][j]);

    for(int i = 0; i < n; i++){
        int itemCount = 0;
        for(int j = 0; j < n; j++)
            if(map[i][j] <= lengthLimit)
                itemCount += items[j];
        maxItemCount = max(maxItemCount,itemCount);
    }

    cout << maxItemCount;
}