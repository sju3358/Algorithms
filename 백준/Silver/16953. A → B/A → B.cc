#include <iostream>
#include <queue>
#include <vector>

using namespace std;

typedef struct number {
	long number;
	long cost;
}Number;

int main() {
	int n, k;
	bool isFind = false;
	int minLength = 2100000000;

	cin >> n >> k;

	queue<Number> nextNumber;
	nextNumber.push({n,1});

	while (nextNumber.empty() != true) {
		Number curNumber = nextNumber.front(); nextNumber.pop();

		if (curNumber.number == k) {
			isFind = true;
			if (minLength > curNumber.cost)
				minLength = curNumber.cost;
		}
		else {
			if (curNumber.number * 2 <= k)
				nextNumber.push({ curNumber.number * 2 , curNumber.cost + 1 });

			if(curNumber.number*10 + 1 <= k)
				nextNumber.push({ curNumber.number * 10 + 1 , curNumber.cost + 1 });
		}
	}

	if (isFind == false)
		cout << -1;
	else
		cout << minLength;
}