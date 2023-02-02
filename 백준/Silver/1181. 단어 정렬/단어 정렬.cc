#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


bool compare(string a, string b) {

	if (a.length() == b.length())
		return a < b;

	else
		return a.length() < b.length();

}

int main(void) {
	
	int n;
	cin >> n;

	vector<string> inputs;

	for (int i = 0; i < n; i++) {
		string input; cin >> input;
		inputs.push_back(input);
	}

	sort(inputs.begin(), inputs.end(),compare);
	
	vector<string> result;

	result.push_back(inputs[0]);
	
	for (int i = 1; i < inputs.size(); i++) {
		if (inputs[i] == inputs[i - 1])
			continue;
		result.push_back(inputs[i]);
	}

	for (string a : result)
		cout << a << endl;

	
}