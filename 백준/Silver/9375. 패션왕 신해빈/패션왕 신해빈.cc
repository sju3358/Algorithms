#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
using namespace std;


int main(void) {
	
	int T; cin >> T;

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	vector<int> results;

	while (T--) {
		
		unordered_map<string,int> clothes;

		int N;  cin >> N;
		for (int i = 0; i < N; i++) {
			string cloth;
			string type;
			cin >> cloth >> type;

			auto iter = clothes.find(type);
			if (iter == clothes.end())
				clothes.insert(make_pair( type,1 ));
			else {
				iter->second = iter->second + 1;
			}
		}

		vector<int> countsByType;
		for (auto iter = clothes.begin(); iter != clothes.end(); iter++)
			countsByType.push_back(iter->second);
		
		
		int sum = 1;
		
		for (int i = 0; i < countsByType.size(); i++)
			sum = sum * (countsByType[i] + 1);

		results.push_back(sum - 1);
	}

	for (int sum : results)
		cout << sum << '\n';


}