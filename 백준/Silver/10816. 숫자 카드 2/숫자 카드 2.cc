#include <iostream>
#include <algorithm>
#include <vector>


using namespace std;

int main(void) {
	vector<int> cards;
	vector<int> counts;
	int n; cin >> n;
	
	for (int i = 0; i < n; i++) {
		int card; cin >> card;
		cards.push_back(card);
	}

	sort(cards.begin(), cards.end());

	cin >> n;
	for (int i = 0; i < n; i++) {
		int target; cin >> target;

		int count = upper_bound(cards.begin(), cards.end(), target) - lower_bound(cards.begin(), cards.end(), target);
		counts.push_back(count);
	}

	for (int i = 0; i < counts.size(); i++)
		cout << counts[i] << " ";


	
}