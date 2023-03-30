#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

int solution(vector<int> arrows) {
	int answer = 0;

	map<pair<int,int>,bool> nodes;
	map<pair<pair<int,int>,pair<int,int>>,bool> edges;

	int curX = 0;
	int curY = 0;

	nodes[{curX, curY}] = true;


	int dirX[] = { 0, 1, 1, 1, 0,-1,-1,-1};
	int dirY[] = { 1, 1, 0,-1,-1,-1, 0, 1};

	for (int i = 0; i < arrows.size(); i++) {
		
		for (int j = 0; j < 2; j++) {
			int nextX = curX + dirX[arrows[i]];
			int nextY = curY + dirY[arrows[i]];

			
			if (nodes[{nextX, nextY}] == true && edges[{ {curX,curY} ,{nextX,nextY}}] == false)
				answer++;

			nodes[{nextX, nextY}] = true;
			edges[{ {curX, curY}, { nextX,nextY }}] = true;
			edges[{ {nextX, nextY}, { curX,curY }}] = true;

			curX = nextX;
			curY = nextY;
		}
	}

	return answer;
}

int main() {
	cout << solution({ 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0 });
}