#include <unordered_map>
#include <string>
#include <iostream>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    unordered_map<string,string> passwords;

    int n; cin >> n;
    int m; cin >> m;

    for(int i = 0; i <n; i++){
        string homePage; cin >>  homePage;
        string password; cin >> password;
        passwords.insert(make_pair(homePage,password));
    }
    for(int i = 0 ; i < m ; i++){
        string homepage; cin >> homepage;
        auto iter = passwords.find(homepage);
        cout << iter->second<<'\n';
    }
}