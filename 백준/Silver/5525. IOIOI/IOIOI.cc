#include <string>
#include <iostream>
using namespace std;

string generatePn(int n) {
	
	string pn = "";
	int cnt = 0;

	bool flag = true;

	while (cnt < n) {
		if (flag == true) {
			pn += "I";
			flag = false;
		}
		else {
			pn += "O";
			flag = true;
			cnt++;
		}
	}
	
	return pn + "I";
}

int isPn(string input, string target, int startPos) {

	int cnt = 0;
	for (int i = startPos; i < i + target.length(); i++) {
		if(i >= input.length())
			return cnt;

		if (input[i] != target[cnt])
			return cnt;

		cnt++;
	}

	return true;
}

int main() {

	int answer = 0;
	int n; cin >> n;
	int length; cin >> length;

	string pn = generatePn(n);
	string input; cin >> input;

	int pos = 0;
	while( pos < input.length() ) {
		if (input[pos] == 'I') {
			int flag = isPn(input, pn, pos);

			if (flag == pn.length()) {
				answer++;
				pos = pos + 2;
			}
			else
				pos = pos + flag;
		}
		else
			pos = pos + 1;
	}

	cout << answer;

}