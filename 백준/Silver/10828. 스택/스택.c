#include <stdio.h>
#include <string.h>
 
typedef struct __ARRAY_LIST__
{
    int arr[10000];
    int numOfData;
    int curPosition;
}ArrayList;
 
typedef ArrayList List;
 
void ListInit(List * plist)
{
    (plist->numOfData) = 0;
    (plist->curPosition) = -1;
}
int LInsert(List * plist, int data)
{
    if(plist->numOfData >= 10000)
        return 0;
 
    (plist->arr[plist->numOfData] = data);
    (plist->numOfData)++;
 
    return 1;
}
int LCount(List * plist)
{
    return plist->numOfData;
}
 
int push (List * stack, int data)
{
    int cnt = LInsert(stack,data);
 
    if(cnt == 0)
        return 0;
    else
        return 1;
}
 
int pop(List * stack)
{
    int temp = stack->arr[stack->numOfData-1];
    if(LCount(stack) == 0)
        return -1;
    stack->arr[stack->numOfData-1] = 0;
    (stack->numOfData)--;
    return temp;
}
 
int size(List * stack)
{
    return LCount(stack);
}
int empty(List * stack)
{
    if(LCount(stack) == 0)
        return 1;
    else
        return 0;
}
 
int top(List * stack)
{
    if(LCount(stack) == 0)
        return -1;
    else
        return stack->arr[stack->numOfData-1];
}
 
int main (void)
{
    List stack;
    int i,n,data;
    char str[100];
 
    ListInit(&stack);
 
    scanf("%d",&n);
 
    for(i=0;i<n; i++)
    {
        scanf("%s",str);
 
        if( !strcmp(str,"push") )
        {
            scanf("%d",&data);
            push(&stack,data);
        }
        else if(!strcmp(str,"pop"))
            printf("%d\n",pop(&stack));
        else if(!strcmp(str,"size"))
            printf("%d\n",size(&stack));
        else if(!strcmp(str,"empty"))
            printf("%d\n",empty(&stack));
        else if(!strcmp(str,"top"))
            printf("%d\n",top(&stack));
    }
}