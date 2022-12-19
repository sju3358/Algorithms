#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    long temp = 0;
    for(int i = 0; i<n; i++)
        answer.push_back(temp = temp + x);
    return answer;
}