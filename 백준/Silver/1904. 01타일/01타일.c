#include <stdio.h>

int seq[1000001];

int dp(int n)
{
    if(seq[n] != 0)
        return seq[n];  
    else
    {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else
            return seq[n] = (dp(n-2) + dp(n-1)) % 15746;    
    }   
}


int main (void)
{
    int n;
    scanf("%d",&n);
    printf("%d",dp(n));
}