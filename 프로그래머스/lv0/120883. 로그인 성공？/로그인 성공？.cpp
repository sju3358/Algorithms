#include <string>
#include <vector>

using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db) {
    string answer = "";
    
    bool isFind = false;
    
    string id_input = id_pw[0];
    string pw_input = id_pw[1];
    
    for(int i = 0; i<db.size(); i++){
        
        if(id_input.compare(db[i][0]) == 0){
            isFind = true;
            
            if(pw_input.compare(db[i][1]) == 0)
                answer = "login";
            else
                answer = "wrong pw";
            break;
        }
    }
    if(isFind == false)
        answer = "fail";
    return answer;
}