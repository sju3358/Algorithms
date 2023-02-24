#include <iostream>
#include <unordered_map>

using namespace std;

typedef long long int int64;

int64 mod = 1000000007;

unordered_map<int64, int64> dp;

int64 fibo(int64 n) {

	if (n == 0)
		return 0;
	else if (n <= 2)
		return 1;
	else {
		if (dp.count(n) > 0) {
			auto iter = dp.find(n);
			return iter->second;
		}
		else {
			if (n % 2 == 0) {
				int64 fibo1 = fibo(n / 2);
				int64 fibo2 = fibo(n / 2 - 1);
				int64 result = ((((2 * fibo1) % mod) * fibo2) % mod + (fibo1 * fibo1) % mod) % mod;
				dp.insert(make_pair(n, result));
				return result;
			}
			else {
				int64 fibo1 = fibo(n / 2 + 1);
				int64 fibo2 = fibo(n / 2);
				int64 result = ( (fibo1 * fibo1) % mod + (fibo2 * fibo2) % mod) % mod;
				dp.insert(make_pair(n, result));
				return result;
			}
		}
	}
}

int main() {
	int64 n; cin >> n;

	cout << fibo(n);
	
}