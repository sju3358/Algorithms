#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int index;

bool cmp(string a, string b){
	
	if(a[index] == b[index])
        return a < b;

    return a[index] < b[index];
    
}

vector<string> solution(vector<string> strings, int n) {
	index = n;
    sort(strings.begin(), strings.end(), cmp);
    return strings;
}