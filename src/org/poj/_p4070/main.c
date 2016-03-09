#include<stdio.h>

int main()
{
	int i, j, k, a[10]={0}, n, h;
	while(scanf("%d",&n)!=EOF)
	{
		// 结束
		if(n == 0)
		{
			break;
		}
		
		// 赋值数组
		for(i = 1; i <= n; i++)
		{
			a[i]=i;
		}
		printArray(a);
		
		for(;;){
			j=0;
			for(i=1;i<n;i++)
			{
				if(a[i]<a[i+1])
				{
					j++;
				}
			}
			if(j==0)
			{
				break;
			}
			for(i=n-1;i>0;i--)
			{
				if(a[i]<a[i+1])
				{
					break;
				}
			}
			j=a[i+1];
			for(h=i+1;h<=n;h++)
			{
				if(a[h]<=j&&a[h]>a[i])
				{
					j=a[h];
					k=h;
				}
			}
			h=a[i];a[i]=a[k];a[k]=h;
			int b[10]={0};j=0;k=i+1;
			for(;k<=n;k++)
			{
				b[j]=a[k];j++;
			}
			k=i+1;j--;
			for(;k<=n;k++)
			{
				a[k]=b[j];j--;
			}
			printArray(a);
		}
		cleanArray(a);
	}
	return 0;
}

void printArray(int a[])
{
	int i = 0;
	int len = sizeof(a);
	int f = 0;
	for(i = 0; i < len; i++)
	{
		if(a[i] == 0)
		{
			continue;
		}
		printf(f == 0 ? "" : " ");
		printf("%d", a[i]);
		f = 1;
	}
	printf("\n");
}

void cleanArray(int a[])
{
	int i = 0;
	int len = sizeof(a);
	for(i = 0; i < len; i++)
	{
		a[i] = 0;
	}
}
