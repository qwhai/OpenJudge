#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int i, n;
	cin>>n;
	for(i = 10;i <= n;i ++)
	{
		int a, b;
		a = i / 10;b = i % 10;
		if(!(i%(a+b)))cout<<i<<endl;
	}
    return 0;
}
