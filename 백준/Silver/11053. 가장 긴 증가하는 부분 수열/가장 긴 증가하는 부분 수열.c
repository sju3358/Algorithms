#include <stdio.h>


int lis[1000] = {-1,};
int lis_size = 0;

int top()
{
    return lis[lis_size-1];
}


int lower_bound(int temp,int start, int end)
{
    int mid;
    
    while(start<end)
    {
        mid = (start + end) / 2;
        
        if(lis[mid] >= temp)
            end = mid;
        else
            start = mid+1;
    }

    return end;

}

int main (void)
{
    int N,i,temp;

    scanf("%d",&N);
    for(i=0; i<N; i++)
    {
        scanf("%d",&temp);
        if(top() < temp)
        {
            lis[lis_size] = temp;
            lis_size++;
        }
        else
        {
            lis[lower_bound(temp,0,lis_size-1)] = temp;
        }
        
    }
    printf("%d",lis_size);
}