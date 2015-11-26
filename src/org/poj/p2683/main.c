#include <stdio.h>

double fun(int n)
{
	int i;
	double a = 1.0, b = 2.0, c, sum = 0;
	for(i = 0;i < n;i ++)
	{
		sum += b/a;
		c = a + b;
		a = b;b = c;
	}
	return sum;
}

int main()
{
	int n;
	scanf("%d",&n);
	printf("%.4lf\n", fun(n));
    return 0;
}
