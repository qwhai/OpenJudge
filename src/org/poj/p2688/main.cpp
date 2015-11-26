#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int j, a = 0, e = 0, i = 0, o = 0, u = 0;
	char s[90];
	cin.getline(s,sizeof(s));
	for(j = 0;j < strlen(s);j ++)
	{
		if(s[j] == 'a')a++;
		else if(s[j] == 'e')e++;
		else if(s[j] == 'i')i++;
		else if(s[j] == 'o')o++;
		else if(s[j] == 'u')u++;
	}
	cout<<a<<' '<<e<<' '<<i<<' '<<o<<' '<<u<<endl;
    return 0;
}
