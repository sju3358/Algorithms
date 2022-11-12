#include <stdio.h>
#include <string.h>
 
int Gen(int a);
int Plus(int a);
 
void main()
{
    int start=1,end=10000;
    int num;
    int result=0;
 
 
    for(num=start; num<=end; num++)
        if(Gen(num)==1)
           printf("%d\n",num);
 
    
}
 
int Gen(int num)
{
    int i;
     
    for(i=1; i<=num; i++)
        if(Plus(i)==num)
            return 0;
     
    return 1;
 
}
int Plus(int i)
{
    int temp;
    int result;
 
    temp=i; result=i;
     
    while(temp != 0)
    {
        result=result+temp%10;
        temp=temp/10;
    }
     
    return result;
}