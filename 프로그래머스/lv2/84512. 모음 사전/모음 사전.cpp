#include <string>
#include <vector>
#include <iostream>
using namespace std;


int answer;
int cnt;
void findWord(string curWord,string target, vector<char> letters) {

	if (curWord.length() >= 5){
		if (curWord.compare(target) == 0) 
			answer = cnt;

		return;
	}


	for (int i = 0; i < letters.size(); i++)
		if (curWord.compare(target) == 0) {
			answer = cnt;
			return;
		}
		else
		{
			cnt++;
			findWord(curWord + letters[i], target, letters);
		}
}


int solution(string word) {
	
	answer = 0;
	cnt = 0;

	vector<char> letters = {'A','E','I','O','U'};

	findWord("",word,letters);

	return answer;
}

int main(void) {
	cout << solution("AAAAE") << endl;
	cout << solution("AAAE") << endl;
	cout << solution("I") << endl;
	cout << solution("EIO") << endl;
}