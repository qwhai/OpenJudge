#include <stdio.h>

int main()
{
	int n;
	scanf ("%d", &n);
	int sum = 0;
	int age;
	int m = n;
	while (m--)
	{
		scanf("%d", &age);
		sum += age;
	}
	double ave = 1.0*sum / n;
	printf("%.2lf\n", ave);
	return 0;
}
