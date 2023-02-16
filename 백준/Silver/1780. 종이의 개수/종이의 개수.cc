#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> paper;
int answer[3] = { 0,0,0 };

bool isPossible(int start_i, int start_j, int size) {

	if (size == 1)
		return 1;

	int pivot = paper[start_i][start_j];
	for (int i = start_i; i < start_i + size; i++) {
		for (int j = start_j; j < start_j + size; j++)
			if (paper[i][j] != pivot)
				return false;
	}
	return true;
}

void getSumOfPaper(int i, int j, int size) {
	
	if(isPossible(i,j,size) == true){
		answer[paper[i][j] + 1]++;
	}
	else {
		
		int nextSize = size / 3;

		for (int nextI = i; nextI < i + size; nextI += nextSize)
			for (int nextJ = j; nextJ < j + size; nextJ += nextSize)
				getSumOfPaper(nextI, nextJ, nextSize);
	}
}


int main(void) {
	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		vector<int> temp;
		for (int j = 0; j < n; j++) {
			int input; cin >> input;
			temp.push_back(input);
		}
		paper.push_back(temp);
	}
	getSumOfPaper(0,0,paper.size());
	for (int n : answer)
		cout << n << endl;
}