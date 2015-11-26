#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int i, n, m, a[10000], ju=0;
	cin>>n>>m;
	for(i = 0;i < n;i ++)cin>>a[i];
	for(i = 0;i < n;i ++)
	{
		if(ju)cout<<' ';
		cout<<a[(i-m+n)%n];
		ju = 1;
	}
	cout<<endl;
    return 0;
}
