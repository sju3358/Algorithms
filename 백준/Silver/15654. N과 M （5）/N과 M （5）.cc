#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> numbers;


void getPermutation(int n, int m, vector<int> curIndex,vector<bool> visited, int cnt) {
	if (cnt == m) {
		for (int i = 0; i < curIndex.size(); i++) {
			cout << numbers[curIndex[i]] << " ";
		}
		cout << '\n';
	}
	else {
		
		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				curIndex[cnt] = i;
				getPermutation(n, m, curIndex, visited, cnt + 1);
				visited[i] = false;
			}
		}
	}
}

void nPm(int n, int m) {
	vector<int> curIndex;
	vector<bool> visited;
	for (int i = 0; i < m; i++) 
		curIndex.push_back(-1);
	for (int i = 0; i < n; i++)
		visited.push_back(false);
	getPermutation(n, m, curIndex,visited, 0);

}


int main() {

	int n; cin >> n;
	int m; cin >> m;
	for (int i = 0; i < n; i++) {
		int number; cin >> number;
		numbers.push_back(number);
	}

	sort(numbers.begin(), numbers.end());

	nPm(n,m);
}