#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int getMax(int a, int b, int c) {
	a = max(a, b);
	a = max(a, c);
	return a;
}

int getMin(int a, int b, int c) {
	a = min(a, b);
	a = min(a, c);
	return a;
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n;
	int maxDp[3] = { 0, 0, 0};
	int minDp[3] = { 0, 0, 0};
	
	int sumMax1 = 0, sumMax2 = 0, sumMax3 = 0;
	int sumMin1 = 0, sumMin2 = 0, sumMin3 = 0;

	/*cin >> maxDp[0] >> maxDp[1] >> maxDp[2];

	minDp[0] = maxDp[0];
	minDp[1] = maxDp[1];
	minDp[2] = maxDp[2];
*/

	for (int i = 0; i < n; i++) {
		
		int input1, input2, input3;
		cin >> input1 >> input2 >> input3;
		sumMax1 = input1 + max(maxDp[0], maxDp[1]);
		sumMax2 = input2 + getMax(maxDp[0], maxDp[1], maxDp[2]);
		sumMax3 = input3 + max(maxDp[1], maxDp[2]);

		sumMin1 = input1 + min(minDp[0], minDp[1]);
		sumMin2 = input2 + getMin(minDp[0], minDp[1], minDp[2]);
		sumMin3 = input3 + min(minDp[1], minDp[2]);

		maxDp[0] = sumMax1;
		maxDp[1] = sumMax2;
		maxDp[2] = sumMax3;

		minDp[0] = sumMin1;
		minDp[1] = sumMin2;
		minDp[2] = sumMin3;

	}

	cout << getMax(sumMax1, sumMax2, sumMax3) << " " << getMin(sumMin1, sumMin2, sumMin3);
}