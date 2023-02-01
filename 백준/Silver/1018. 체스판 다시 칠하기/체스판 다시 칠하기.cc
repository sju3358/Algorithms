/*문제
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 
어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 
지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 
구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 
따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. 
N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. 
B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <limits>
using namespace std;



vector<vector<bool> > resize (vector<vector<bool> > &orogin_vector , int row_start, int col_start)
{
    vector<vector<bool> > copied_vector;
    for(int row = row_start; row< row_start+8; row++){
        vector<bool> temp;
        for(int col=col_start; col < col_start+8; col++){
            temp.push_back(orogin_vector[row][col]);
        }
        copied_vector.push_back(temp);
    }
    return copied_vector;
}


int getMinOfWrongColor_WiteFix(vector< vector<bool> > &chess_array)
{
    int result = 0;
    if(chess_array[0][0] == true){
        chess_array[0][0] = false;
        result++;
    }
    for(int row = 0; row<8; row++){
        for(int col = 0; col<8; col++){
            
            bool flag1 = 0 < row && row < 8 && chess_array[row][col] == chess_array[row-1][col];
            bool flag2 = 0 < col && col < 8 && chess_array[row][col] == chess_array[row][col-1];
            if(flag1 || flag2){
                result++;
                chess_array[row][col] = !chess_array[row][col];
            }
        }
    }
    return result;
}

int getMinOfWrongColor_BlackFix(vector< vector<bool> > &chess_array)
{
    int result = 0;
    if(chess_array[0][0] == false){
        chess_array[0][0] = true;
        result++;
    }
    for(int row = 0; row<8; row++){
        for(int col = 0; col<8; col++){
            
            bool flag1 = 0 < row && row < 8 && chess_array[row][col] == chess_array[row-1][col];
            bool flag2 = 0 < col && col < 8 && chess_array[row][col] == chess_array[row][col-1];
            if(flag1 || flag2){
                result++;
                chess_array[row][col] = !chess_array[row][col];
            }
        }
    }
    return result;
}

int main(void)
{
    int row_size,col_size;
    int min = numeric_limits<int>::max();
    vector< vector<bool> > chess_arry;
    string input_color="";
    
    cin >> row_size;
    cin >> col_size;


    for(int row = 0; row<row_size; row++){
        vector<bool> temp;
        
        cin >> input_color;
        
        for (int col = 0; col<col_size; col++){
            string BorW =input_color.substr(col,1);
            
            if(!BorW.compare("B"))
                temp.push_back(true);
            else
                temp.push_back(false);
        }

        chess_arry.push_back(temp);
    }
    //데이터 인풋 테스트용
    // for(int row = 0; row<row_size; row++){
    //     for(int col=0; col<col_size; col++){
    //         cout<<chess_arry[row][col];
    //         cout<<" ";
    //     }
    //     cout<<endl;
    // }

    for(int row = 0; row < row_size-7; row++){
        for(int col=0; col < col_size-7; col++){
            
            vector<vector<bool> > resized_vector1 = resize(chess_arry, row, col);
            vector<vector<bool> > resized_vector2 = resize(chess_arry, row, col);
            
            int temp = getMinOfWrongColor_WiteFix(resized_vector1);
            int temp2 = getMinOfWrongColor_BlackFix(resized_vector2);

            min = min > temp ? temp : min;
            min = min > temp2 ? temp2 : min;
        
        }
    }
    cout << min;
}

