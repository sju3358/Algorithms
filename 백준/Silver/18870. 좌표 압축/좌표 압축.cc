#include <iostream>
#include <unordered_set>
#include <algorithm>
#include <vector>
using namespace std;

int main(void) {
    
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    unordered_set<int> unOrderedSet;
    vector<int> orderedArr;
    vector<int> unOrderedArr;
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;

        unOrderedArr.push_back(num);

        auto iter = unOrderedSet.find(num);
        if (iter == unOrderedSet.end()) {
            orderedArr.push_back(num);
            unOrderedSet.insert(num);
        }
    }

    sort(orderedArr.begin(), orderedArr.end());

    for (int i = 0; i < n; i++) {
        cout << lower_bound(orderedArr.begin(),orderedArr.end(),unOrderedArr[i]) - orderedArr.begin() << " ";
    }
}