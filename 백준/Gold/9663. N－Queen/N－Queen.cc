#include <iostream>
#include <vector>

using namespace std;


vector<int> PPOQ; 	//Possible Position Of Q => ppoq
int N;
int sum = 0;



int getABS (int x, int y){
	return x > y ? x - y : y - x;
}

bool isPromising(int cur_idx){
	
	for(int j = 0; j<cur_idx; j++){
		
		int row = getABS(cur_idx, j);
		int col = getABS(PPOQ[cur_idx],PPOQ[j]);
		
		if(PPOQ[j] == PPOQ[cur_idx] || row == col){
			return false;
		}
	}
	return true;
}

void getNumOfPPOQ(int cur_idx){
	
	//8개 모두 정상적으로 놓아짐
	if(cur_idx == N){
		sum ++;
		return;
	}
	
	for(int i = 0; i<N; i++){
		//놓아본다.
		PPOQ[cur_idx] = i;
		
		if(isPromising(cur_idx))
			getNumOfPPOQ(cur_idx+1);	
	}
}



int main(void){
	
	
	cin >> N;
	
	for(int i = 0; i<N; i++){
		PPOQ.push_back(-1);
	}
	getNumOfPPOQ(0);
	cout <<sum;

	

	// for(int i = 1; i<=15; i++)
	// {
	// 	int sum = 0;
	// 	vector<int> PPOQ;//Possible Position Of Q => ppoq
	// 	getNumOfPPOQ(PPOQ , sum , i);
	// 	cout << i << ": " << sum << endl;
	// }

	
}

