#include <string>
#include <unordered_set>
#include <iostream>
#include <vector>

using namespace std;

int main(void){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_set<int> S;

    int n; cin >> n;

    for(int i = 0; i < n ; i++){
        string inputAction; cin >> inputAction;

        if(inputAction.compare("add") == 0){
            int num; cin >> num;
            auto iter = S.find(num);
            if(iter == S.end())
                S.insert(num);
        }
        else if(inputAction.compare("remove") == 0){
            int num; cin >> num;
            auto iter = S.find(num);
            if(iter != S.end())
                S.erase(num);
        }
        else if(inputAction.compare("check") == 0){
            int num; cin >> num;
            auto iter = S.find(num);
            cout << (iter != S.end() ? 1 : 0) << '\n';
        }
        else if(inputAction.compare("toggle") == 0){
            int num; cin >> num;
            auto iter = S.find(num);

            if(iter != S.end())
                S.erase(num);
            else
                S.insert(num);
        }
        else if(inputAction.compare("all") == 0){
            for(int num = 1; num <=20; num++) {
                auto iter = S.find(num);
                if(iter == S.end())
                    S.insert(num);
            }
        }
        else if(inputAction.compare("empty") == 0){
            S.erase(S.begin(),S.end());
        }
    }
}