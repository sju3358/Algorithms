#include <stdio.h>

int main (void)
{
    int coin[10];
    int n,k,i,cnt=0;;

    scanf("%d",&n);
    scanf("%d",&k);
    for(i=0; i<n; i++)
    {
        scanf("%d",&coin[i]);
    }

    i=n-1;
    while(k)
    {
        if(coin[i] > k)
            i--;
        else
        {
            k = k-coin[i];
            cnt++;
        }
    }
    printf("%d",cnt);
}