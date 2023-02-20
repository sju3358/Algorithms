#include <string>
#include <vector>
#include <iostream>
using namespace std;

int TARGET = 0;
int ANSWER = 0;

void findAnswer(int curIndex, int curSum, vector<int> numbers) {
	
	if (curIndex == numbers.size()) {
		if (curSum == TARGET)
			ANSWER++;
	}
	else {
		findAnswer(curIndex + 1, curSum + numbers[curIndex], numbers);
		findAnswer(curIndex + 1, curSum + (-1)*numbers[curIndex], numbers);
	}
}


int solution(vector<int> numbers, int target) {

    TARGET = target;
    
	findAnswer(0, 0, numbers);

	return ANSWER;
}

// int main() {
// 	cout << solution({1,1,1,1,1},3) << endl;
// 	cout << solution({4,1,2,1}, 4) << endl;
// }