#include <iostream>
#include <iomanip>
#include <stdio.h>
using namespace std;

typedef struct loc 
{
	int x;
	int y;
}loc;

loc dir[4] = { {1,0} ,{-1,0}, {0,1}, {0,-1} };

double probablity[4];
double result;
int N;

bool map[30][30];

void dfs(int x, int y, double prob)
{
	int i;
	int next_x;
	int next_y;

	if (N <= 0)
	{
		result = result + prob;
		return;
	}
	else
	{
		map[x][y] = true;
		for (i = 0; i < 4; i++)
		{
			next_x = x + dir[i].x;
			next_y = y + dir[i].y;

			if (map[next_x][next_y] == false)
			{
				N--;
				dfs(next_x, next_y, prob * probablity[i]);
				N++;
				map[next_x][next_y] = false;
			}
		}
	}
}

int main(void)
{
	int i;
	int temp;

	scanf("%d", &N);

	for (i = 0; i < 4; i++)
	{
		scanf("%d", &temp);
		probablity[i] = temp * (0.01);
	}
	dfs(15, 15, 1);

	cout << fixed << setprecision(10) << result << endl;
}
