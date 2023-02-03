//push_front X : 정수 X를 덱의 앞에 넣는다.
//push_back X : 정수 X를 덱의 뒤에 넣는다.
//pop_front : 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다.만약, 덱에 들어있는 정수가 없는 경우에는 - 1을 출력한다.
//pop_back : 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다.만약, 덱에 들어있는 정수가 없는 경우에는 - 1을 출력한다.
//size : 덱에 들어있는 정수의 개수를 출력한다.
//empty : 덱이 비어있으면 1을, 아니면 0을 출력한다.
//front : 덱의 가장 앞에 있는 정수를 출력한다.만약 덱에 들어있는 정수가 없는 경우에는 - 1을 출력한다.
//back : 덱의 가장 뒤에 있는 정수를 출력한다.만약 덱에 들어있는 정수가 없는 경우에는 - 1을 출력한다.

#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(void) {

	int n; cin >> n;

	vector<int> deque;
	vector<string> instructions = { "push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back" };

	for (int i = 0; i < n; i++) {
		string instruction; cin >> instruction;

		if (instruction.compare(instructions[0]) == 0) {
			int input; cin >> input;
			vector<int> temp; temp.push_back(input);
			for (int i = 0; i < deque.size(); i++) {
				temp.push_back(deque[i]);
			}
			deque = temp;
		}
		else if (instruction.compare(instructions[1]) == 0) {
			int input; cin >> input;
			deque.push_back(input);
		}
		else if (instruction.compare(instructions[2]) == 0) {
			if (deque.empty())
				cout << -1 << endl;
			else {
				vector<int> temp;
				for (int i = 1; i < deque.size(); i++) {
					temp.push_back(deque[i]);
				}
				cout << deque.front() << endl;
				deque = temp;
			}
		}
		else if (instruction.compare(instructions[3]) == 0) {
			if (deque.empty())
				cout << -1 << endl;
			else {
				cout << deque.back() << endl;
				deque.pop_back();
			}
		}
		else if (instruction.compare(instructions[4]) == 0) {
			cout << deque.size() << endl;
		}
		else if (instruction.compare(instructions[5]) == 0) {
			cout << (deque.empty() ? 1 : 0) << endl;
		}
		else if (instruction.compare(instructions[6]) == 0) {
			if (deque.empty())
				cout << -1 << endl;
			else
				cout << deque[0] << endl;
		}
		else if (instruction.compare(instructions[7]) == 0) {
			if (deque.empty())
				cout << -1 << endl;
			else
				cout << deque[deque.size() - 1] << endl;
		}

	}
}