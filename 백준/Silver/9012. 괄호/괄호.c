#include <stdio.h>
#include <string.h>

char _stack[52];
char _size;


void push(char * _stack, char data)
{
	_stack[_size++] = data;
}
char pop(char * _stack)
{
	_stack[_size--] = 0;
}
char top(char * _stack)
{
	if (_size == 0)
		return 0;
	return _stack[_size - 1];
}

int check(char * _stack, char * str)
{
	int i;
	int cnt = 0;
	
	if (str[0] == ')')
		return 0;


	for (i = 0; i < strlen(str); i++)
	{
		if (str[i] == ')')
		{
			if (top(_stack) == '(')
			{
				pop(_stack);
				continue;
			}
		}
		push(_stack, str[i]);
	}
	
	for (i = 0; i < 52; i++)
		_stack[i] = 0;
	
	
	if (_size == 0)
		return 1;
	else
		return 0;
}

int main()
{
	char str[52];
	int cnt;
	int boolean;

	scanf("%d", &cnt);

	while (cnt--)
	{
		scanf("%s", str);
		boolean = check(&_stack, str);

		if (boolean == 1)
			printf("YES\n");
		else
			printf("NO\n");
		_size = 0;
	}


}