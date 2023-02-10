#include <iostream>
#include <queue>
#include <functional>
#include <cstdio>
using namespace std;

typedef unsigned int uint;

int main(void) {
	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	priority_queue<uint,vector<uint>,greater<uint>> pq;
	vector<uint> answers;

	int n; cin >> n;

	while (n--) {
		uint input; cin >> input;
		if (input == 0) {
			if (pq.empty() == true)
				answers.push_back(0);
			else {
				answers.push_back(pq.top());
				pq.pop();
			}
		}
		else
			pq.push(input);
	}

	for (int answer : answers)
		cout << answer << '\n';
}