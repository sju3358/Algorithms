#include <algorithm>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <string>
#include <string.h>

using namespace std;

int map[1000][1000];
int visit[1000][1000];
int n,m;
bool flag = false;

void dfs(int i, int j)
{   
    if((i == m-1) && map[i][j] == 0)
    {
        flag = true;
        return;
    }

    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    visit[i][j] = 1;

    for(int k = 0; k<4; k++)
    {
        int ni = i+dx[k];
        int nj = j+dy[k];
        if( (0 <= ni && ni <m) && (0<= nj && nj <n))
        {
            if((map[ni][nj] ==0) && (visit[ni][nj] == 0)) 
            {
                dfs(ni,nj);
            }
        }
    }
}


int main (void)
{
    int cnt = 0;
    scanf("%d",&m);
    scanf("%d",&n);
    

    memset(map,0,sizeof(map));
    memset(visit,0,sizeof(visit));

    for(int i = 0; i<m; i++)
        for(int j=0; j<n; j++)
        {
            int temp;
            scanf("%1d",&temp);
            map[i][j] = temp;
        }

    for(int i = 0; i<n; i++)
            if(map[0][i] == 0 && visit[0][i] == 0)
                dfs(0,i);

    if(flag)
        printf("YES");
    else
        printf("NO");
}  
