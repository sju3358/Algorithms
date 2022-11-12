#include <stdio.h>
#include <string.h>
using namespace std;

int main ()
{
    int x=0,y=0;
    int n,M;
    int flag = 2;
    int pos[4][2]; 
    char inst[5];
    char MOVE[5] = "MOVE";
    char TURN[5] = "TURN";
    int inst_val;

    //left
    pos[0][0] = -1; //...x
    pos[0][1] = 0;  //...y
    //up
    pos[1][0] = 0;  //...x
    pos[1][1] = 1;  //...y
    //right
    pos[2][0] = 1;  //...x
    pos[2][1] = 0;  //...y
    //down
    pos[3][0] = 0;  //...x
    pos[3][1] = -1; //...y
    

    scanf("%d",&M);
    scanf("%d",&n);

    for(int i = 0; i<n; i++)
    {
        scanf("%s ",inst);
        scanf("%d",&inst_val);

        
        
        if(!strcmp(inst,MOVE))
        {
            x = x+(pos[flag][0]*inst_val);
            y = y+(pos[flag][1]*inst_val);
        }
        else if(!strcmp(inst,TURN))
        {
            if(!inst_val){ 
                flag = (flag -1);
                flag += 4*(flag == -1);
            }
            else {
                flag = (flag + 1)%4;
            }
        }

            if(!((x>=0 && x<=M) && (y>=0 && y<=M)))
            {
                printf("-1");
                return 0;
            }
    }
    
    printf("%d %d",x,y);
}