#include <iostream>

using namespace std;
int main()
{
    int n,t; cin>>n;
    for(int i=1; i<=n; i++)
    {
        cin>>t;
        if(t==i)
        {
            cout<<"-1";
            return 0;
        }
    }
    cout <<"1000000007";
    return 0;
}