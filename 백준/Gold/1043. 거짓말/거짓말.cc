#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<bool> knowingPeoples(51, false);
vector<vector<int>> partys;
int numOfPeople,numOfParty;

bool check(vector<int> party){
    for(int i = 0; i < party.size(); i++)
        if(knowingPeoples[party[i]] == true)
            return false;
    return true;
}

int solution(){

    queue<vector<int>> nextParty;

    for(int i = 0; i < partys.size(); i++)
        nextParty.push(partys[i]);

    while(true){

        bool flag = true;

        for(int i = 0; i < nextParty.size(); i++){
            vector<int> party = nextParty.front(); nextParty.pop();
            if(check(party) == false) {
                for (int j = 0; j < party.size(); j++)
                    knowingPeoples[party[j]] = true;
                flag = false;
            }
            else{
                nextParty.push(party);
            }
        }

        if(flag == true)
            break;
    }

    return nextParty.size();
}

int main(){

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> numOfPeople >> numOfParty;

    int sumOfKnowingPeople; cin >> sumOfKnowingPeople;
    for(int i = 0; i < sumOfKnowingPeople; i++){
        int knowingPeople; cin >> knowingPeople;
        knowingPeoples[knowingPeople] = true;
    }

    for(int i = 0; i < numOfParty; i ++){
        vector<int> party;
        int sumOfPartyPeople; cin >> sumOfPartyPeople;
        for(int j = 0; j < sumOfPartyPeople; j++){
            int person; cin >> person;
            party.push_back(person);
        }
        partys.push_back(party);
    }

    cout << solution();
}