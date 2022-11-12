#include <iostream>

#include <algorithm>

using namespace std;

 

int M, N, x, y;

 

//최대 공약수

int GCD(int a, int b)

{

        if (a % b == 0)

                 return b;

 

        return GCD(b, a % b);

}

 

//최소 공배수

int LCM(int a, int b)

{

        return (a * b) / GCD(a, b);

}

 

int main(void)

{

        ios_base::sync_with_stdio(0);

        cin.tie(0); //실행속도 향상

        int test_case;

        cin >> test_case;

 

        for (int t = 0; t < test_case; t++)

        {

                 cin >> M >> N >> x >> y;

                

                 int maxYear = LCM(M, N);

 

                 while (1)

                 {

                         //기저사례이거나(멸망년도 벗어남)

                         //x, y를 만족하는 년도 찾음

                         if (x > maxYear || (x - 1) % N + 1 == y)

                                 break;

 

                         x += M; //M으로 나눈 나머지가 X

                 }

 

                 if (x > maxYear)

                         cout << -1 << "\n";

                 else

                         cout << x << "\n";

        }

        return 0;

}