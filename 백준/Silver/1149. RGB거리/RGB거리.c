#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

int min(int a, int b)
{
	if (a < b)
		return a;
	else
		return b;
}

int sum(int (*cost)[3], int (*rgb)[3], int i, int j)
{
	int temp1, temp2, temp3;

	if (i < 1)
		return cost[i][j];
	
	if (cost[i][j] != -1)
		return cost[i][j];
	else
	{
		if (j == 0)
		{
			temp1 = sum(cost, rgb, i - 1, 1) + rgb[i][0];
			temp2 = sum(cost, rgb, i - 1, 2) + rgb[i][0];
			return cost[i][j] = min(temp1, temp2);
		}
		else if (j == 1)
		{
			temp1 = sum(cost, rgb, i - 1, 0) + rgb[i][1];
			temp2 = sum(cost, rgb, i - 1, 2) + rgb[i][1];
			return cost[i][j] = min(temp1, temp2);
		}
		else
		{
			temp1 = sum(cost, rgb, i - 1, 0) + rgb[i][2];
			temp2 = sum(cost, rgb, i - 1, 1) + rgb[i][2];
			return cost[i][j] = min(temp1, temp2);
		}
	}
}

int main(void)
{
	int n;
	int rgb[1000][3];
	int cost[1000][3];
	int i, j;
	int temp1, temp2, temp3;
	int min;

	//cost 초기화
	for (i = 0; i < 1000; i++)
		for (j = 0; j < 3; j++)
			cost[i][j] = -1;

	//input
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		for (j = 0; j < 3; j++)
			scanf("%d", &rgb[i][j]);

	//기저사례 초기화
	for (i = 0; i < 3; i++)
		cost[0][i] = rgb[0][i];

	//각각 최소값
	temp1 = sum(cost, rgb, n - 1, 0);
	temp2 = sum(cost, rgb, n - 1, 1);
	temp3 = sum(cost, rgb, n - 1, 2);

	if (temp1 <= temp2 && temp1 <= temp3)
		min = temp1;
	else if (temp2 <= temp1 && temp2 <= temp3)
		min = temp2;
	else min = temp3;
	
	printf("%d", min);
}