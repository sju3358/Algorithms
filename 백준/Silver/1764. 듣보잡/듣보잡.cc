#include <unordered_map>
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main (){

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    unordered_map<string,bool> map;
    vector<string> answer;

    int n,m;
    cin >> n >> m;

    for(int i = 0; i <n; i++){
        string input; cin >> input;
        map.insert(make_pair(input,true));
    }

    for(int i = 0; i<m; i++){
        string input; cin >> input;
        auto iter = map.find(input);
        if(iter != map.end())
            answer.push_back(input);
    }

    sort(answer.begin(),answer.end());

    cout << answer.size() << '\n';
    for(string name : answer)
        cout << name << '\n';
}