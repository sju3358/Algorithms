#include <iostream>
#include <queue>
#include <vector>

using namespace std;

bool isInBound(int x, int y, int m, int n)
{
    if (x < 0 || y < 0 || x >= m || y >= n)
        return false;
    else
        return true;
}

void printVector(vector<vector<int>>& vector)
{
    for (int i = 0; i < vector.size(); i++)
    {
        for (int j = 0; j < vector[0].size(); j++)
        {
            cout.width(3);
            cout << vector[i][j];
        }
        cout << endl;
    }
    cout << endl;
}

int main(void)
{

    //변수선언 및 초기화
    int n, m;
    int days = 0;
    int totalTomatoCount = 0;
    int totalRipeTomatos = 0;
    int nextX[] = { 0,1,-1,0 };
    int nextY[] = { 1,0,0,-1 };
    int flag = false;

    queue<int> x;
    queue<int> y;

    cin >> m;
    cin >> n;

    vector<vector<int>> tomatoMap(n, vector<int>(m, 0));
    vector<vector<bool>> isVisited(n, vector<bool>(m, false));




    // input
    // 이미 익은 토마토의 경우, queue에 삽입
    // -1은 토마토가 있지 않는 위치이므로 isvisited를 true로 초기화.
    for (int i = 0; i < tomatoMap.size(); i++) {
        for (int j = 0; j < tomatoMap[0].size(); j++)
        {
            cin >> tomatoMap[i][j];
            if (tomatoMap[i][j] == 1)
            {
                x.push(i);
                y.push(j);
                totalRipeTomatos++;
            }
            else if (tomatoMap[i][j] == -1)
            {
                isVisited[i][j] = true;
                totalTomatoCount--;
            }

            totalTomatoCount++;
        }
    }

    while (!(x.empty() && y.empty()))
    {
        int numOfQueue = x.size();
        flag = false;
        while (numOfQueue--)
        {
            int next_x = x.front();
            int next_y = y.front();
            x.pop();
            y.pop();

            for (int i = 0; i < 4; i++)
            {
                int temp_x = next_x + nextX[i];
                int temp_y = next_y + nextY[i];

                if (isInBound(temp_x, temp_y, tomatoMap.size(), tomatoMap[0].size()))
                    if (isVisited[temp_x][temp_y] == false && tomatoMap[temp_x][temp_y] == 0)
                    {
                        flag = true;
                        isVisited[temp_x][temp_y] = true;
                        tomatoMap[temp_x][temp_y] = 1;
                        x.push(temp_x);
                        y.push(temp_y);
                        totalRipeTomatos++;
                    }
            }

        }
        if(flag == true)
        days++;
        //cout << days<<endl;
        //printVector(tomatoMap);
        
    }
    if (totalRipeTomatos == totalTomatoCount)
        cout << days;
    else
        cout << -1;
}