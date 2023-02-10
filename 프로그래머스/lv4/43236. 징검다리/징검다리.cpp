#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int solution(int distance, vector<int> rocks, int n) {

	rocks.push_back(0);
	rocks.push_back(distance);
	sort(rocks.begin(), rocks.end());
	//0,2,11,14,17,21,25


	vector<int> distances;
	for (int i = 0; i < rocks.size() - 1; i++) 
		distances.push_back(rocks[i + 1] - rocks[i]);
	//2,9,3,3,4,4


	
	int low = 0;
	int high = distance;
	int mid;
	while (low < high) {
		mid = (low + high) / 2;

		int curDistance = 0;
		int removedRocks = 0;
		for (int i = 0; i < distances.size(); i++) {
			
			curDistance += distances[i];

			if (curDistance < mid)
				removedRocks++;
			else
				curDistance = 0;
		}

		if (removedRocks > n)
			high = mid;
		else if (removedRocks <= n)
			low = mid + 1;
	}

	return high-1;
}


int main (void){
	cout << solution(25, {2,14,11,21,17},2) << endl; 
	cout << solution(16, { 4,8,11}, 2) << endl;
	cout << solution(23, { 3,6,9,10,14,17 }, 2) << endl;
}