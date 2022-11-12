#include <stdio.h>

int cache[1500000] = { 0,1 };
long long mod = 1000000;
long long period = 1500000;
long long input;

int fibo(int n)
{
	if (n < 2)
		return cache[n];

	if (cache[n] != 0)
		return cache[n];
	else
		return cache[n] = (fibo(n - 1) + fibo(n - 2))%mod;
}

int main(void)
{
	scanf("%lld", &input);
	printf("%lld", fibo(input % period) % mod);
}
