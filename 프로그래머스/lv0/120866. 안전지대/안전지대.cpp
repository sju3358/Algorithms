#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool checkBoundary(int x, int y, int n){

	if(0 <= x && x < n && 0 <= y && y < n)
		return true;
	else
		return false;
}


int solution(vector<vector<int>> board) {
    int answer = 0;

	vector<vector<int>> map;
	for(int i = 0; i<board.size(); i++){
		vector<int> temp;
		for(int j = 0; j<board.size(); j++){
			temp.push_back(0);
		}
		map.push_back(temp);
	}

	vector<int> dir_x = {-1, -1, -1,  0,  0,  0,  1,  1,  1};
	vector<int> dir_y = {-1,  0,  1, -1,  0,  1, -1,  0,  1};
	for(int i = 0; i<board.size(); i++){
		for(int j = 0; j<board.size(); j++){
			if(board[i][j] == 1){
				
				for(int k = 0; k<9; k++){
					if(checkBoundary(i + dir_x[k], j+dir_y[k], board.size()))
						map[ i + dir_x[k] ][ j + dir_y[k] ] = 1;
				}
			}
		}
	}

	for(int i = 0; i<map.size(); i++)
		for(int j =0; j<map.size(); j++)
			if(map[i][j] == 0)
				answer++;

    return answer;
}

// int main (void){
// 	cout << solution({{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,1,0,0,},{0,0,0,0,0}});
// }