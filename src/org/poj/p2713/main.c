#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int main()
{
	int n,i,j;
	int t,m,x,y,N;
	int ca[50][50];
	scanf("%d",&n);
	for(i = 0;i < n;i ++)
		for(j = 0;j < n;j ++)
			scanf("%d",&ca[i][j]);

	for(i = 0;i < n;i ++)
		for(j = 0;j < n;j ++)
			if(!ca[i][j]){t=i;m=j;break;}

	for(i = n - 1;i >= 0;i --)
		for(j = n - 1;j >= 0;j --)
			if(!ca[i][j]){x=i;y=j;break;}

	N = (y - m - 1)*(t - x - 1);
	printf("%d\n",N);
	return 0;
}
