#include <iostream>
#include <stack>
#include <queue>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

stack<char> opr;
queue<char> answer;


int main() {
	
	string input;
	cin >> input;

	for (int i = 0; i < input.size(); i++) {

		if ('A' <= input[i] && input[i] <= 'Z') {
			answer.push(input[i]);
		}
		else {
			if (input[i] == '(') {
				
				opr.push(input[i]);
					
			}
			else if (input[i] == ')') {

				while (opr.empty() != true && opr.top() != '(') {
					answer.push(opr.top());
					opr.pop();
				}

				if(opr.empty() != true)
					opr.pop();

			}
			else {

				if (input[i] == '+' || input[i] == '-') {
					
					while (opr.empty() != true && opr.top() != '(') {
						answer.push(opr.top());
						opr.pop();
					}
					opr.push(input[i]);
				}
				else {
					while (opr.empty() != true && (opr.top() == '*' || opr.top() == '/') ) {
						answer.push(opr.top());
						opr.pop();
					}
					opr.push(input[i]);
				}
			}
		}

	}
	
	while (opr.empty() != true) {
		answer.push(opr.top());
		opr.pop();
	}

	while (answer.empty() != true) {
		cout << answer.front();
		answer.pop();
	}
}