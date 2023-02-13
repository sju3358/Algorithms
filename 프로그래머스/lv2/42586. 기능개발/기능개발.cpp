#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <string>
#include <stack>
#include <queue>
#include <unordered_set>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
	vector<int> answers;

	int day = 0;

	int index = 0;
	while (index < progresses.size()) {
		
		int answer = 0;
		while (progresses[index] + (speeds[index] * day) >= 100) {
			answer++;
			index++;

			if (index >= progresses.size())
				break;
		}
		if (answer != 0)
			answers.push_back(answer);
		day++;
	}

	return answers;
}

// int main(void) {
// 	for (int result : solution({ 93,30,55 }, { 1,30,5 }))
// 		cout << result << " ";
// 	cout << endl;
// 	for (int result : solution({ 95,90,99,99,80,99 }, { 1,1,1,1,1,1 }))
// 		cout << result << " ";
// 	cout << endl;
// }