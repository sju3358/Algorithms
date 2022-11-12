#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

int arr[500][500] = { 0, };
int table[500][500];
int n;
int sort(int* arr)
{
	for(int i=0; i<4; i++)
		for (int j = i; j < 4; j++)
			if (arr[i] < arr[j])
			{
				int temp = arr[j];
				arr[i] = arr[j];
				arr[j] = arr[i];
			}
	return arr[0];
}

int func(int i, int j)
{
	int result = 0;
	int cost[4] = { -1 ,-1 ,-1 ,-1 };

	if (table[i][j] != -1)
		return table[i][j];
	else
	{
		if(i-1 >= 0 && arr[i][j] < arr[i-1][j])
			cost[0] = func(i-1, j); //up_cost
		if(i+1 < n && arr[i][j] < arr[i+1][j])
			cost[1] = func(i+1, j); //down_cost
		if(j-1 >= 0 && arr[i][j] < arr[i][j-1])
			cost[2] = func(i, j-1); //left_cost
		if(j+1 < n && arr[i][j] < arr[i][j+1])
			cost[3] = func(i, j + 1); //right_cost
		 return table[i][j] = sort(cost) + 1;
	}

}



int main(void)
{
	int max = -1;
	
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			table[i][j] = -1;

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &arr[i][j]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		{
			int temp = func(i, j)+1;
			if (temp >= max)
				max = temp;
		}

	printf("%d", max);
}