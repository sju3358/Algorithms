#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


typedef long long int64;

int64 cutLine(vector<int64> lines, int64 pivot) {

	int64 sum = 0;
	for (int64 line : lines) {
		int64 temp = line - pivot;
		if (temp > 0)
			sum += temp;
	}

	return sum;
}

int main(void) {

	vector<int64> lines;

	int64 k;
	int64 n;

	cin >> k >> n;

	for (int64 i = 0; i < k; i++) {
		int64 line; cin >> line;
		lines.push_back(line);
	}

	sort(lines.begin(), lines.end());

	
	

	int64 start = 1;
	int64 end = lines[lines.size()-1];
	int64 mid;
	while (start <= end) {


		int64 mid = (start + end) / 2;

		int64 cutResult = cutLine(lines,mid);

		if (cutResult >= n)
			start = mid + 1;
		else
			end = mid - 1;
	}

	cout << end;
	
}