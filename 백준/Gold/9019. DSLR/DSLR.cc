#include <iostream>
#include <string>
#include <queue>
#include <vector>

using namespace std;

bool isVisit[10001];

int L(int number) {	
	return (number % 1000) * 10 + (number / 1000);
}
int R(int number) {
	return (number % 10) * 1000 + (number / 10);
}
int byTwo(int number) {
	return (number * 2) % 10000;
}
int minusOne(int number) {
	return number == 0 ? 9999 : number - 1;
}

string findNum(int startNum, int targetNum) {

	queue<pair<int,string>> nextNumber;
	string answer;

	nextNumber.push(make_pair(startNum,""));

	while (nextNumber.empty() != true) {

		int curNumber = nextNumber.front().first;  
		string history = nextNumber.front().second;
		nextNumber.pop();

		if (curNumber == targetNum) {
			answer = history;
			break;
		}
		
		int curNumR = R(curNumber);
		if (isVisit[curNumR] != true) {
			isVisit[curNumR] = true;
			nextNumber.push({ curNumR,history + 'R' });
		}

		int curNumL = L(curNumber);
		if (isVisit[curNumL] != true) {
			isVisit[curNumL] = true;
			nextNumber.push({ curNumL,history + 'L' });
		}

		int numD = byTwo(curNumber);
		if (isVisit[numD] != true) {
			isVisit[numD] = true;
			nextNumber.push({ numD,history + 'D' });
		}

		int numS = minusOne(curNumber);
		if (isVisit[numS] != true) {
			isVisit[numS] = true;
			nextNumber.push({ numS,history + 'S' });
		}
		
		

		
		

		

		
	}

	return answer;

}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int T; cin >> T;

	while (T--) {

		for (int i = 0; i < 10001; i++)
			isVisit[i] = false;
		

		
		int curNum, targetNum;
		cin >> curNum >> targetNum;
		cout << findNum(curNum, targetNum) << '\n';
		
	}
}