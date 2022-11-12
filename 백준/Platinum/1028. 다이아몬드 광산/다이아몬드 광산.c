#include <stdio.h>

int left_cache[750][750] = { 0, };
int right_cache[750][750] = { 0, };

int R, C;
int isOutOfBounds(int r, int c) {
	return r < 0 || r >= R || c < 0 || c >= C;
}

int main(void)
{
	char arr[750][750];
	int i, j, k = 0;
	
	int max = 0;
	int temp_max = 0;


	scanf("%d", &R);
	scanf("%d", &C);

	for (i = 0; i < R; i++)
		for (j = 0; j < C; j++)
		{
			scanf("%1d", &arr[i][j]);
		}
	
	for (i = 0; i < R; i++)
		for (j = 0; j < C; j++)
		{
			if (arr[i][j] == 0)
				continue;
			for (k = 0; ; k++)
			{
				if (isOutOfBounds(i-k,j+k)|| isOutOfBounds(i+k,j+k))
					break;
				if (arr[i - k][j + k] == 1 && arr[i + k][j + k] == 1)
					left_cache[i][j]++;
				else
					break;
			}
		}

	for (i = 0; i < R; i++)
		for (j = 0; j < C; j++)
		{
			if (arr[i][j] == 0)
				continue;
			for (k = 0; ; k++)
			{
				if (isOutOfBounds(i-k,j-k)||isOutOfBounds(i+k,j-k))
					break;
				if (arr[i - k][j - k] == 1 && arr[i + k][j - k] == 1)
					right_cache[i][j]++;
				else
					break;
			}
		}

	for (i = 0; i < R; i++)
		for (j = 0; j < C; j++)
		{
			for (k = 1; k <= left_cache[i][j]; k++) {
				if (isOutOfBounds(i, j + (2 * k) - 2))
					break;
				if (left_cache[i][j] >= k && right_cache[i][j + (2 * k - 2)] >= k - 1)
					temp_max = k;			
			}

			if (temp_max > max)
				max = temp_max;
			temp_max = 0;
		}

	/*
	printf("\n");

	for (i = 0; i < R; i++) {
		for (j = 0; j < C; j++)
			printf("%d ", left_cache[i][j]);
		printf("\n");
	}

	printf("\n");

	for (i = 0; i < R; i++) {
		for (j = 0; j < C; j++)
			printf("%d ", right_cache[i][j]);
		printf("\n");
	}

	*/
	printf("%d", max);
}
