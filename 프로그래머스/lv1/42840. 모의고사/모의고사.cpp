#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <string>
#include <stack>
using namespace std;


void resizeVector ( vector<int> &student){
    int sizeOfVector = student.size();

    int idx = 0;
    while(student.size() < 10000){
        student.push_back(student[idx++]);
        if(idx % sizeOfVector == 0)
            idx = 0;
    }
}

vector<int> solution(vector<int> answers){
    vector<int> answer;

    //반복패턴
    vector<int> student1 = {1,2,3,4,5};
    vector<int> student2 = {2,1,2,3,2,4,2,5};
    vector<int> student3 = {3,3,1,1,2,2,4,4,5,5};

    //반복패턴으로 10000사이즈까지 복사
    resizeVector(student1);
    resizeVector(student2);
    resizeVector(student3);

    vector<int> sum = {0,0,0};

    //정답이랑 비교
    for(int i = 0; i < answers.size(); i++){
        if(student1[i] == answers[i])
            sum[0]++;
        if(student2[i] == answers[i])
            sum[1]++;
        if(student3[i] == answers[i])
            sum[2]++;
    }


    //최대값 찾기
    int max = -1;

    for(int i = 0; i < 3; i++)
        if(sum[i] > max)
            max = sum[i];

    for(int i = 0; i < 3; i++)
        if(sum[i] == max)
            answer.push_back(i+1);

    return answer;
}


// int main(){
//     for(int sum : solution({1,2,3,4,5}))
//         cout << sum;

//     cout << endl;

//     for(int sum : solution({1,3,2,4,2}))
//         cout << sum;
// }
