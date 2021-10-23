#include<stdio.h>
int n ,arr[100];	
void bubble_sort(int n,int arr[])	
{
	int i,j,temp;
	for (i=0;i< n-1;i++)
	{
		for(j=0;j< n-i-1;j++)
		{
			 if (arr[j]>arr[j+1])
			{				
       				temp = arr[j];
        			arr[j] = arr[j+1];
        			arr[j+1] = temp;
			}
		}
	}
}
void sorted_list(int arr[],int n)
{
	int i;
printf("Sorted List is ");
  for (i = 0; i < n; i++)
     printf("%d\n", arr[i]);	
}
void insert_number()
{
	
int i,j;
	
printf("enter how many numbers you want to insert");
scanf("%d",&n);	

printf("enter the numbers");
for(i=0;i<n;i++)
	scanf("%d",&arr[i]);
	
}
int main()
{
insert_number();

bubble_sort(n,arr);
 
sorted_list(arr,n);

return 0;
}




