#include <iostream>
#include <stdio.h>
#include <math.h>
using namespace std;

long double get_sigma(int* arr, int k, int start)
{
	int i;
	long double m = 0;
	long double v = 0;
	long double sigma;

	for (i = start; i < start + k; i++)
		m += arr[i];
	m = m / k;

	for (i = start; i < start + k; i++)
		v += (arr[i] - m) * (arr[i] - m);
	v = v / k;

	sigma = sqrtl(v);

	return sigma;
}

int main(void)
{
	int i, j, k, n, m;
	int arr[500];
	long double min = 9999999999;
	long double temp;

	scanf("%d", &n);
	scanf("%d", &m);
	for (i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}

	for (k = m; k <= n; k++)
	{
		for (i = 0; i < n - k + 1; i++)
		{
			temp = get_sigma(arr, k, i);
			if (temp < min)
				min = temp;
		}
	}
    cout << fixed; cout.precision(11);
    cout << min;

}