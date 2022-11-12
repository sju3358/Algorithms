#include <stdio.h>

long long min(int n)
{
    for(long long i = 1; ; i++)
    {
        long long l = (i*i) - i + 1;
        long long r = (i*i) + i;

        if(l <= n && n <= r)
        {
            if(n <= i*i)
                return i*2 - 1;
            else
                return i*2;
        }
    }
}


int main (void)
{
    int T,dist;
    scanf("%d",&T);

    while(T--)
    {
        int x,y;
        scanf("%d %d",&x,&y);
        dist = y-x;
        printf("%lld\n",min(dist));
    }
}