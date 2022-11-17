#include <iostream>
#include <vector>

using namespace std;

vector<long long> seq;
vector<int> selected;
long long S;
int N;
unsigned long long result = 0;

void getResult(int cur_index, long long sum)
{

	for (long long i = selected[cur_index - 1] + 1; i < N; i++)
	{

		selected[cur_index] = i;

		if (sum + seq[i] == S)
			result++;
		else
			getResult(cur_index + 1, sum + seq[i]);
	}
}

int main(void)
{

	int t;
	cin >> t;
	
	for (int i = 0; i < 20; i++)
	{
		seq.push_back(1);
		
		selected.push_back(-1000001);
	}

	for (int test_case = 1; test_case <= t; test_case++)
	{

		cin >> N >> S;

		for(int l = 0; l < N; l++)
			cin >> seq[l];

		for (int i = 0; i < N; i++)
		{

			if (seq[i] == S)
			{
				result++;
				continue;
			}

			selected[0] = i;
			getResult(1, seq[i]);

			
		}
		cout << "#" << test_case << " " << result << endl;
		result = 0;
	}
}