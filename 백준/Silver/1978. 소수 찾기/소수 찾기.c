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
    int cnt = 0;
    int n,input;

    scanf("%d",&n);
    for(int i =0; i<n; i++)
    {
        scanf("%d",&input);
        if(isPrimeNumber(input))
            cnt++;
    }
    printf("%d",cnt);
} 