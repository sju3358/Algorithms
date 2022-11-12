#include <stdio.h>

int fibo0(int n, int (*matrix)[2])
{
	if(matrix[n][0] == -1)
	{	
		if(n != 0 && n != 1)
			matrix[n][0] = fibo0(n-1, matrix) + fibo0(n-2, matrix);
		else
		{
			if(n == 0)
			{
				matrix[0][0] = 1;
				return 1;
			}
			else if(n ==1)
			{
				matrix[1][0] = 0;
				return 0;
			}
		}
	}
	
	return matrix[n][0];
}

int fibo1(int n, int (*matrix)[2])
{
	if(matrix[n][1] == -1)
	{
		if(n != 0 && n != 1)
			matrix[n][1] = fibo1(n-1, matrix) + fibo1(n-2, matrix);
		else
		{
			if(n == 0)
			{
				matrix[0][0] = 0;
				return 0;
			}
			else if(n ==1)
			{
				matrix[1][0] = 1;
				return 1;
			}
		}
	}
		
	
	return matrix[n][1];
}

void fibo(int n, int (*matrix)[2], int * result)
{
	result[0] = fibo0(n, matrix);
	result[1] = fibo1(n, matrix);
}


int main(void)
{
	int matrix[41][2];
	int result[2];
	int n;
	
	int i,j;
	int T;
	
	scanf("%d",&T);
	
	for(j= 0; j< T; j++)
	{
	
		for(i=0; i<41; i++)
		{
			matrix[i][0] = -1;
			matrix[i][1] = -1;
		}
		scanf("%d",&n);
		fibo(n, matrix, result);
		printf("%d %d\n",result[0], result[1]);
	}
}
