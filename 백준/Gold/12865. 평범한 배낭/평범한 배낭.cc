#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <set>
#include <string>
#include <algorithm>

using namespace std;

int maxWeight;
int maxValue = -1;

typedef struct item {
	int weight;
	int value;
}Item;

vector<Item> items;

vector<vector<int>> dp;

int getMaxValue() {

	for (int weight = 0; weight <= maxWeight; weight++) {
		if (items[0].weight <= weight)
			dp[0][weight] = items[0].value;
	}

	for (int index = 1; index < items.size(); index++) {
		Item item = items[index];

		for (int weight = 0; weight <= maxWeight; weight++) {
			
			int value1 = dp[index - 1][weight];
			int value2 = -1;
			if(weight - item.weight >= 0)
				value2 = item.value + dp[index - 1][weight - item.weight];
			
			dp[index][weight] = max(value1, value2);
		}
	}

	return dp[items.size()-1][maxWeight];
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n;
	cin >> maxWeight;

	for (int i = 0; i < n; i++) {
		int weight, value;
		cin >> weight >> value;
		items.push_back({ weight,value });
	}
	
	for (int i = 0; i < n; i++) {
		vector<int> temp;
		for (int j = 0; j <= maxWeight; j++)
			temp.push_back(0);
		dp.push_back(temp);
	}
	
	

	cout << getMaxValue();

}