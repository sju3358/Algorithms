#include <iostream>

using namespace std;


int arr[1000001];
int cost[6];

int main(void) {
	
	int n; cin >> n;
	int cnt = 0;

	
	arr[1] = 0;
	for (int i = 2; i < 4; i++)
		arr[i] = 1;
	for (int i = 4; i <= 1000000; i++)
		arr[i] = -1;

	

	for (int i = 4; i <= n+1; i++) {
		
		int cost1 = 2100000000;
		int cost2 = 2100000000;
		int cost3 = 2100000000;

		bool flag1 = i % 3 == 0;
		bool flag2 = i % 2 == 0;

		if (flag1 || flag2) {
			
			if (flag1) 
				cost3 = arr[i / 3] + 1;

			if (flag2) 
				cost2 = arr[i / 2] + 1;

			int cost1 = arr[i - 1] + 1;
			
			arr[i] = cost2 < cost3 ? cost2 : cost3;
			arr[i] = arr[i] < cost1 ? arr[i] : cost1;
		}
		else 
			arr[i] = arr[i - 1] + 1;
	}

	cout << arr[n];
}