#include <iostream>
#include <vector>
#include <string>

using namespace std;


int main(void) {
	
	int n; cin >> n;
	string inputs; cin >> inputs;

	vector<int> letters;

	for (int i = 0; i < inputs.length(); i++)
		letters.push_back(inputs[i] - 'a' + 1);

	unsigned long long hash = 0;

	for (int i = letters.size()-1; i >= 0; i--) {
		hash = hash * 31 + letters[i];
		hash = hash % 1234567891;
	}

	cout << hash;

}