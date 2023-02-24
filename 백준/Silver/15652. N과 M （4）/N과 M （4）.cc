#include <iostream>
#include <vector>


using namespace std;

vector<int> numbers;


void getPermutation(int n, int m, vector<int> curIndex, int cnt) {
	if (cnt == m) {
		for (int i = 0; i < curIndex.size(); i++) {
			cout << numbers[curIndex[i]] << " ";
		}
		cout << '\n';
	}
	else {
		int start = cnt == 0 ? 0 : curIndex[cnt - 1];
		for (int i = start; i < n; i++) {
			curIndex[cnt] = i;
			getPermutation(n, m, curIndex, cnt + 1);
		}
	}
}

void nPm(int n, int m) {
	vector<int> curIndex;
	for (int i = 0; i < m; i++) {
		curIndex.push_back(-1);
	}

	getPermutation(n, m, curIndex, 0);

}


int main() {

	int n; cin >> n;
	int m; cin >> m;
	for (int i = 0; i < n; i++) {
		numbers.push_back(i + 1);
	}

	nPm(n,m);
}