#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	char s[100];
	cin.getline(s,sizeof(s));
	for(int i = 0;i < strlen(s);i ++)
	{
		if(isalpha(s[i]))
		{
			if(s[i]<='z' && s[i]>='a')s[i] = toupper(s[i]);
			else s[i] = tolower(s[i]);
		}
	}
	cout<<s<<endl;
    return 0;
}
