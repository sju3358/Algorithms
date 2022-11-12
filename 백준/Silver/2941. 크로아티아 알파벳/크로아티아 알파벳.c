#include <stdio.h>
#include <string.h>


int main (void)
{
	int size;
	int i = 0;
	int result = 0;
	char string[100];
	
	
	scanf("%s",string);
	size = strlen(string);
	
	while( i<size )
	{
		if(string[i] == 'c')
		{
			if(string[i+1] == '-' || string[i+1] == '=')
			{
				i += 2;
				result++;
				continue;
			}
			else
			{
				i+=1;
				result++;
				continue;
			}
		}
		else if(string[i] == 'd')
		{
			if(string[i+1] == 'z' && string[i+2] == '=')
			{
				i += 3;
				result++;
				continue;
			}
			else if(string[i+1] == '-')
			{
				i += 2;
				result++;
				continue;
			}
			else
			{
				i+=1;
				result++;
				continue;
			}
		}
		else if(string[i] == 'l' || string[i] == 'n')
		{
			if(string[i+1] == 'j')
			{
				i += 2;
				result++;
				continue;
			}
			else
			{
				i+=1;
				result++;
				continue;
			}
		}
		else if(string[i] == 's' || string[i] == 'z')
		{
			if(string[i+1] == '=')
			{
				i += 2;
				result++;
				continue;
			}
			else
			{
				i+=1;
				result++;
				continue;
			}
		}
		else
		{
			i+=1;
			result++;
		}
	}
	
	printf("%d",result);
}