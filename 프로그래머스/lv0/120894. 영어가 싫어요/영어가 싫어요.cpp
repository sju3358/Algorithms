#include <string>
#include <vector>
#include <iostream>

using namespace std;

int stringToInteger(string str){
	vector<string> table = {"zero","one","two","three","four","five","six","seven","eight","nine"};

	for(int i = 0; i<10; i++){
		if(str.compare(table[i]) == 0)
			return i;
	}

	return -1;
}


long long solution(string numbers) {
    long long answer = 0;

	int start = 0;
	int end = 1;

	while(true){
		string subString = numbers.substr(start, end-start+1);
		int number = stringToInteger(subString);
		
		if(number != -1){
			
			answer = answer*10;
			answer = answer + number;
			
			end++;
			start = end;

			if(start >= numbers.length())
				break;
		}
		else
			end++;
	}

    return answer;
}

// int main(void){
// 	cout << solution("onetwothreefourfivesixseveneightnine");
// }