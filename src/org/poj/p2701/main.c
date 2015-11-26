#include <stdio.h>
#define N 7

/* ÅĞ±ğÎŞ¹Ø */
int judget(int x)
{
	int temp;
	int a, b, c;
	a = x / 100;
	b = (x / 10) % 10;
	c = x % 10;
	if ((x%N) && (a!=N) && (b!=N) && (c!=N)) return 1;
	else return 0;
}

int main()
{
	int n;
	int i;
	int sum;
	scanf("%d", &n);
	for (i = 1, sum = 0; i <= n; ++i)
	{
		if (judget(i))
		{
			sum += (i * i);
		}
	}
	printf("%d\n", sum);
	return 0;
}
