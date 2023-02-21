#include <vector>
#include <queue>
#include <iostream>


using namespace std;

typedef struct Node {
	int h;
	int r;
	int c;
	int day;
}Node;


queue<Node> nextNode;
vector<vector<vector<int>>> tomatoes;




int dir_r[] = { 0, 0,-1, 1, 0, 0};
int dir_c[] = {-1, 1, 0, 0, 0, 0};
int dir_h[] = { 0, 0, 0, 0, 1,-1};


bool isInBoundary(int h, int r, int c) {
	return 0 <= h && h < tomatoes.size() && 0 <= r && r < tomatoes[0].size() && 0 <= c && c < tomatoes[0][0].size();
}



void input() {

	int width, length, height;

	cin >> width >> length >> height;

	for (int i = 0; i < height; i++) {
		vector<vector<int>> temp;
		for (int j = 0; j < length; j++) {
			vector<int> temp2;
			for (int k = 0; k < width; k++) {
				int temp3; cin >> temp3;
				temp2.push_back(temp3);
				if (temp3 == 1)
					nextNode.push({ i,j,k,0});
			}
			temp.push_back(temp2);
		}
		tomatoes.push_back(temp);
	}
}



int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);


	input();

	int maxDay = 0;

	//bfs
	while (nextNode.empty() != true) {
		Node curNode = nextNode.front(); nextNode.pop();
		
		if (maxDay < curNode.day)
			maxDay = curNode.day;

		for (int i = 0; i < 6; i++) {
			int nextR = curNode.r + dir_r[i];
			int nextC = curNode.c + dir_c[i];
			int nextH = curNode.h + dir_h[i];
			if (isInBoundary(nextH, nextR, nextC) == true && tomatoes[nextH][nextR][nextC] == 0) {
				tomatoes[nextH][nextR][nextC] = 1;
				nextNode.push({ nextH, nextR, nextC, curNode.day + 1 });
			}
		}
	}
	
	bool isRipen = true;
	for(int i = 0; i < tomatoes.size(); i++)
		for (int j = 0; j < tomatoes[0].size(); j++) 
			for(int k = 0; k < tomatoes[0][0].size(); k++)
				if (tomatoes[i][j][k] == 0) {
					isRipen = false;
					i = tomatoes.size();
					j = tomatoes[0].size();
					k = tomatoes[0][0].size();
				}
	

	if (isRipen == true)
		cout << maxDay;
	else
		cout << -1;
}