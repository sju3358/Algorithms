    
#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

unordered_map<string, int> pocketmon_names;
unordered_map<int, string> pocketmon_values;

int main(void) {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

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
			cout << itr->second<< '\n';
			
		}
		else {
			auto itr = pocketmon_names.find(input);
			cout << itr->second << '\n';
		}
	}
}