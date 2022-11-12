#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char str[1000];
char stack[1000];
int size = 0;

void push(char data)
{
    stack[size++] = data;
}

char pop()
{
    return stack[--size];
}


char top()
{
    return stack[size-1];
}

int main (void)
{
    int i;
    while(1)
    {
        gets(str);
        if(str[0] == '.')
            break;
        else
        {
            for(int i = 0; i<strlen(str); i++)
            {
                if(str[i] == '(' || str[i] == '[') 
                    push(str[i]);
                else if(str[i] == ')' )
                {
                    if(top() == '(' )
                        pop();
                    else
                         push(str[i]);
                }
                else if(str[i] == ']' )
                {
                    if(top() == '[' )
                        pop();
                    else    
                       push(str[i]);
                }
            }
        }
        if(size)
            printf("no\n");
        else
            printf("yes\n");
        size = 0;
    }
}