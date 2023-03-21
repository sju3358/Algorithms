#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>
using namespace std;



bool compare(vector<int> routeA, vector<int> routeB) {
	if (routeA[0] != routeB[0])
		return routeA[0] < routeB[0];
	else
		return routeA[1] < routeB[1];
}

int solution(vector<vector<int>> routes) {
	
	
	sort(routes.begin(), routes.end(), compare);

	int curLeft = routes[0][0];
	int curRight = routes[0][1];
	int answer = 1;

	for (int i = 1; i < routes.size(); i++) {
		if (routes[i][0] <= curRight) {
			curLeft = min(curLeft, routes[i][0]);
			curRight = min(curRight, routes[i][1]);
		}
		else {
			curLeft = routes[i][0];
			curRight = routes[i][1];
			answer++;
		}
	}

	return answer;
}


//test
int main(void) {
	cout << solution({ {-20, -15},{-14, -5},{-18, -13},{-5, -3} });
}