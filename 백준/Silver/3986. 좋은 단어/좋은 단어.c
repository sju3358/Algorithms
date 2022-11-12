#include <stdio.h>
int strlen(char * str)
{
    int i = 0;
    while(str[i] != 0)
        i++;
    return i;
}

char pop (char * stack, int * size)
{
    if(size == 0)
    {
        return NULL;
    }
    else
    {
        char temp = stack[(*size)-1];
        (*size)--;
        return temp;
    } 
}

void push (char * stack, int * size, char data)
{
    stack[(*size)] = data;
    (*size)++;
}

char top (char * stack, int * size)
{
    if(size == 0)
        return NULL;
    else
        return stack[(*size)-1];
}

int main (void)
{
    char input[100000];
    int T; 
    int input_len;

    int size = 0; //stack size

    int i = 0;
    int result = 0;
    char stack[100000];

    scanf("%d",&T);

    while(T--)
    {
        scanf("%s",input);

        input_len = strlen(input);

        while(input_len--)
        {
            if(input[i] == top(stack,&size) )
                pop(stack,&size);
            else
                push(stack,&size,input[i]);
            
            i++;
        }
        if(size == 0)
            result++;
        else
        {
            while(size != 0)
                pop(stack,&size);
        }
        i = 0;
        
    }
    printf("%d",result);

}