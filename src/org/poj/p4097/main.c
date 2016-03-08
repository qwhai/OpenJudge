#include<stdio.h>
#include<string.h>
int main()
{
    int n,i,p,q;
    char a[105][105],x[105],y[105];
    scanf("%d",&n);
    for(i=0;i<n;i++)
        scanf("%s",a[i]);
    scanf("%d",&n);
    while(n--)
    {
        scanf("%s%s",x,y);
        for(p=0;;p++)
        if(!strcmp(x,a[p]))
            break;
        for(q=0;;q++)
            if(!strcmp(y,a[q]))
                break;
        if(p>q)
            for(i=p;i>q;i--)
                printf("%s ",a[i]);
        else if(p<q)
            for(i=p;i<q;i++)
                printf("%s ",a[i]);
        puts(y);
    }
    return 0;
}
