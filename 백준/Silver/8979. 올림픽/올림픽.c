#include <stdio.h>

int arr[1001][3];

int main (void)
{
    int N,K;
    int i,j;
    int result = 1;

    scanf("%d",&N);
    scanf("%d",&K);

    for(i=0; i<N; i++)
    {
        scanf("%d",&j);
        scanf("%d",&arr[j][0]);
        scanf("%d",&arr[j][1]);
        scanf("%d",&arr[j][2]);
    }

    for(i=1; i<=N; i++)
    {
        if(arr[i][0] > arr[K][0])
            result++;
        else if(arr[i][0] == arr[K][0])
        {
            if(arr[i][1] > arr[K][1])
                result++;
            else if(arr[i][1] == arr[K][1])
            {
                if(arr[i][2] > arr[K][2])
                    result++;
            }
        }
    }
    printf("%d",result);

}
