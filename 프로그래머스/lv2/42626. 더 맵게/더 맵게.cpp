#include <string>
#include <vector>
#include <queue>
using namespace std;

int getMixedFood(int food1, int food2) {
	if (food1 < food2)
		return food1 + (food2 * 2);
	else
		return (food1 * 2) + food2;
}


int solution(vector<int> scoville, int K) {
	int answer = 0;
	
	priority_queue<int,vector<int>, greater<int>> foods;

	for (int i = 0; i < scoville.size(); i++)
		foods.push(scoville[i]);

	while (foods.empty() != true) {

		int food1 = foods.top();  foods.pop();

		if (food1 >= K)
			return answer;
		else {
			if (foods.empty() == true)
				return -1;
			else {
				int food2 = foods.top(); foods.pop();
				foods.push(getMixedFood(food1, food2));
				answer++;
			}
		}
		
	}
}