#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
using namespace std;

int main()
{
	int n;
	char sex[10];
	double a[10];
	cin>>n;

	while(n--)
	{
		int  nonormal=5;
		// ?車那?那y?Y
		cin>>sex;
		for(int i=0;i < 5;i ++)cin>>a[i];

		// ?D??那?﹞??迆???“﹞??∫
		if(a[0]>=4.0 && a[0]<=10.0)nonormal--;//1
		if(a[1]>=3.5 && a[1]<=5.5)nonormal--;//2
		if(a[2]>=110.0 && a[2]<=150.0 && strcmp(sex,"female") == 0)nonormal--;//3
		if(a[2]>=120.0 && a[2]<=160.0 && strcmp(sex,"male") == 0)nonormal--;//3
		if(a[3]>=36.0 && a[3]<=40.0 && strcmp(sex,"female") == 0)nonormal--;//4
		if(a[3]>=42.0 && a[3]<=48.0 && strcmp(sex,"male") == 0)nonormal--;//4
		if(a[4]>=100.0 && a[4]<=300.0)nonormal--;//5

		// output
		if(nonormal)cout<<nonormal<<endl;
		else cout<<"normal"<<endl;
	}
	return 0;
}
