#include <queue>
#include <iostream>
#include <vector>
#include <set>
using namespace std;	

typedef long long int64;

int main() {

	
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t; cin >> t;
	while (t--) {
		multiset<int64> twoWayPrioirtyQueue;

		int k; cin >> k;

		for (int i = 0; i < k; i++) {

			char action;
			int64 input;
			cin >> action >> input;


			if (action == 'I')
				twoWayPrioirtyQueue.insert(input);
			else if (action == 'D' && twoWayPrioirtyQueue.empty() != true) {

				if (input == 1) {
					auto iter = twoWayPrioirtyQueue.end();
					iter--;
					twoWayPrioirtyQueue.erase(iter);
				}
				else if (input == -1) {

					auto iter = twoWayPrioirtyQueue.begin();
					twoWayPrioirtyQueue.erase(iter);
				}
			}
		}
		if (twoWayPrioirtyQueue.empty() == true)
			cout << "EMPTY" << "\n";
		else {
		
			

			auto iter = twoWayPrioirtyQueue.end();
			iter--;

			

			cout << *iter << " " << *twoWayPrioirtyQueue.begin() << "\n";
		}
	}
}