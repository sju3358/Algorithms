#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

void tower(int n, int start, int empty, int end) {
	if (n == 1) { 
		printf("%d %d\n", start, end);
		return;
	}

	tower(n - 1, start, end, empty);
	tower(1, start, empty, end);
	tower(n - 1, empty, start, end);

	return;
}

int main() {
	int n;
	cin >> n;
	cout << (int)pow(2, n) - 1 << endl;
	tower(n, 1, 2, 3);
}