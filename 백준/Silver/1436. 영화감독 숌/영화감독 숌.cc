#include <iostream>

using namespace std;

int main(void) {
	
	int n; cin >> n;

	int cnt = 0;
	int num = 0;
	while (cnt < n) {

		int temp = ++num;

		while (temp) {
			if (temp % 1000 == 666) {
				cnt++;
				break;
			}
			temp = temp / 10;

		}

		

	}

	cout << num;

}