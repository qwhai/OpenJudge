#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

char getDigit(char ch)
{
  char num;
  if(ch<='9' && ch>='0') return ch-'0';	
  num = ch-'A';
  if(num > 15) num--;
  return num/3 + 2;
}


int transform(char s[])
{
	int i,result=0;
	for(i=0; i<256; i++)
	{
		if(s[i]=='\0') break;
		if(s[i] != '-') result = result*10 + getDigit(s[i]);
	}
	return result;
}

void print(int a, int count)
{
	int i=0;
	int base=1000000;
	char s[9];
	s[3]='-';
	s[8]='\0';
	for(;i<8;i++)
	{
		if(i!=3)
		{
		   s[i]=a/base+'0';
		   a = a%base;
		   base=base/10;
		}
    }
    printf("%s %d\n",s, count);
}

int main()
{
	int n,i,j,flag=0,phone;
	char s[256];
	
	int *list = (int*)malloc(10000000*sizeof(int));
	for(i=0; i<10000000; i++) list[i]=0;
	
	scanf("%d", &n);
	
	for(i=0; i<n; i++)
	{
      scanf("%s", s);
      phone = transform(s);
      list[phone]++;
	}
	
	for(i=0; i<10000000; i++)
	{
		if(list[i]>1)
		{
			flag=1;
			print(i, list[i]);
		}
	}
	if(!flag) printf("No duplicates.\n");
	
	return 0;
}
