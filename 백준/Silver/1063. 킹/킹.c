#include <stdio.h>
#include <string.h>

void to_where_check(int * to_where, char * data)
{
    int i;
    for( i= 0 ; i<2; i++)
    {
        if(data[i] == 'R')
            to_where[1] = 1;
        else if(data[i] == 'L')
            to_where[1] = -1;
        else if(data[i] == 'T')
            to_where[0] = 1;
        else if(data[i] == 'B')
            to_where[0] = -1;
    }
}


int main (void)
{
    int king_i, king_j;
    int stone_i, stone_j;
    int to_where[2] = {0, };
    char input[3];

    int count;

    scanf("%s",input);
    king_j = input[0] - 'A'  + 1;
    king_i = input[1] - '0';

    scanf("%s",input);
    stone_j = input[0] - 'A' + 1;
    stone_i = input[1] - '0';

    scanf("%d",&count);

    while(count--)
    {
        scanf("%s",input);
        to_where_check(to_where, input);
        if( (king_i + to_where[0]) == stone_i && (king_j + to_where[1]) == stone_j)
        {
            if(1 <= stone_i + to_where[0] && stone_i + to_where[0] <= 8 && 1 <= stone_j + to_where[1] && stone_j + to_where[1] <= 8) 
            {
                king_i += to_where[0];
                king_j += to_where[1];
                stone_i += to_where[0];
                stone_j += to_where[1];
            }
        }
        else
        {
            if(1 <= king_i + to_where[0] && king_i + to_where[0] <= 8 && 1 <= king_j + to_where[1] && king_j + to_where[1] <= 8)
            {
                king_i += to_where[0];
                king_j += to_where[1];
            }
        }

        to_where[0] = 0;
        to_where[1] = 0;
    }

    printf("%c%c\n",king_j + 'A' - 1, king_i + '0');
    printf("%c%c\n",stone_j + 'A' - 1, stone_i + '0');
}

