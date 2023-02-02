#include <string>
#include <iostream>

using namespace std;

string solution(int n) {
	string isPalindrome = to_string(n);

	int head = 0;
	int tail = isPalindrome.length() - 1;

	while (head <= tail) {
		if (isPalindrome[head++] != isPalindrome[tail--])
			return "no";
	}

	return "yes";
}

int main(void) {
	int n;
	
	while (1) {
		cin >> n;
		if (n == 0)
			break;
		cout << solution(n) << endl;
	}
}