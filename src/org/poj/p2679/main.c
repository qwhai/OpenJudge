#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int fun(int k)
{
	int i, sum = 0;
	for(i = 1;i <= k;i ++)
	{
		sum += i*i*i;
	}
	return sum;
}

int main()
{
    int k;
	cin>>k;
	cout<<fun(k)<<endl;
    return 0;
}
