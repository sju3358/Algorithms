#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<int> solution(vector<int> input) {
	vector<int> cds;
	vector<int> answer;

	bool flag = true;

	while (flag) {

		flag = false;
		for (int i = 2; i <= min(input[0], input[1]); i++) {
			if (input[0] % i == 0 && input[1] % i == 0) {
				input[0] /= i;
				input[1] /= i;
				cds.push_back(i);
				flag = true;
				break;
			}
		}
	}

	int gcd = 1;
	int lcm = 1;

	for (int cd : cds)
		gcd *= cd;
	
	lcm = gcd * input[0] * input[1];

	answer.push_back(gcd);
	answer.push_back(lcm);

	return answer;
}

int main(void) {
	vector<int> input;

	int temp;
	cin >> temp; input.push_back(temp);
	cin >> temp; input.push_back(temp);

	vector<int> answer = solution(input);
	cout << answer[0] << endl;
	cout << answer[1] << endl;
}