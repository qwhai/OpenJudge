#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int fun(char *k)
{
	int i=0, len = 0;
	while(k[i++]!='\0'){len ++;}
	return len;
}

int main()
{
    char a[120];
	cin.getline(a,sizeof(a));
	cout<<fun(a)<<endl;
    return 0;
}
