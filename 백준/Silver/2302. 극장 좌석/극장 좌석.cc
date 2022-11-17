#include <iostream>
#include <vector>

using namespace std;

vector<long long> fibo;
vector<int> seats;
long long getFibo(int n){
	
	if(n == 0 || n== 1)
		return 1;
	else{
		if(fibo.size() > n)
			return fibo[n];
		else{
			long long val = getFibo(n-1) + getFibo(n-2);
			fibo.push_back(val);
			return fibo[n];
		}
	}
}


int main(void){
	int N;
	cin >> N;

	fibo.push_back(1);
	fibo.push_back(1);

	for(int i = 0; i<N; i++){
		seats.push_back(0);
	}

	int M;
	cin >> M;

	for(int i = 0; i<M; i++){
		int vip_seat;
		cin >> vip_seat;
		seats[vip_seat-1] = 1;
	}

	long long sum = 1;
	int section= 0;
	for(int i = 0; i<N; i++){
		if(seats[i] == 0)
			section++;
		else{
			sum *= getFibo(section);
			section = 0;
		}
	}
	sum *= getFibo(section);

	cout << sum;
}