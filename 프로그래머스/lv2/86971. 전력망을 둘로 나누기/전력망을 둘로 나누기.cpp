#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>
#include <queue>

using namespace std;

int result = -1;



vector<vector<bool>>  initMap(int n) {
	vector<vector<bool>> map;
	for (int i = 0; i < n; i++) {
		vector<bool> temp;
		for (int j = 0; j < n; j++) {
			temp.push_back(false);
		}
		map.push_back(temp);
	}
	return map;
}


void bfs(queue<int> bfsQueue, vector<vector<bool>> map, vector<bool>& isVisited, int& length) {

	if (bfsQueue.empty() == true)
		return;
	else {
		int curNode = bfsQueue.front();
		bfsQueue.pop();
		
		for (int i = 0; i < map.size(); i++) {
			if (map[curNode][i] == true && isVisited[i] != true) {
				isVisited[i] = true;
				bfsQueue.push(i);
				length++;
			}
		}

		bfs(bfsQueue, map, isVisited, length);
	}

}



int getAbs(vector<vector<bool>> map,int xNode, int yNode) {
	
	vector<bool> isVisited;
	for (int i = 0; i < map.size(); i++)
		isVisited.push_back(false);

	queue<int> bfsQueue;
	
	bfsQueue.push(xNode); isVisited[xNode] = true;
	int sizeOfX = 0;
	bfs(bfsQueue, map, isVisited, sizeOfX);
	
	bfsQueue.push(yNode); isVisited[yNode] = true;
	int sizeOfY = 0;
	bfs(bfsQueue, map, isVisited, sizeOfY);

	return sizeOfX > sizeOfY ? sizeOfX - sizeOfY : sizeOfY - sizeOfX;
	

}


int solution(int n, vector<vector<int>> wires) {
	
	int min = 2100000000;
	int xNode;
	int yNode;

	for (int i = 0; i < wires.size(); i++) {

		vector<vector<bool>> temp = initMap(n);;

		for (int j = 0; j < wires.size(); j++) {
			if (j == i) {
				xNode = wires[i][0]-1;
				yNode = wires[i][1]-1;
				continue;
			}
			
			temp[wires[j][0]-1][wires[j][1]-1] = temp[wires[j][1]-1][wires[j][0]-1] = true;
		}

		int abs = getAbs(temp, xNode, yNode);
		if (min > abs)
			min = abs;
	}

	return min;

}

// int main() {
// 	cout << solution(9, { {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}) << endl;
// 	cout << solution(4, { {1,2},{2,3},{3,4} }) << endl;
// 	cout << solution(7, { {1,2},{2,7},{3,7},{3,4},{4,5},{6,7} }) << endl;
// }