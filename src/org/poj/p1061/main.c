#include <stdio.h>
#include <math.h>
#define MaxL 2100000000
#define MaxXY 2000000000
#define MaxMN 2000000000

int main()
{
	int x, y, m, n, l;
	scanf ("%d %d %d %d %d", &x, &y, &m, &n, &l);
	int time = 0;
	int beginDis = y - x;
	int dis;
	for (dis = beginDis;;)
	{
		if (!dis) break;
		else
		{
			++time;
			x += m; x = (x + l) % l;
			y += n; y = (y + l) % l;
			dis = y - x;
		}
		if (dis == beginDis && time)
		{
			time = -1;
			break;// Ã¯ªÿ‘≠æ‡¿Î
		}
	}
	if (time != -1) printf("%d\n", time);
	else printf("Impossible\n");
	return 0;
}
