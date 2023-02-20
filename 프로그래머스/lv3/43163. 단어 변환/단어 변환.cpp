#include <string>
#include <vector>
#include <queue>
#include <string>

#define INTEGER_MAX_VALUE 2100000000

using namespace std;





typedef struct Word {
	string word;
	int count;
};

int compareString(string a, string b) {
	int diff = 0;

	for (int i = 0; i < a.length(); i++) {
		if (a[i] != b[i])
			diff++;
	}
	return diff;
}

int solution(string begin, string target, vector<string> words) {
	
	int minCount = INTEGER_MAX_VALUE;

	queue<Word> nextWord;
	vector<bool> isVisit;
	
	for (int i = 0; i < words.size(); i++)
		isVisit.push_back(false);

	nextWord.push({ begin,0 });

	bool isFind = false;
	
	while (nextWord.empty() != true) {
		Word curWord = nextWord.front(); nextWord.pop();


		if (curWord.word.compare(target) == 0) {
			if (minCount > curWord.count)
				minCount = curWord.count;
			isFind = true;
		}
		else {
			for (int i = 0; i < words.size(); i++) {
				if (compareString(curWord.word,words[i]) <= 1 && isVisit[i] == false) {
					isVisit[i] = true;
					nextWord.push({ words[i], curWord.count + 1 });
				}
			}
		}
	}

		
	return isFind == true ? minCount : 0;
}

int main() {

	solution("hit", "cog", { "hot","dot","dog","lot","log","cog" });
}