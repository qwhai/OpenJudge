#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	char s[100];
	cin.getline(s,sizeof(s));
	s[0] = toupper(s[0]);
	for(int i = 1;i < strlen(s);i ++)
	{
		if(s[i-1]==' ' || s[i-1]=='\t' || s[i-1]=='\r' || s[i-1]=='\n')s[i] = toupper(s[i]);
	}
	cout<<s<<endl;
    return 0;
}
