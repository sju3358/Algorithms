#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<vector<int>> imageDatas;

bool isCheck(int startI, int startJ, int size){
	int pivot = imageDatas[startI][startJ];

	for (int i = startI; i < startI + size; i++)
		for (int j = startJ; j < startJ + size; j++)
			if (imageDatas[i][j] != pivot)
				return false;


	return true;
}

string zipImages(int i, int j, int size) {
	
	string result = "";

	
	if(isCheck(i, j, size)){
		result.append(to_string(imageDatas[i][j]));
	}
	else {
		int nextSize = size / 2;
		result.append("(");
		result.append(zipImages(i,j,nextSize));
		result.append(zipImages(i,j+nextSize,nextSize));
		result.append(zipImages(i + nextSize, j, nextSize));
		result.append(zipImages(i+nextSize,j+nextSize,nextSize));
		result.append(")");
	}
	return result;
}



int main() {

	int n; cin >> n;

	for (int i = 0; i < n; i++) {
		vector<int> datas;
		string input; cin >> input;
		for (int j = 0; j < n; j++)
			datas.push_back(input[j] - '0');
		imageDatas.push_back(datas);
	}

	cout << zipImages(0, 0, n);
	
}