#include <stdio.h>

int strlen(char * str)
{
    int i = 0;
    int len = 0;
    while(str[i]  != 0)
    {
        i++;
        len++;
    }
    return len;
}





int main (void)
{
    char input[100000];

    int input_len;
    int i;

    int layer = 0,result = 0;
    int cnt = 0;

    scanf("%s",input);

    input_len = strlen(input);

    for(i=0; i<input_len; i++)
    {
        if(input[i] == '(')
        {
            layer++;
            cnt = 1;
        }
        else if(input[i] == ')')
        {
            if(cnt == 1)
            {
                layer--;
                result = result + layer;
            }
            else
            {
                result++;
                layer--;
            }
            cnt = 0;
        }
    }
    printf("%d",result);
}



