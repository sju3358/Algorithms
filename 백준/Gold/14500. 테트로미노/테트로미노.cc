#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool isInBoundary(int i, int j, int n, int m) {
	return 0 <= i && i < n && 0 <= j && j < m;
}

// ----
int getMax1(vector<vector<int>> map) {
	
	int maxSum = -1;

	int n = map.size();
	int m = map[0].size();
	
	//가로
	for (int i = 0; i < n; i++) {
		
		int sum = 0;
		
		for (int j = 0; j < m; j++) {
			if(isInBoundary(i, j + 3, n, m))
				sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//세로
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 3, j, n, m))
				sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];

			if (maxSum < sum)
				maxSum = sum;
		}
		
	}


	return maxSum;
}


// --
// --
int getMax2(vector<vector<int>> map) {

	int maxSum = -1;

	int n = map.size();
	int m = map[0].size();

	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 1, n , m))
				sum = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}


	return maxSum;
}



// ---
//  -
int getMax3(vector<vector<int>> map) {
	
	int maxSum = -1;

	int n = map.size();
	int m = map[0].size();

	//0 ㅜ
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//90도(시계) ㅏ
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//180도(시계) ㅗ
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//270도(시계) ㅓ
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}


	return maxSum;
}


// -
// -
// --
int getMax4(vector<vector<int>> map) {
	
	int maxSum = -1;

	int n = map.size();
	int m = map[0].size();

	//0도
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}
	
	//90도(시계)
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//180도(시계)
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//270도(시계)
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//대칭 0도
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j];
			if(maxSum < sum)
				maxSum = sum;
		}
		
	}

	//대칭 90도
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//대칭 180도
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//대칭 270도
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	return maxSum;
}

// -
// --
//  -
int getMax5(vector<vector<int>> map) {
	
	int maxSum = -1;

	int n = map.size();
	int m = map[0].size();

	//가로
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//세로
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//대칭가로
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 1, j + 2, n, m))
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}

	//대칭세로
	for (int i = 0; i < n; i++) {

		int sum = 0;

		for (int j = 0; j < m; j++) {
			if (isInBoundary(i + 2, j + 1, n, m))
				sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
			if (maxSum < sum)
				maxSum = sum;
		}
		
	}


	return maxSum;
}

int solution(vector<vector<int>> map) {
	int maxSum = -1;

	maxSum = max(maxSum, getMax1(map));
	maxSum = max(maxSum, getMax2(map));
	maxSum = max(maxSum, getMax3(map));
	maxSum = max(maxSum, getMax4(map));
	maxSum = max(maxSum, getMax5(map));

	return maxSum;
	
}

int main() {

	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);


	int n, m;
	cin >> n >> m;

	vector<vector<int>> map;

	for (int i = 0; i < n; i++) {
		vector<int> inputs;
		for (int j = 0; j < m; j++) {
			int input; cin >> input;
			inputs.push_back(input);
		}
		map.push_back(inputs);
	}

	cout << solution(map);

}