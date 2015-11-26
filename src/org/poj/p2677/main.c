#include <stdio.h>

int main()
{
    int i,j,n;
    int o = 0,l = 0;
    int a[100][100];
    scanf("%d",&n);
    for(i = 0;i < n;i ++)
    for(j = 0;j < n;j ++)
        scanf("%d",&a[i][j]);
    for(i = 0;i < n;i ++)
    for(j = 0;j < n;j ++)
    {
        if(a[i][j] <= 50)
        {
            o ++;
            if(!((a[i-1][j]<=50)&&(a[i+1][j]<=50)&&(a[i][j-1]<=50)&&(a[i][j+1]<=50)) || i == 0 || j == 0 || i == n-1 || j == n-1)
                l ++;
        }
    }
    printf("%d %d\n",o,l);
    return 0;
}