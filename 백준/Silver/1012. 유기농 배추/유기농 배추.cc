#include <algorithm>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
#include <string>
#include <string.h>

using namespace std;

int map[50][50];
int visit[50][50];
int T;
int n,m,k;

void dfs(int x, int y)
{
    int dx[4] = {0,0,1,-1};
    int dy[4] = {1,-1,0,0};
    visit[x][y] = 1;

    for(int i = 0; i<4; i++)
    {
        int nx = x+dx[i];
        int ny = y+dy[i];

        if( (0 <= nx && nx <n) && (0<= ny && ny <m))
            if(map[nx][ny] ==1 && visit[nx][ny] == 0)
                dfs(nx,ny);
    }
}


int main (void)
{
    int cnt = 0;
    scanf("%d",&T);

    while(T--)
    {
        scanf("%d",&n);
        scanf("%d",&m);
        scanf("%d",&k);

        memset(map,0,sizeof(map));
        memset(visit,0,sizeof(visit));

        for(int i = 0 ; i<k; i++)
            {
                int x, y;
                scanf("%d %d",&x,&y);
                map[x][y] = 1;
            }

        for(int i = 0; i<n; i++)
            for(int j=0; j<m; j++)
                if(map[i][j] == 1 && visit[i][j] == 0)
                {
                    cnt++;
                    dfs(i,j);
                }
        printf("%d\n",cnt);
        cnt = 0;
    }  
}