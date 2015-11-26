#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int fun(int n)
{
	if(n == 1)return 1;
	else return n * fun(n-1);
}

int main()
{
    int i, n, sum = 0;
	cin>>n;
	for(i = 1;i <= n;i ++)
	{
		sum += fun(i);
	}
	cout<<sum<<endl;
    return 0;
}
