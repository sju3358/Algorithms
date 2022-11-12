#include <stdio.h>
#include <stdlib.h>


void push(char * stack, char data, int * size)
{
	if(data == 0)
		return;
	
	stack[*size] = data;
	
	(*size)++;
}

char pop(char * stack, int * size)
{
	char data;

	if(*size == 0)
		return 0;
	
	data = stack[ (*size) - 1 ];
	stack[ (*size) - 1 ] = 0;
	(*size)--;

	return data;
}

void print(char * stack)
{
	int i = 0;
	
	while(stack[i] != 0)
	{
		printf("%c",stack[i]);
		i++;
	}
}

int main (void)
{
	char stack1[1000000]={0,};
	char stack2[1000000]={0,};
	int stack1_size=0;
	int stack2_size=0;

	char data;
	int num;
	int i;

	scanf("%d",&num);
	getchar();

	while(num--)
	{
		while(1)
		{
			scanf("%c",&data);
			if(data == '\n')
				break;

			if(data == '<')
				push(stack2, pop(stack1,&stack1_size), &stack2_size);
			else if(data == '>')
				push(stack1, pop(stack2,&stack2_size), &stack1_size);
			else if(data == '-')
				pop(stack1, &stack1_size);
			else
				push(stack1,data,&stack1_size);
		}
		while(stack2_size != 0)
				push(stack1, pop(stack2,&stack2_size), &stack1_size);
		print(stack1);
		printf("\n");

		for(i = 0; i<stack1_size; i++)
			stack1[i] = 0;
		for(i = 0; i<stack2_size; i++)
			stack2[i] = 0;
		stack1_size=0;
		stack2_size=0;


	}

}