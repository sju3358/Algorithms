#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

typedef struct Node{
    int startTime;
    int workingTime;
};
struct compareWorkingTime{
    bool operator()(Node a, Node b){
        return a.workingTime > b.workingTime;
    }
};

bool compareStartTime(vector<int> a, vector<int> b){
    return a[0] < b[0];
}


int solution(vector<vector<int>> jobs) {
    int answer = 0;

    sort(jobs.begin(),jobs.end(),compareStartTime);

    priority_queue<Node, vector<Node>, compareWorkingTime> nextJob;

    int curTime = 0; int i = 0;
    while(i < jobs.size() || nextJob.empty() != true){
        if(i < jobs.size() && curTime >= jobs[i][0]){
            nextJob.push({jobs[i][0],jobs[i][1]});
            i++;
            continue;
        }
        if(nextJob.empty() != true) {
            curTime += nextJob.top().workingTime;
            answer += curTime - nextJob.top().startTime;
            nextJob.pop();
        }
        else
            curTime = jobs[i][0];
    }
    return answer / jobs.size();
}

int main (void){
    solution({{0, 3}, {1, 9}, {2, 6}});
}