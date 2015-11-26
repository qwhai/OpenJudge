#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int i, n, a[110], b=0;
	cin>>n;
	for(i = 0;i < n;i ++)cin>>a[i];
	cout<<a[n-1]<<' ';
	for(i = n-2;i >=0;i --){if(b)cout<<' ';cout<<a[i];b=1;}
	cout<<endl;
    return 0;
}
