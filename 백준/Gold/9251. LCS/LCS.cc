#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;


int solution(string word1,string word2){
    vector<vector<int>> dp(word1.length()+1, vector<int>(word2.length()+1,0));

    for(int i = 0; i < word1.size(); i++){
        for(int j = 0; j < word2.size(); j++){
            if(word1[i] == word2[j]){
                dp[i+1][j+1] = dp[i][j] + 1;
            }
            else{
                dp[i+1][j+1] = max(dp[i+1][j] , dp[i][j+1]);
            }
        }
    }

    int maxLength = -1;
    for(int i = 0; i < dp.size(); i++)
        for(int j = 0; j < dp[0].size(); j++)
            maxLength = max(maxLength, dp[i][j]);

    return maxLength;
}

int main(){
    string word1;
    string word2;

    cin >> word1;
    cin >> word2;

    cout << solution(word1,word2);
}