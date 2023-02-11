#include <iostream>
#include <queue>
#include <vector>
using namespace  std;

int main (){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    priority_queue<int, vector<int>, less<int>> pq;

    int n; cin >>n;
    for(int i = 0; i <n; i++){
        int input; cin >> input;
        if(input == 0){
            if(pq.empty() == true)
                cout << 0 << '\n';
            else {
                cout << pq.top() << '\n';
                pq.pop();
            }
        }
        else
            pq.push(input);
    }

}