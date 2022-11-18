#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	// cin>>T;
	
	for(test_case = 1; test_case <= 10; ++test_case){
		
		vector<int> boxHeight;
		int dumpCount;
		cin >> dumpCount;

		for(int i = 0; i<100; i++){
			int height;
			cin >> height;
			boxHeight.push_back(height);
		}

		while(dumpCount--){
			int max = -1;
			int min = 101;
			int max_idx = 0;
			int min_idx = 0;
			for(int i = 0; i<100; i++){
				if(max < boxHeight[i]){
					max = boxHeight[i];
					max_idx = i;
				}

				if(min > boxHeight[i]){
					min = boxHeight[i];
					min_idx = i;
				}
			}
			boxHeight[max_idx]--;
			boxHeight[min_idx]++;
		}

		int max = -1;
		int min = 101;
		int max_idx = 0;
		int min_idx = 0;
		for(int i = 0; i<100; i++){
			if(max < boxHeight[i]){
					max = boxHeight[i];
					max_idx = i;
				}

				if(min > boxHeight[i]){
					min = boxHeight[i];
					min_idx = i;
				}
		}
		cout<<"#"<<test_case<<" "<<boxHeight[max_idx] - boxHeight[min_idx]<<endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}