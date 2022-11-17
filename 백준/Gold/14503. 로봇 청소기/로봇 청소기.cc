#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> map;
vector<vector<bool>> isCleaned;
vector<vector<int>> directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int result = 1;


bool isInBoundary(int x, int y, vector<vector<bool>> isCleaned){
	
	int n = isCleaned.size();
	int m = isCleaned[0].size();
	
	bool x_boundary = ( 0 <= x && x < n);
	bool y_boundary = ( 0 <= y && y < m);
	
	if(x_boundary && y_boundary )
		return true;
	else
		return false;
}


void clean(int cur_i, int cur_j, int cur_dir)
{
	isCleaned[cur_i][cur_j] = true;
	
	for(int i = 0; i<4; i++){
		int next_dir = (cur_dir-(i+1) + 4) % 4;
		int next_i = cur_i + directions[next_dir][0];
		int next_j = cur_j + directions[next_dir][1];

		if(isInBoundary(next_i,next_j,isCleaned)){
			if(isCleaned[next_i][next_j] == false && map[next_i][next_j] == 0){	
				result++;
				clean(next_i, next_j, next_dir);
				return;
			}
		}
	}

	//후진
	int back_i = cur_i - directions[cur_dir][0];
	int back_j = cur_j - directions[cur_dir][1];

	if(isInBoundary(back_i,back_j,isCleaned) && map[back_i][back_j] == 0){
			clean(back_i,back_j,cur_dir);	
	}
	else
		return;
}

int main(void)
{

	int N, M;
	int cur_j, cur_i, cur_dir;
	

	cin >> N >> M;

	cin >> cur_i >> cur_j >> cur_dir;

	//초기화
	for (int i = 0; i < N; i++)
	{
		vector<int> inputs;
		vector<bool> cleaned;
		for (int j = 0; j < M; j++)
		{
			int input;
			cin >> input;
			inputs.push_back(input);
			cleaned.push_back(false);
		}
		map.push_back(inputs);
		isCleaned.push_back(cleaned);
	}
	

	clean(cur_i, cur_j, cur_dir);
	cout << result;
}