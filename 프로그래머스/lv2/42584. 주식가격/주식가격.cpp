#include <stack>
#include <iostream>
#include <vector>
using namespace std;

typedef struct price {
	int price;
	int index;
}Price;

vector<int> solution(vector<int> prices) {
	vector<int> answer;

	for (int i = 0; i < prices.size(); i++)
		answer.push_back(0);

	stack<Price> priceStack;
	
	for (int i = 0; i < prices.size(); i++) {
		
		while (priceStack.empty() != true && priceStack.top().price > prices[i]) {
			Price price = priceStack.top();
			priceStack.pop();
			answer[price.index] = i - price.index;
		}

		priceStack.push({prices[i],i});
	}

	if (priceStack.size() > 2) {
		Price pivot = priceStack.top();
		priceStack.pop();
		while (priceStack.empty() != true) {
			Price price = priceStack.top();
			priceStack.pop();
			answer[price.index] = pivot.index - price.index;
		}
	}


	return answer;
}

int main() {
	for (int result : solution({ 1,2,3,2,3 }))
		cout << result << " ";
	
}

