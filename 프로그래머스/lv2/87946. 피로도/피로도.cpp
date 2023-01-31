#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>

using namespace std;

int result = -1;

void playDungeons(int k, int numOfVIist, int visitIndex, vector<vector<int>> dungeons, vector<bool> isVisited) {

	

	if (numOfVIist >= dungeons.size())
		return;

	if (visitIndex != -1)
		isVisited[visitIndex] = true;

	for (int i = 0; i < dungeons.size(); i++) {
		if (k >= dungeons[i][0] && isVisited[i] != true) {
			if (result < numOfVIist+1)
				result = numOfVIist+1;
			playDungeons(k - dungeons[i][1], numOfVIist+1, i, dungeons, isVisited);
		}
	}

	
}

int solution(int k, vector<vector<int>> dungeons) {
	vector<bool> isVisited;
	for (int i = 0; i < dungeons.size(); i++)
		isVisited.push_back(false);

	playDungeons(k, 0, -1, dungeons, isVisited);

	return result;
}

// int main() {
// 	//cout << solution(80, { {80,20},{50,40},{30,10} }) << endl;
// 	cout << solution(80, { {80,20},{50,40},{30,10},{20,20} }) << endl;
// }