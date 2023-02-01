#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


bool compare(string a, string b) {

	for (int i = 0; i < min(a.length(), b.length());i++)
		if (a[i] == b[i])
			continue;
		else
			return a[i] > b[i];

	if (a.length() == b.length())
		return false;
	
	int targetA = stoi(a + b);
	int targetB = stoi(b + a);

	return targetA > targetB;

}

string solution(vector<int> numbers){

	string answer = "";

	vector<string> stringsOfNumbers;
	for (int i = 0; i < numbers.size(); i++) {
		stringsOfNumbers.push_back(to_string(numbers[i]));
	}

	sort(stringsOfNumbers.begin(), stringsOfNumbers.end(), compare);

	for (int i = 0; i < stringsOfNumbers.size(); i++)
		answer += stringsOfNumbers[i];

	if (answer[0] == '0')
		answer = "0";

	return answer;

}

// int main(void) {
// 	cout << solution({ 6,10,2 }) << endl;
// 	cout << solution({ 3,30,34,5,9 }) << endl;
// 	cout << solution({ 123,1232 }) << endl;
// 	cout << solution({ 0,0 }) << endl;
// 	cout << solution({ 1000,999 }) << endl;
// 	cout << solution({ 898,89 }) << endl;
// 	cout << solution({ 818,81 }) << endl;
// }