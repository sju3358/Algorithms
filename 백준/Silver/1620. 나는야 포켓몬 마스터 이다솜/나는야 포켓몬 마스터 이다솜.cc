#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

unordered_map<string, int> pocketmon_names;
unordered_map<int, string> pocketmon_values;
string answer[100000];
int cnt = 0;
int main(void) {


	int n; cin >> n;
	int m; cin >> m;

	for (int i = 1; i <= n; i++) {
		string name; 
		cin >> name;
		
		pocketmon_values.insert({ i,name });
		pocketmon_names.insert({ name, i });
	}

	for (int i = 0; i < m; i++) {
		string input; cin >> input;
		
		if (isdigit(input[0])) {
			int num = stoi(input);
			auto itr = pocketmon_values.find(num);
			answer[cnt++] = itr->second;
			
		}
		else {
			auto itr = pocketmon_names.find(input);
			answer[cnt++] = to_string(itr->second);
		}
	}

	for (int i = 0; i < cnt; i++)
		cout << answer[i] << '\n';
}