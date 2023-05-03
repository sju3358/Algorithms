#include <iostream>
#include <vector>

using namespace std;

int main(){
    int n; cin >> n;

    vector<int> input(n);
    for(int i = 0; i < n; i++)
        cin >> input[i];

    vector<int> upDp(n,0);
    vector<int> downDp(n,0);

    upDp[0] = 1;
    downDp[n-1] = 1;

    for(int i = 1; i < n; i++){

        int max = 0;
        int max_index = i;

        for(int j = 0; j < i; j++){
            if(input[i] > input[j] && upDp[j] > max){
                max = upDp[j];
                max_index = j;
            }

        }
        upDp[i] = upDp[max_index] + 1;
    }

    for(int i = n-2; i>=0; i--){
        int max = 0;
        int max_index = i;

        for(int j = n-1; j> i; j--){
            if(input[j] < input[i] && downDp[j] > max){
                max = downDp[j];
                max_index = j;
            }
        }
        downDp[i] = downDp[max_index] + 1;
    }

    int length = 0;
    for(int i = 0; i < n ; i++)
        length = max(length, (upDp[i] + downDp[i]) - 1);

    cout << length;
}