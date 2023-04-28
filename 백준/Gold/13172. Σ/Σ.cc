#include <iostream>
#include <algorithm>


typedef long long int64;
using namespace std;

int64 getGCD(int64 x,int64 y){

    int64 a = min(x,y);
    int64 b = max(x,y);

    int64 r = a%b;
    while(r > 0){
        a = b;
        b = r;
        r = a%b;
    }

    return b;
}

int64 solution(int64 x, int64 y){

    int64 answer = 1;

    int64 curPow = 1;
    int64 curValue = x;

    while(y > 0){
        if(y - curPow >= curPow*2){
            curPow = curPow*2;
            curValue = curValue*curValue;
            curValue = curValue % 1000000007;
        }
        else{
            y = y - curPow;
            answer *= curValue;
            answer %= 1000000007;
            
            curPow = 1;
            curValue = x;
        }
    }

    return answer;
}

int main(){

    int64 N; cin >> N;

    int64 answer = 0;

    for(int64 i = 0; i < N; i++){
        int64 numerator, denominator; cin >> denominator >> numerator;
        int64 gcd = getGCD(numerator,denominator);

        //기약분수
        numerator = numerator/gcd;
        denominator = denominator/gcd;

        //b^x-2 구하기
        int64 exp = numerator * solution(denominator,1000000005) % 1000000007;

        answer += exp;
        answer %= 1000000007;
    }

    cout << answer;
}