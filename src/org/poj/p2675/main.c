#include <stdio.h>
#include <string.h>
float price[10]={28.9f, 32.7f, 45.6f, 78.0f, 35.0f, 86.2f, 27.8f, 43.0f, 56.0f, 65.0f};
int num[11];

int main()
{
    int n, i;
	scanf("%d",&n);
	while(n --)
	{
		float sum=0;
		memset(num, 0, sizeof(num));
		for(i = 0;i < 10;i ++)
		{
			scanf("%d",&num[i]);
			sum += (num[i]*price[i]);
		}
		printf("%.2f\n", sum);
	}
    return 0;
}
