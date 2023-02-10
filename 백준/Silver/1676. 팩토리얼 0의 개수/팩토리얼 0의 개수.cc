#include <iostream>
#include <vector>
#include <functional>
#include <cstdio>
#include <queue>
#include <algorithm>
#include <string>


using namespace std;

int main (void) {
	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n; cin >> n;
	
	int cnt = 0;
	int num = 1;
	for (int i = 1; i <= n; i++) {
		num = num * i;
		
		while (num % 10 == 0) {
			num /= 10;
			cnt++;
		}
		num = num % 1000;
	}

	cout << cnt;
}