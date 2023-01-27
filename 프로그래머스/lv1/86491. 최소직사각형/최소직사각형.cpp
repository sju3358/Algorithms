#include <string>
#include <vector>
#include <algorithm>
#include <iostream>


using namespace std;

int solution(vector<vector<int>> sizes) {
    
    int result_small = -1;
    int result_large = -1;
    
    for(int i = 0; i <sizes.size(); i++){
        
        int small = min(sizes[i][0], sizes[i][1]);
        int large = max(sizes[i][0], sizes[i][1]);
        
        if(result_small < small)
            result_small = small;
        
        if(result_large < large)
            result_large = large;
        
    }
    
    return result_small * result_large;
    
    
}