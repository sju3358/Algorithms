#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> scoville, int K) {
	int answer = 0;
	
	priority_queue<int,vector<int>, greater<int>> foods;

	for (int i = 0; i < scoville.size(); i++)
		foods.push(scoville[i]);

	while (foods.empty() != true) {

		if (foods.top() >= K)
			return answer;
		else{
			int food1 = foods.top();  foods.pop();
			
			if (foods.empty() == true)
				return -1;
			else {
				int food2 = foods.top(); foods.pop();
				foods.push(food1 + (food2 * 2));
				answer++;
			}
		}
	}
}