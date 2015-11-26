#include <iostream>
using namespace std;

int f(int m, int n)
{
    if (n == 1 || m == 0)
        return 1;
    if (m < n)
        return f(m, m);
    return f(m, n-1) + f(m-n, n);
}

int main()
{
    int t, n, m;
    cin>>t;
    while (t--)
    {
        cin>>m>>n;
        cout<<f(m,n)<<endl;
    }
    return 0;
}
