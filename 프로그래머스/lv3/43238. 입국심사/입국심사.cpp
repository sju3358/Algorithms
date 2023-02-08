#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long int64;

int64 getWaitPeople(vector<int> times, int64 pivot) {

	int64 sum = 0;
	for (int i = 0; i < times.size(); i++)
		sum += pivot / times[i];

	return sum;
}


int64 solution(int n, vector<int> times) {

	sort(times.begin(), times.end());

	int64 low = 1;
	int64 high = 1000000000000000000;


	while (low < high) {

		int64 mid = (low + high) / 2;
		
		int64 valueOfMid = getWaitPeople(times, mid);
		
		if (valueOfMid < n)
			low = mid + 1;
		else
			high = mid;

	}

	return high;
}


// int main(void) {
	
// 	cout << solution(6, { 7,10 });
	
// }