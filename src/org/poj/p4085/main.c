#include <stdio.h>
#include <stdlib.h>
#define LENGTH 10000

int main()
{
    int length = LENGTH + 1;
    int n = 0;
    int i = 0;
    int table[length];
    for(i = 0; i < length; i++)
    {
    	table[i] = 0;
	}
    
    scanf("%d", &n);
    while(n-- > 0)
    {
    	int data = 0;
    	scanf("%d", &data);
    	table[data] = 1;
	}
    
    int first = 0;
    for(i = 0; i < length; i++)
    {
    	if(table[i] == 1)
    	{
    		// TODO
    		if(first == 0)
    		{
    			first = 1;
    			printf("%d", i);
			} else {
				printf(" %d", i);
			}
		}
	}
	printf("\n");
    return 0;
}
