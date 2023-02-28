#include <iostream>
#include <vector>
#include <queue>
#include <math.h>
#include <stack>
using namespace std;



int dir[] = {1,-1};

bool isPossible(vector<int> map, int pivotLength){

    stack<int> roads;
    roads.push(map[0]);

    int index = 1;

    while(index < map.size()){

        if(roads.top() == map[index]){
            roads.push(map[index++]);
            continue;
        }

        if(roads.top() + 1 == map[index]){
            if(roads.size() < pivotLength)
                return false;
            else {
                while (roads.empty() != true)
                    roads.pop();
                roads.push(map[index++]);
            }
        }
        else if(roads.top() - 1 == map[index]){

            while(roads.empty() != true)
                roads.pop();

            while(index < map.size() && roads.size() < pivotLength){
                if(roads.empty() || roads.top() == map[index])
                    roads.push(map[index++]);
                else
                    break;
            }

            if (roads.size() < pivotLength)
                return false;

            int curHeight = roads.top();

            while (roads.size() > 1)
                roads.pop();

            if(index < map.size()){
                if(map[index] == roads.top())
                    index++;
            }

        } else
            return false;
    }

    return true;

}


int main (){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


    int T; cin >> T;
    for(int t = 1; t <= T; t++){

        vector<vector<int>> maps;

        int answer = 0;

        int n; cin >> n;
        int length; cin >> length;
        for(int i = 0; i < n; i++){
            vector<int> inputs;
            for(int j = 0; j < n; j++){
                int input; cin >> input;
                inputs.push_back(input);
            }
            maps.push_back(inputs);
        }

        for(int i = 0; i < n; i++){
            vector<int> map;
            for(int j = 0; j < n; j++){
                map.push_back(maps[i][j]);
            }

            if(isPossible(map, length))
                answer++;
        }

        for(int j = 0; j < n; j++){
            vector<int> map;
            for(int i = 0; i < n; i++){
                map.push_back(maps[i][j]);
            }

            if(isPossible(map, length))
                answer++;
        }

        cout <<"#"<<t << " "<< answer << '\n';

    }


}