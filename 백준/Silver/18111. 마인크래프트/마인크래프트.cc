#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

vector<int> solution(vector<int> map, int b) {

	vector<int> answer; //0 : time , 1 : height;
	
	int minTime = 2100000000;
	int maxHeight = -1;;

	set<int> isVisit;

	sort(map.begin(), map.end());

	int sum = -1;

	for(int pivot = map[0]; pivot <=map[map.size()-1]; pivot++){


		int sumOfAddBlock = 0;
		int sumOfRemoveBlock = 0;


		for (int i = 0; i < map.size(); i++) {
			if (map[i] > pivot)
				sumOfRemoveBlock += map[i] - pivot;
			else
				sumOfAddBlock += pivot - map[i];
		}


		if (sumOfRemoveBlock + b >= sumOfAddBlock) {
			
			int time = sumOfRemoveBlock * 2 + sumOfAddBlock;
			
			if (time < minTime) {
				minTime = time;
				maxHeight = pivot;
			}
			else if (time == minTime) {
				if (maxHeight < pivot)
					maxHeight = pivot;
			}

		}
	}

	answer.push_back(minTime);
	answer.push_back(maxHeight);

	return answer;
}


int main(void) {
	int n, m, b;

	cin >> n >> m >> b;

	vector<int> map;

	for (int i = 0; i < n*m; i++) {
		int input; cin >> input;
		map.push_back(input);
	}


	vector<int> answer = solution(map, b);
	cout <<  answer[0] << " " <<answer[1];

}