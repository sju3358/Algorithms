#include <iostream>
#include <vector>


using namespace std;

vector<long long> seq; //수열
vector<long long> selected; //선택한 인덱스 0~cur_index번째까지가 선택한 수열
long long S; 
long long N;
long long result = 0;


void getResult(long long cur_index, long long sum){
	if(cur_index == N)
		return;
	
	if(sum+seq[cur_index] == S)
		result++; 
	
	getResult(cur_index+1,sum + seq[cur_index]);
	getResult(cur_index+1,sum);
	
}

int main (void){



	cin >> N >> S;

	//초기화 및 수열 입력받음.
	for(int i = 0; i<N; i++){
		seq.push_back(1);
		cin >> seq[i];
		selected.push_back(-1000001);
	}
	
	
	getResult(0,0);
	
	cout << result;
}