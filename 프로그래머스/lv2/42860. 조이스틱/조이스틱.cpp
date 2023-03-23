#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;



int solution(string name) {

	int answer = 0;
	int minCostOfLeftRight = name.length() - 1; //그냥 정방향 이동거리

	for (int curIndex = 0; curIndex < name.length(); curIndex++) {
		
		int costOfUpDown = min(name[curIndex] - 'A', 'Z' - name[curIndex] + 1);
		answer += costOfUpDown;

		int nextIndex = curIndex + 1;
		while (nextIndex < name.length() && name[nextIndex] == 'A')
			nextIndex++;

		int costRightToLeft = curIndex*2 + name.length() - nextIndex; //오른쪽으로 갔다가 왼쪽으로
		int costLeftToRight = (name.length() - nextIndex) * 2 + curIndex;
		minCostOfLeftRight = min(minCostOfLeftRight, min(costRightToLeft, costLeftToRight));
	}

	answer += minCostOfLeftRight;

	return answer;
}

int main() {
	cout << solution("JEROEN") << endl;
	cout << solution("JAN") << endl;
}