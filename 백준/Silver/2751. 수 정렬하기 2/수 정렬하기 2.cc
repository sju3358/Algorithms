#include <iostream>
#include <algorithm>
#include <stdio.h>
using namespace std;

int arr[1000000];

int main (void)
{
    int n;
    scanf("%d",&n);
    for(int i = 0; i<n; i++)
        scanf("%d",&arr[i]);
    sort(arr,arr+n);
    for(int i = 0; i<n; i++)
        printf("%d\n",arr[i]);
}