#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> citations) {
	
	sort(citations.begin(), citations.end());

	int left = citations[0];
	int right = citations[citations.size() - 1];
	
	int max = -1;

	for (int h = 0; h <= citations.size(); h++) {
		bool  flag = citations.end() - lower_bound(citations.begin(), citations.end(), h) >= h;
		if (flag && max < h)
			max = h;
	}

	return max;

}


int main(void) {

}