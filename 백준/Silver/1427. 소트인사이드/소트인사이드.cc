#include <iostream>
#include <stdio.h>
#include <algorithm>
using namespace std;

int main (void)
{
    int input[10];
    
    int n,i=0;
    int size = 0;
    scanf("%d",&n);

    while(n)
    {
        input[i] = n%10;
        n = n/10;
        size++;
        i++;
    }
    sort(input,input+size);

    for(int i = 0; i<size; i++)
        printf("%d",input[size-1 -i]);
}