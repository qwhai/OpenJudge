#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int i, n;
	cin>>n;
	while(n--)
	{
		char s1[50], s2, s3;
		cin>>s1;cin>>s2>>s3;
		for(i = 0;i < strlen(s1);i ++)
		{
			if(s1[i]==s2)s1[i]=s3;
		}
		cout<<s1<<endl;
	}
    return 0;
}
