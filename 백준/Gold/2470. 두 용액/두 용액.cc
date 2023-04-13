#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


    int n; cin >> n;
    vector<long> liquids(n);

    for(int i = 0; i < n ; i++){
        long liquid; cin >> liquid;
        liquids[i] = liquid;
    }

    sort(liquids.begin(),liquids.end());

    int left = 0;
    int right = n-1;

    long minValue = liquids[left] + liquids[right];
    int minLeft = left;
    int minRight = right;
    while(left < right){

        long value = liquids[left] + liquids[right];

        if(abs(value) < abs(minValue)){
            minLeft = left;
            minRight = right;
            minValue = value;
        }

        if(value > 0)
            right--;
        else
            left++;
    }

    cout << liquids[minLeft] << " " << liquids[minRight];
}