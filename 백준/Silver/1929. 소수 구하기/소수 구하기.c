#include <stdio.h>

int isPrimeNumber(int n)
{
    int flag = 1;
    if(n == 1)
        return flag = 0;
    for(int i = 2; i*i<=n; i++)
    {
        if(n%i == 0)
        {
            flag = 0;
            break;
        }
    }
    return flag;
}

int main (void)
{
    int n,m;
    int result = 0;
    int cnt = 1;
    int min;

    scanf("%d",&n);
    scanf("%d",&m);
    for(int i = n; i<=m; i++)
        if(isPrimeNumber(i))
            printf("%d ",i);    
}