#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


bool isFindRoute = false;
vector<bool> visited(1000, false);
vector<string> answer;


bool compare(vector<string> a, vector<string> b) {
	if (a[0].compare(b[0]) == 0) 		
		return a[1] < b[1];
	else
		return a[0] < b[0];
}

void getTravelRoute(vector<vector<string>> tickets, int index, vector<string> history) {

	history.push_back(tickets[index][1]);

	if (history.size() == tickets.size() + 1) {
		answer = history;
		isFindRoute = true;
		return;
	}

	string nextAirport = tickets[index][1];

	for (int i = 0; i < tickets.size(); i++) {
		if (visited[i] != true && tickets[i][0].compare(nextAirport) == 0 && isFindRoute != true) {
			visited[i] = true;
			getTravelRoute(tickets, i, history);
			visited[i] = false;
		}
	}
}

vector<string> solution(vector<vector<string>> tickets) {
	

	sort(tickets.begin(), tickets.end(), compare);

	for (int startIndex = 0; startIndex < tickets.size(); startIndex++) {
		if (isFindRoute != true && tickets[startIndex][0].compare("ICN") == 0) {
			visited[startIndex] = true;
			getTravelRoute(tickets, startIndex, { tickets[startIndex][0]});
			visited[startIndex] = false;
		}
	}

	return answer;
}

//int main() {
//
//	
//}