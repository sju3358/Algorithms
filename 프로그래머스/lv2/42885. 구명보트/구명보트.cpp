#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> people, int limit) {
	int answer = 0;

	sort(people.rbegin(), people.rend());

	int index = 0;
	int index_end = people.size() - 1;

	vector<bool> visited(people.size(), false);

	while (visited[index] != true && index < people.size()) {

		int curWeight = people[index];
		visited[index] = true;

		if (curWeight + people[index_end] <= limit) {
			visited[index_end] = true;
			index_end--;
		}

		answer++;
		index++;
		
	}
	return answer;
}

int main() {
	solution({ 70,50,80,50 },100);
}
