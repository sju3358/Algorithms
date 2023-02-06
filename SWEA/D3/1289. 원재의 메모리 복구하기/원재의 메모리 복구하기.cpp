#include<iostream>
#include<string>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		string input; cin >> input;

		int cnt = 0;
		bool modifiedFlag = false;
		for (int i = 0; i < input.size(); i++) {

			if (input[i] == '1' && modifiedFlag == false) {
				modifiedFlag = true;
				cnt++;
			}
			else if (input[i] == '0' && modifiedFlag == true) {
				modifiedFlag = false;
				cnt++;
			}
		}
		cout << "#" << test_case << " " << cnt << endl;

	}
	return 0;
}