#include <string>
#include <vector>
#include <iostream>
using namespace std;


int main() {


	vector<int> numbers;

	string input; cin >> input;
	string cur = "";


	int pos;
	int curPos = 0;
	
	char beforeOper = 0;
	int sum = 0;
	
	
	string number = "";
	for (int i = 0; i < input.length(); i++){

		if (input[i] == '-' || input[i] == '+') {
			sum += stoi(number);
			number = "";

			if (input[i] != '+') {
				numbers.push_back(sum);
				sum = 0;
			}
		}
		else
			number += input[i];
	}

	sum += stoi(number);
	numbers.push_back(sum);

	int answer = numbers[0];

	if (numbers.size() > 1){
		for (int i = 1; i < numbers.size(); i++)
			answer = answer - numbers[i];
	}

	cout << answer;
}