#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


typedef unsigned long long int64;

int64 cutLine(vector<int64> lines, int64 pivot) {

	int64 sum = 0;
	for (int64 line : lines)
		sum += line / pivot;

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
	while (start < end) {

		if (end - start == 1) {
			int64 cutResult1 = cutLine(lines, start);
			int64 cutResult2 = cutLine(lines, end);

			if (cutResult2 < n)
				end = start;
			break;
		}

		int64 mid = (start + end) / 2;

		int64 cutResult = cutLine(lines,mid);

		if (cutResult >= n)
			start = mid;
		else
			end = mid - 1;
	}

	cout << end;
	
}