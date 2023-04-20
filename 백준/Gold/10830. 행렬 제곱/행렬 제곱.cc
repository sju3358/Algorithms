#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> multiply(vector<vector<int>> x, vector<vector<int>> y){
    int size = x.size();
    vector<vector<int>> newMatrix(size, vector<int>(size));

    for(int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            int value = 0;
            for(int k = 0; k < size; k++)
                value += x[i][k]*y[k][j] % 1000;
            newMatrix[i][j] = value % 1000;
        }
    }
    return newMatrix;
}

int main(){
    int n; cin >> n;
    long long b; cin >> b;
    vector<vector<int>> a(n,vector<int>(n));

    for(int i = 0; i < n ; i++)
        for(int j = 0; j < n; j++){
            int num; cin >> num;
            a[i][j] = num;
        }

    long long cnt = 1;
    vector<vector<int>> result(n,vector<int>(n,0));
    for(int i = 0; i < n; i++)
        result[i][i] = 1;
    vector<vector<int>> temp = a;
    while(b){
        if(cnt*2 <= b){
            cnt = cnt * 2;
            temp = multiply(temp,temp);
        }
        else{
            result = multiply(result,temp);
            b = b - cnt;
            cnt = 1;
            temp = a;
        }
    }

    for(int i = 0; i <result.size(); i++){
        for(int j = 0; j < result.size(); j++)
            cout << result[i][j] << " ";
        cout <<"\n";
    }

}