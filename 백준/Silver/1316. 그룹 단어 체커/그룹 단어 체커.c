#include <stdio.h>
#include <string.h>


void initializeingArray (char * arr, int size)
{
	int i;
	
	for(i=0; i<size; i++)
		arr[i] = 0;
}

int main (void)
{
	int testcase;
	int i,j;
	int word_length;
	int numOfGroupWord = 0;
	int curAlpha;
	int temp;
	char word[100];
	char isExist[26];
	
	
	scanf("%d",&testcase);
	
	for(i=0; i < testcase; i++)
	{
		
		scanf("%s",word);
		
		word_length = strlen(word); 
		initializeingArray(isExist, 26);
		
		
		for(j=0; j<word_length; j++)
		{
			if(isExist[ (word[j]-97) ] == 0 )
			{
				if(word[j] == word[j+1])
					continue;
				else
					isExist[ (word[j] - 97)] = 1;
			}
			else
				break;
		}
		
		
		if(j == word_length)
			numOfGroupWord++;
	}
	
	printf("%d",numOfGroupWord);
		
}

