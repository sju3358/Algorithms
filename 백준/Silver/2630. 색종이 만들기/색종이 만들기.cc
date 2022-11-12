#include <iostream>

using namespace std;

int mat[128][128];

void go(int n, int x, int y, int &b, int &w) {
	if (n == 1) {
		if (mat[x][y] == 1) b += 1;
		else w += 1;
		return;
	}
	bool ok = true;
	int target = mat[x][y];
	for (int i = x; i < x + n; i++) {
		for (int j = y; j < y + n; j++) {
			if (target != mat[i][j]) {
				ok = false;
			}
		}
	}
	if (ok) {
		if (target == 1) b += 1;
		else w += 1;
	}
	else {
		go(n / 2, x, y, b, w);
		go(n / 2, x + n / 2, y, b, w);
		go(n / 2, x, y + n / 2, b, w);
		go(n / 2, x + n / 2, y + n / 2, b, w);
	}
	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> mat[i][j];
		}
	}

	int b = 0, w = 0;
	go(n, 0, 0, b, w);
	cout << w << '\n' << b << '\n';
	return 0;
}