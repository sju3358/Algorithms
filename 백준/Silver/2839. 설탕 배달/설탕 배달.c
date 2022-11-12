    #include <stdio.h>



    int main (void)
    {
        int n;
        int i,j;

        int kg_5;
        int kg_3 = 0;

        
        scanf("%d",&n);

        kg_5 = n/5;
        kg_3 = (n-kg_5*5)/3;
        
        while(1)
        {
            if(kg_5*5 + kg_3*3 == n)
            {
                printf("%d",kg_3+kg_5);
                break;
            }
            else
            {
                kg_5--;
                kg_3 = (n-kg_5*5) / 3;


                if(kg_5 == -1)
                {
                    printf("-1");
                    break;
                }
            }
            
        }
    }
