#include <stdio.h>
int main()
{
	int a;
	printf("Enter a number: ");
	scanf("%d",&a);
	if (a>0)
	{
		printf("%d is a positive number",a);
	}
	else if (a<0)
	{
		printf("%d is a negative number",a);
	}
	else if (a==0)
	{
		printf("%d is equal to zero",a);
	}
	return 0;
}
