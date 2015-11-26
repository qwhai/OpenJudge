#include <stdio.h>
#include <string.h>
#define N 3
#define MaxLength 100

typedef struct node
{
	char a[MaxLength][10];
}Student;

int CalSorce(char a[])
{
	if (!strcmp(a, "right")) return 10;
	else if (!strcmp(a, "wrong")) return -10;
	else return 0;
}

int main()
{
	int n;
	scanf("%d", &n);
	int i;
	Student d[N];
	int sorce[N] = {0};
	for (i = 0; i < n; ++i)
	{
		scanf ("%s %s %s", d[0].a[i], d[1].a[i], d[2].a[i]);
	}
	int j;
	for (i = 0; i < N; ++i)
	{
		for (j = 0; j < n; ++j)
		{
			sorce[i] += CalSorce(d[i].a[j]);
		}
	}
	int temp[3] = {1,2,3};
	for (i = 0; i < N; ++i)
	{
		for (j = i + 1; j < N; ++j)
		{
			if (sorce[i] < sorce[j])
			{
				sorce[i] = sorce[i] + sorce[j];
				sorce[j] = sorce[i] - sorce[j];
				sorce[i] = sorce[i] - sorce[j];

				temp[i] = temp[i] + temp[j];
				temp[j] = temp[i] - temp[j];
				temp[i] = temp[i] - temp[j];
			}
			if (sorce[i] == sorce[j] && temp[i] > temp[j])
			{
				sorce[i] = sorce[i] + sorce[j];
				sorce[j] = sorce[i] - sorce[j];
				sorce[i] = sorce[i] - sorce[j];

				temp[i] = temp[i] + temp[j];
				temp[j] = temp[i] - temp[j];
				temp[i] = temp[i] - temp[j];
			}
		}
	}
	for (i = 0; i < N; ++i)
	{
		printf("(%d,%d)", temp[i], sorce[i]);
		if (sorce[i] != sorce[i+1]) printf("\n");
	}
	return 0;
}
