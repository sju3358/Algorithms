#include <iostream>

using namespace std;

int main (void)
{
    int h,m,t;
    cin >> h;
    cin >> m;
    cin >> t;
    
    h += t/60;
    m += t%60;
    if(m >= 60)
    {
        h++;
        m -= 60;
    }
    h = h%24;
    
    cout << h << ' '<< m;
}