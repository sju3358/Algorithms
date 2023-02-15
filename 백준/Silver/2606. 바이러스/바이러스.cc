#include <queue>
#include <vector>
#include <iostream>

using namespace std;

int main() {

	vector<vector<bool>> networks;
	vector<bool> isVisit;
	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		vector<bool> computers;
		for (int j = 0; j < n; j++)
			computers.push_back(false);
		networks.push_back(computers);
		isVisit.push_back(false);
	}

	cin >> n;

	for (int i = 0; i < n; i++) {
		int computer1, computer2;
		cin >> computer1 >> computer2;

		networks[computer1 - 1][computer2 - 1] = networks[computer2 - 1][computer1 - 1] = true;
	}

	int sum = 0;

	queue<int> computers;

	computers.push(0);
	isVisit[0] = true;

	while (computers.empty() != true) {
		int computer = computers.front();
		computers.pop();

		for (int i = 0; i < networks.size(); i++) {
			if (isVisit[i] != true && networks[i][computer] == true) {
				isVisit[i] = true;
				computers.push(i);
				sum++;
			}
		}
	}

	cout << sum;
}