#include <stdio.h>

long long got(int n, long long (*data))
{
    if(data[n] != 0)
        return data[n];
    else
        return data[n] = got(n-1,data) + got(n-2,data) + got(n-3,data) + got(n-4,data);
}

int main (void)
{
    long long arr[68] = {1,1,2,4,0};
    int t;
    int target;
    scanf("%d",&t);

    while(t--)
    {
        scanf("%d",&target);
        printf("%lld\n",got(target, arr));
    }
}