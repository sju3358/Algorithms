#include <stdio.h>

int stack[100000];
int size = 0;
int pop(void)
{
   int temp = stack[size-1];
    size--;
    return temp;
}
void push(int n)
{
    stack[size++] = n;   
}

int main (void)
{
    int n,temp,result = 0;
    scanf("%d",&n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d",&temp);
        if(temp)
            push(temp);
        else
        {
            pop();
        }
    }
    


    while(size){ result += pop(); }
    
    printf("%d",result);

}