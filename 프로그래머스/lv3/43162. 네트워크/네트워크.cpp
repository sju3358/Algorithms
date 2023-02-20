#include <string>
#include <vector>
#include <queue>
#include <stdio.h>
#include <iostream>


using namespace std;

vector<bool> isVisit;

void bfs(int startIndex, vector<vector<int>> computers){
	
	queue<int> nextNode;
	nextNode.push(startIndex);
	isVisit[startIndex] = true;

	while (nextNode.empty() != true) {
		int curNode = nextNode.front(); nextNode.pop();

		for (int i = 0; i < computers.size(); i++) {
			if (isVisit[i] == false && computers[curNode][i] == 1) {
				isVisit[i] = true;
				nextNode.push(i);
			}
		}
	}
}


int solution(int n, vector<vector<int>> computers) {
	int answer = 0;

	//map 초기화
	for (int i = 0; i < n; i++) {
		isVisit.push_back(false);
	}


	for (int i = 0; i < n; i++) {
		if (isVisit[i] == false) {
			bfs(i, computers);
			answer++;
		}
	}
	return answer;
}

int main() {
	
	cout << solution(3, { {1, 1, 0},{1, 1, 0},{0, 0, 1} });

}