#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void) {
	string input; cin >> input;

	vector<string> grades = { "A+",  "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0","D-","F" };
	vector<string> scores = { "4.3","4.0","3.7","3.3","3.0","2.7","2.3","2.0","1.7","1.3","1.0","0.7","0.0" };

	for (int i = 0; i < grades.size(); i++)
		if (grades[i].compare(input) == 0)
			cout << scores[i];
}