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

typedef struct Node {
	int index;
	int cost;
};

vector<Meeting> reservations;
vector<Meeting> selectedMeeting;

bool compare(Meeting a, Meeting b) {

	if (a.end == b.end)
		return a.start < b.start;
	else
		return a.end < b.end;
}

bool isPossible(Meeting a) {
	
	if (selectedMeeting.empty() == true)
		return true;

	if (a.end <= selectedMeeting[0].start || a.start >= selectedMeeting[selectedMeeting.size()-1].end)
		return true;

	for (int i = 0; i < selectedMeeting.size(); i++) {
		if (selectedMeeting[i].end > a.start || a.end > selectedMeeting[i + 1].start)
			return false;
	}

	return true;
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

	//cout << getMaxResevations();

	int sum = 1;
	

	for (int i = 0; i < reservations.size(); i++) {
		if (isPossible(reservations[i]))
			selectedMeeting.push_back(reservations[i]);
	}

	cout << selectedMeeting.size();
}