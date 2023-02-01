#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int cntOfFIB = 0;
int cntOfFibonacci = 0;
vector<int> f;
int fib(int n) {
	if (n == 1 || n == 2) {
		cntOfFIB++;
		return 1;
	}
	else return (fib(n - 1) + fib(n - 2));
}

int fibonacci(int n) {
	
	if (n < 2)
		return 1;
	for (int i = 2; i < n; i++) {
		cntOfFibonacci++;
		f[i] = f[i - 1] + f[i - 2];
	}
	return f[n-1];
}


int main() {

	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
		f.push_back(0);
	f[0] = f[1] = 1;
	fib(n);
	fibonacci(n);
	cout << cntOfFIB << " " << cntOfFibonacci;
}
