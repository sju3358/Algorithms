#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

int main(void){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	
	vector< pair<int, int>> num(n);

	for (int i = 0; i < n; i++) {
		cin >> num[i].first >> num[i].second;
	}

	sort(num.begin(), num.end());

	for (int i = 0; i < n; i++) {
		cout << num[i].first << " " << num[i].second << "\n";
	}

}
