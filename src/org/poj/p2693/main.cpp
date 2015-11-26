#include <iostream>
#include <cstring>
#include <cctype>
#include <cstdlib>
#include <cmath>
#include <stdio.h>
using namespace std;

double distants(double x1,double y1,double x2,double y2)
{
	return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}

int main()
{
	int i, j, n;
	double x[10000], y[10000], dis, max=0;
	cin>>n;
	for(i = 0;i < n;i ++)cin>>x[i]>>y[i];
	for(i = 0;i < n;i ++)
	{
		for(j = i + 1;j < n;j ++)
		{
			//cout<<"j:"<<j<<'-';
			dis = distants(x[i],y[i],x[j],y[j]);
			//cout<<"dis:"<<dis<<endl;
			if(max<=dis)max = dis;
		}
	}
	printf("%.4f\n", max);
    return 0;
}
