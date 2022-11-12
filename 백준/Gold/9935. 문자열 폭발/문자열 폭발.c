#include <stdio.h>
#include <string.h>


int searchKeyIndex(char * key, char target)
{
	int i;
	for (i = 0; i < strlen(key); i++)
		if (key[i] == target)
			return i;
	return -1;
}


int main(void)
{
	char stack[1000000] = { 0, };
	char result[1000000] = { 0 , };

	char str[1000001];
	char key[37];
	int strlength, keylen;

	int stack_size = 0, result_size = 0;
	int i, k;

	int cur_key_pos = 0;

	scanf("%s", str);
	scanf("%s", key);

	keylen = strlen(key);
	strlength = strlen(str);
	for (i = 0; i < strlength; i++)
	{

		if (str[i] == key[cur_key_pos]) {
			stack[stack_size++] = str[i];
			cur_key_pos++;

			if (cur_key_pos == keylen)
			{
				stack_size = stack_size - keylen;

				if (stack_size == 0)
					cur_key_pos = 0;
				else
					cur_key_pos = searchKeyIndex(&key, stack[stack_size - 1]) + 1;
			}

		}
		else if (str[i] == key[0])
		{
			stack[stack_size++] = str[i];
			cur_key_pos = 1;

		}
		else if (str[i] != key[cur_key_pos])
		{
			if (stack_size != 0)
			{
				k = 0;
				while (k < stack_size)
				{
					result[result_size++] = stack[k];
					k++;
				}
				stack_size = 0;
				cur_key_pos = 0;
			}
			result[result_size++] = str[i];
		}
	}

	i = 0;
	while (i < stack_size)
		result[result_size++] = stack[i++];

	if (result_size == 0)
		printf("FRULA");
	else
		printf("%s\n", result);
}