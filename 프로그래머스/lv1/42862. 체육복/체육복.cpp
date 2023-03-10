#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
	int answer = n;

	sort(lost.begin(), lost.end());

	vector<int> losts(n + 1,0);
	vector<int> reserves(n + 1, 0);

	for (int i = 0; i < lost.size(); i++)
		losts[lost[i]] = 1;

	for (int i = 0; i < reserve.size(); i++)
		reserves[reserve[i]] = 1;

	for (int i = 0; i < lost.size(); i++) {
		int student = lost[i];

		if (reserves[student] == 1) {
			reserves[student] = 0;
			losts[student] = 0;
		}
	}

	for (int i = 0; i < lost.size(); i++) {
		int student = lost[i];

		if (student-1 >= 0 && reserves[student - 1] == 1) {
			reserves[student - 1] = 0;
			losts[student] = 0;
			continue;
		}

		if (student+1 <= n && reserves[student + 1] == 1) {
			reserves[student + 1] = 0;
			losts[student] = 0;
			continue;
		}
	}
	
	for (int i = 1; i <= n; i++)
		answer -= losts[i];

	return answer;
}

int main() {
	cout << solution(5, { 2,4 }, { 1,3,5 });
}
