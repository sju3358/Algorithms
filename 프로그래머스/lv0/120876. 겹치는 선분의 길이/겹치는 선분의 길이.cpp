#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> lines) {
    int map[200] = {0,};
	int answer = 0;

	for(int i = 0; i<3; i++){
		vector<int> line = lines[i];
		int a = line[0] + 100;
		int b = line[1] + 100;


		for(int j = a; j < b; j++)
			map[j]++;
	}

	for(int i = 0; i < 200; i++){
		if(map[i] > 1)
			answer++;
	}

    return answer;
}

// int main (void){
// 	cout << solution({{0,1},{2,5},{3,9}}) << endl;
// 	cout << solution({{1,1},{1,3},{3,9}}) << endl;
// 	cout << solution({{0,5},{3,9},{1,10}}) << endl;
// 	cout << solution({{-1,0},{0,1},{1,2}}) << endl;
// }