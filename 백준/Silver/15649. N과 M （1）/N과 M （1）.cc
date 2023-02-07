#include <iostream>
#include <vector>

using namespace std;

void getPermutation(vector<int> seq,vector<int> cur, vector<bool> isVisited, int m) {
	
	if (cur.size() == m) {
		for (int n : cur)
			cout << seq[n] << " ";
		cout << "\n";
	}
	else {
		

		for (int i = 0; i < seq.size(); i++) {

			if (isVisited[i] == true)
				continue;
			cur.push_back(i); isVisited[i] = true;
			getPermutation(seq,cur,isVisited,m);
			cur.pop_back(); isVisited[i] = false;
		}
	}
}



int main(void) {
	int n, m;
	cin >> n >> m;
	
	vector<int> seq;
	vector<bool> isVisited;
	for (int i = 0; i < n; i++) {
		seq.push_back(i + 1);
		isVisited.push_back(false);
	}
	

	vector<int> cur;
	getPermutation(seq, cur, isVisited, m);
	
}