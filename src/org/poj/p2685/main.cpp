#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
    int n, a, b, c;
	for(n = 100;n < 999;n ++)
	{
		a = n / 100;
		b = (n / 10)%10;
		c = n % 10;
		if(a*a*a + b*b*b + c*c*c == n)cout<<n<<endl;
	}
    return 0;
}
