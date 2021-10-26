#include<stdio.h>
int reverse_array(int a[],int n)
{
	int i=0,j=n-1,temp;
	while(i<j)
	{
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		i++;
		j--;
	}	
}
int printarray(int a[],int n)
{
	int i;
	for(i=0;i<n;i++)
	{
		printf("%d",a[i]);
			
	}
}
int main()
{
	int a[]={1,2,3,4,5};
	int n=sizeof(a)/sizeof(a[0]);
	printarray(a,n);
	printf("\n");
	reverse_array(a,n);
	printarray(a,n);	
}
