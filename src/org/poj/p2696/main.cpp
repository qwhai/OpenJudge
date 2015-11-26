#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int i, n, a, b;
	char ch[3];
	cin>>n;
	while(n --)
	{
		cin>>a;cin>>ch;cin>>b;
		if(strcmp(ch,"mul")==0)cout<<a*b<<endl;
		else if(strcmp(ch,"div")==0)cout<<a/b<<endl;
		else if(strcmp(ch,"add")==0)cout<<a+b<<endl;
		else if(strcmp(ch,"sub")==0)cout<<a-b<<endl;
		else if(strcmp(ch,"mod")==0)cout<<a%b<<endl;
	}
    return 0;
}
