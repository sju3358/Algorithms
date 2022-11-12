#include <stdio.h>

int main (void)
{
    int n;
    int result = 0;

    scanf("%d",&n);
    
    while(n)
    {
        result = result + n%2;
        n = n/2;
    }
    if(result == 0)
        printf("1");
    else
        printf("%d",result);
}
