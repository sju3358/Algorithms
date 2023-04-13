#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long getAbs(long a){
    if(a < 0)
        return a * -1;
    return a;
}

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

    int minLeft = 0;
    int minMid = 1;
    int minRight = n-1;
    long minValue = liquids[0] + liquids[1] + liquids[n-1];

    for(int mid = 1; mid < n-1; mid++) {
        int left = 0;
        int right = n - 1;

        while (left < mid && mid < right) {

            long value = liquids[left] + liquids[mid] + liquids[right];

            if (getAbs(value) < getAbs(minValue)) {
                minLeft = left;
                minMid = mid;
                minRight = right;
                minValue = value;
            }


            if (value > 0 && mid < right-1)
                right--;
            else
                left++;
        }
    }

    cout << liquids[minLeft] << " " << liquids[minMid] << " " << liquids[minRight];
}