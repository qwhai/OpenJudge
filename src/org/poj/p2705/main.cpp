#include <iostream>
using namespace std;

int main()
{
	int i, j, n, m, c, t;

	cin >> n;
	for(i = 1; i <= n; i++)
	{
		c = 60;
		cin >> m;
		for(j = 1; j <= m; j++)
		{
			cin >> t;
			if(t < c)
				c = (t + 3 > c) ? t : (c - 3);
		}
		cout << c << endl;
	}
	return 0;
}
