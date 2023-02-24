#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <string>
using namespace std;

vector<int> numbers;
unordered_set<string> permutations;

void getPermutation(int n, int m, vector<int> curIndex,vector<bool> visitied, int cnt) {
	if (cnt == m) {
		string seq;

		for (int i = 0; i < curIndex.size(); i++) {
			seq += '0' + numbers[curIndex[i]];
		}

		auto iter = permutations.find(seq);
		if (iter == permutations.end()){
			for (int i = 0; i < curIndex.size(); i++) {
				cout << numbers[curIndex[i]] << " ";
			}
			cout << '\n';
			permutations.insert(seq);
		}



		
	}
	else {
		
		for (int i = 0; i < n; i++) {
			if (visitied[i] != true) {
				visitied[i] = true;
				curIndex[cnt] = i;
				getPermutation(n, m, curIndex, visitied, cnt + 1);
				visitied[i] = false;
			}
		}
	}
}

void nPm(int n, int m) {
	vector<int> curIndex;
	vector<bool> visitied;
	for (int i = 0; i < m; i++) 
		curIndex.push_back(-1);
	for (int i = 0; i < n; i++)
		visitied.push_back(false);
	getPermutation(n, m, curIndex, visitied, 0);

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