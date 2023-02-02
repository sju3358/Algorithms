#include <iostream>
#include <stack>
#include <vector>
#include <string>

using namespace std;

string solution(int n,vector<int> seq) {

	string result = "";
	stack<int> num_stack;
	
	int idx = 0;
	for (int i = 0; i < n; i++){
		if (num_stack.empty() == true) {
			num_stack.push(i + 1);
			result += "+\n";
		}
		else {
			while (num_stack.empty() != true && seq[idx] == num_stack.top()) {
				num_stack.pop();
				idx++;
				result += "-\n";
			}

			num_stack.push(i + 1);
			result += "+\n";

		}
	}

	while (num_stack.empty() != true && seq[idx] == num_stack.top()) {
		num_stack.pop();
		idx++;
		result += "-\n";
	}

	if (idx == n)
		return result;
	else
		return "NO";

}


int main(void) {
	
	int n; cin >> n;
	vector<int> seq;
	for (int i = 0; i < n; i++) {
		int input; cin >> input;
		seq.push_back(input);
	}

	cout << solution(n, seq) << endl;

}