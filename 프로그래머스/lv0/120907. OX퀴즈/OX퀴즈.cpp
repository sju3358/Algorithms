#include <string>
#include <vector>
#include <sstream>
#include <iostream>
using namespace std;

vector<string> solution(vector<string> quiz) {
    vector<string> answer;

	for(int i = 0; i<quiz.size(); i++){
		string target = quiz[i];
		istringstream ss(target);
		vector<string> strings;

		string temp;
		while (getline(ss, temp, ' ')) //공백 단위로 구분
        	strings.push_back(temp);

		int a = stoi(strings[0]);
		int b = stoi(strings[2]);
		int c = stoi(strings[4]);

		string op = strings[1];

		if(op.compare("+") == 0)
		{
			if(a + b == c)
				answer.push_back("O");
			else
				answer.push_back("X");
		}
		else{
			if(a - b == c)
				answer.push_back("O");
			else
				answer.push_back("X");
		}
	}

    return answer;
}


// int main(void){
	
// 	solution({"3 - 4 = -3"});

// 	return 0;
// }