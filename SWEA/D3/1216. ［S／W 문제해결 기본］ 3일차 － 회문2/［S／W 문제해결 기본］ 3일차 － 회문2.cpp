#include <iostream>
#include <vector>
#include <string>
using namespace std;


bool isPalindrome(string str){
	
	int strLen = str.length();
	
	for(int i = 0; i<strLen/2; i++){
		if(str[i] != str[strLen-1-i])
			return false;
	}
	return true;
}



int main(int argc, char** argv)
{
	int test_case;
	
	

	for(test_case = 1; test_case <= 10; ++test_case)
	{
		int testcase;
		cin >> testcase;
		int result = 0;
		vector<string> map;

		for(int i = 0; i<100; i++){
				string input;
				cin >> input;
			map.push_back(input);
		}

		int max = 0;

		for(int row = 0; row < 100; row++){
			for(int start = 0; start<100; start++){
				string text = "";
				for(int end = start; end<100; end++){
					text += map[row][end];
					if(isPalindrome(text))
						if(max < text.length())
							max = text.length();
				}
			}
		}

		for(int col = 0; col < 100; col++){
			for(int start = 0; start<100; start++){
				string text = "";
				for(int end = start; end<100; end++){
					text += map[end][col];
					if(isPalindrome(text))
						if(max < text.length())
							max = text.length();
				}
			}
		}


		cout << "#" << testcase << " "<< max << endl;
	}
	return 0;
}