#include <iostream>
#include <queue>
#include <vector>
#include <math.h>
using namespace std;

typedef struct node {
	int i;
	int j;
	int lengthFromShark;
}Node;





int dir[][2] = { {1,0},{-1,0},{0,1},{0,-1} };


int time = 0;
int curSize = 2;
int countOfFishEat = 0;

int curI;
int curJ;


struct cmp {
	bool operator()(Node a, Node b) {

		if (a.lengthFromShark != b.lengthFromShark) {
			return a.lengthFromShark > b.lengthFromShark;
		}
		else {
			if (a.i != b.i) {
				return a.i > b.i;
			}
			else 
				return a.j > b.j;
		}
	}
};



vector<vector<int>> map;




bool isInBoundary(int i, int j) {
	return 0 <= i && i < map.size() && 0 <= j && j < map.size();
}

bool findFish() {

	priority_queue<Node, vector<Node>, cmp> fishes;
	vector<vector<bool>> flag;
	vector<vector<int>> dp;
	for (int i = 0; i < map.size(); i++) {
		vector<int> temp;
		vector<bool> temp2;
		for (int j = 0; j < map.size(); j++) {
			temp.push_back(-1);
			temp2.push_back(false);
		}
		dp.push_back(temp);
		flag.push_back(temp2);
	}


	queue<Node> nextNode;
	nextNode.push({ curI, curJ, 0});

	while (nextNode.empty() != true) {
		Node curNode = nextNode.front(); nextNode.pop();

		if (0 < map[curNode.i][curNode.j] && map[curNode.i][curNode.j] < curSize)
			flag[curNode.i][curNode.j] = true;
		
		if (dp[curNode.i][curNode.j] != -1) {
			if (dp[curNode.i][curNode.j] > curNode.lengthFromShark)
				dp[curNode.i][curNode.j] = curNode.lengthFromShark;
			
			continue;
		}
		else {

			dp[curNode.i][curNode.j] = curNode.lengthFromShark;

			for (int i = 0; i < 4; i++) {
				int nextI = curNode.i + dir[i][0];
				int nextJ = curNode.j + dir[i][1];

				if (isInBoundary(nextI, nextJ)) {
					if (map[nextI][nextJ] <= curSize) {
						nextNode.push({ nextI,nextJ,curNode.lengthFromShark+1});
					}
				}
			}
		}
	}

	for (int i = 0; i < map.size(); i++) {
		for(int j = 0; j < map.size(); j++)
			if (0 < map[i][j] && map[i][j] < curSize && flag[i][j] == true) {
				fishes.push({ i,j,dp[i][j] });
			}
	}

	if (fishes.empty() != true) {
		Node fish = fishes.top(); fishes.pop();

		map[fish.i][fish.j] = 0;
		countOfFishEat++;

		time += fish.lengthFromShark;

		curI = fish.i;
		curJ = fish.j;

		if (countOfFishEat == curSize) {
			curSize++;
			countOfFishEat = 0;
		}
		return true;
	}
	else
		return false;

	
}

void eatFish() {
		
}

int getMaxTime() {

	while (findFish()) {
		
	}
	

	return time;
}


int main () {

	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		vector<int> inputs;
		for (int j = 0; j < n; j++) {
			int input; cin >> input;

			if (input == 9) {
				curI = i;
				curJ = j;
				input = 0;
			}

			inputs.push_back(input);
		}
		map.push_back(inputs);
	}

	

	cout << getMaxTime();
}