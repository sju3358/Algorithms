#include <iostream>
#include <queue>
#include <time.h>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {

	queue<int> curTrcuks;

	int curWeights = 0;
	int answer = 0;

	for (int i = 0; i < bridge_length; i++)
		curTrcuks.push(0);

	for (int index = 0; index < truck_weights.size(); index++) {

		while (curWeights - curTrcuks.front() + truck_weights[index] > weight) {
			curWeights -= curTrcuks.front();
			curTrcuks.pop();
			curTrcuks.push(0);

			answer++;
		}

		curWeights -= curTrcuks.front();
		curTrcuks.pop();
		curTrcuks.push(truck_weights[index]);
		
		curWeights += truck_weights[index];
		answer++;
	}

	answer += bridge_length;

	return answer;
}


int main() {
	cout << solution(2, 10, { 7,4,5,6 });
}