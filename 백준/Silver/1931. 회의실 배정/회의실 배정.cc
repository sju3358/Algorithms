#include <iostream>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

typedef unsigned int uint;

typedef struct Meeting {
	uint start;
	uint end;
} Meeting;

vector<Meeting> reservations;


bool compare(Meeting a, Meeting b) {

	if (a.end == b.end)
		return a.start < b.start;
	else
		return a.end < b.end;
}


int main(void) {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		uint start, end;
		cin >> start >> end;
		reservations.push_back({ start,end });
	}

	sort(reservations.begin(), reservations.end(), compare);


	int cnt = 1;
	int curEnd = reservations[0].end;

	for (int i = 1; i < reservations.size(); i++) {
		if (reservations[i].start >= curEnd) {
			curEnd = reservations[i].end;
			cnt++;
		}
	}

	cout <<  cnt;
}