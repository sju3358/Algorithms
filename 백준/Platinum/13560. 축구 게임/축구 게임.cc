#include <stdio.h>
#include <algorithm>
using namespace std;

int score[10000];
int sum_score[10000];

int main (void)
{
    int n;
    scanf("%d",&n);

    for(int i = 0; i<n; i++)
        scanf("%d",&score[i]);

    sort(score, score+n);

    sum_score[0] = score[0];
    for(int i = 1; i<n; i++)
        sum_score[i] = sum_score[i-1] + score[i];
    
 
    

    if(sum_score[n-1] != n*(n-1)/2)
    {
        printf("-1");
        return 0;
    }

    for(int i = 1; i<n; i++)
        if(sum_score[i] < (i*(i+1)/2))
        {
            printf("-1");
            return 0;
        }
    printf("1");
}