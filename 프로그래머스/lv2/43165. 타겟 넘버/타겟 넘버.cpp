#include <string>
#include <vector>
#include <iostream>
using namespace std;


void findAnswer(int curIndex, int curSum, vector<int> numbers, int target, int& answer) {
	
	if (curIndex == numbers.size()) {
		if (curSum == target)
			answer++;
	}
	else {
		findAnswer(curIndex + 1, curSum + numbers[curIndex], numbers, target, answer);
		findAnswer(curIndex + 1, curSum + (-1)*numbers[curIndex], numbers, target, answer);
	}
}


int solution(vector<int> numbers, int target) {
	int answer = 0;

	findAnswer(0, 0, numbers, target, answer);

	return answer;
}

// int main() {
// 	cout << solution({1,1,1,1,1},3) << endl;
// 	cout << solution({4,1,2,1}, 4) << endl;
// }