#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

bool isInBoundary(int x, int y, int n){
    return 0 <= x && x < n && 0 <= y  && y < n;
}

typedef struct coordinate{
    int i;
    int j;
}Coordinate;

int main (){

    int n; cin >> n;

    //동 서 남 북
    int dir_i[]= {0, 0,1,-1};
    int dir_j[] = {1,-1,0, 0};

    vector<int> sumOfHomes;
    vector<vector<int>> homes;
    vector<vector<bool>> isVisit;


    for(int i = 0; i < n; i ++){
        vector<int> inputs;
        vector<bool> flags;

        string inputString;
        cin >> inputString;

        for(int j = 0; j <inputString.length(); j++){

            int input = inputString[j] - '0';
            bool flag = input == 1 ? false : true;
            inputs.push_back(input);
            flags.push_back(flag);
        }
        homes.push_back(inputs);
        isVisit.push_back(flags);
    }

    for(int i = 0; i <n; i++){
        for(int j = 0; j <n; j++){
            if(isVisit[i][j] == false && homes[i][j] == 1){
                int sum = 0;

                queue<Coordinate> nextNode;
                Coordinate node;
                node.i = i;
                node.j = j;
                nextNode.push(node);
                isVisit[i][j] = true;
                sum++;

                while(nextNode.empty() != true){
                    Coordinate curNode = nextNode.front();
                    nextNode.pop();

                    for(int k = 0; k <4; k++){
                        int next_i = curNode.i + dir_i[k];
                        int next_j = curNode.j + dir_j[k];

                        if(isInBoundary(next_i,next_j,isVisit.size()))
                            if(isVisit[next_i][next_j] == false && homes[next_i][next_j] == 1){
                                isVisit[next_i][next_j] = true;
                                sum++;
                                nextNode.push({next_i,next_j});
                        }
                    }
                }

                sumOfHomes.push_back(sum);
            }
        }
    }

    sort(sumOfHomes.begin(), sumOfHomes.end());

    cout << sumOfHomes.size() << '\n';
    for(int sum : sumOfHomes)
        cout << sum << "\n";
}