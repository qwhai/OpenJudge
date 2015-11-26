#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int i, l, n, a[100];
	cin>>l;
	while(l--)
	{
		int ju = 0;
		cin>>n;
		memset(a, 0, sizeof(a));
		for(i = 0;i < n;i ++)cin>>a[i];
		if(a[0] != a[1])cout<<"0 ";
		for(i = 1;i < n - 1;i ++)
			if((a[i]>a[i-1] && a[i]>a[i+1]) || (a[i]<a[i-1] && a[i]<a[i+1]))
			{
				if(ju)cout<<' ';
				cout<<i;ju = 1;
			}
		if(a[n-2] != a[n-1])cout<<' '<<n-1;
		cout<<endl;
	}
    return 0;
}
