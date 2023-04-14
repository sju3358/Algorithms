#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool check(string word){
    stack<char> letters;

    for(int i = 0; i < word.length(); i++){

        if(letters.size() == 0){
            letters.push(word[i]);
            continue;
        }

        if(letters.top() == word[i])
            letters.pop();
        else
            letters.push(word[i]);
    }

    while(letters.empty() != true){
        char letter = letters.top(); letters.pop();

        if(letters.size() == 0)
            return false;
        if(letters.top() != letter)
            return false;
        letters.pop();
    }
    return true;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    int n; cin >> n;

    int cnt = 0;
    for(int i = 0; i < n; i++){
        string word; cin >> word;
        if(check(word) == true)
            cnt++;
    }
    cout << cnt;

}