#include <iostream>

using namespace std;


int solution(int n, int r, int c) {
	
	int cnt = 0;
	
	while (n) {
		if (0 <= r && r < (n / 2) && 0 <= c && c < (n / 2)) {
			cnt += 0;
		}
		else if (0 <= r && r < (n / 2) && (n / 2) <= c && c < n) {
			cnt += (n / 2) * (n / 2);
			c = c - (n / 2);
		}
		else if ((n / 2) <= r && r < n && 0 <= c && c < (n / 2)) {
			cnt += (n / 2) * (n / 2) * 2;
			r = r - (n / 2);
		}
		else if ((n / 2) <= r && r < n && (n / 2) <= c && c < n) {
			cnt += (n / 2) * (n / 2) * 3;
			r = r - (n / 2);
			c = c - (n / 2);
		}

		n = n / 2;
	}

	return cnt;
}


int main(void) {
	
	int n, r, c; //n*n 크기, 행, 열

	
	int end = 1;
	for (int i = 0; i < end; i++) {
		cin >> n >> r >> c;
		
		int sizeOfMap = 1;
		for (int i = 0; i < n; i++)
			sizeOfMap *= 2;
		for (int i = 0; i < n; i++)
			sizeOfMap *= 2;
		
		cout << solution(sizeOfMap, r, c) << endl;
	}
	

	
}