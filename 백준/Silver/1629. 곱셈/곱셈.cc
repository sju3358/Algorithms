#include <iostream>

using namespace std;

typedef unsigned long long int uint64;

int main() {

	int a, b, c;

	cin >> a;
	cin >> b;
	cin >> c;

	uint64 result = 1;


	while (b > 0) {
		uint64 cnt = 1;
		uint64 temp = a;
		
		while (cnt * 2 <= b) {
			temp = ((temp %c) * (temp % c)) % c;
			cnt = cnt * 2;
		}

		b = b - cnt;
		result = ((result % c) * (temp % c)) % c;
	}


	cout << result;

}