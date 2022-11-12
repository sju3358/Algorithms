#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    long long map[501][501];

    
    map[0][0] = triangle[0][0];
    for(int i = 1; i<triangle.size(); i++)
        for(int j = 0; j<triangle[i].size();j++)
        {
            long long left,right;

            if(i-1 >= 0 && j-1 >= 0)
                left = map[i-1][j-1];
            else 
                left = 0;

            if(i-1 >= 0)
                right = map[i-1][j];
            else
                right = 0;

            map[i][j] = triangle[i][j] + (left > right ? left : right);
        }

        int level = triangle.size() - 1;
        int max = -1;
    
        for(int i = 0; i < triangle[level].size();i++)
            if(max < map[level][i])
                max = map[level][i];
    return max;
}