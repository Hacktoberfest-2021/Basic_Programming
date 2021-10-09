#include<stdio.h>

int main()
{
    
    char str[10000],i=0,count=0;
    printf("enter the line: ");
    gets(str);
    printf("two vowels in succesion are: ");
    while(str[i]!='\0')
    {
        if(str[i]=='a'|| str[i]=='e'|| str[i]=='i'|| str[i]=='o'||str[i]=='u' )
        {
            if(str[i+1]=='a'|| str[i+1]=='e'|| str[i+1]=='i'|| str[i+1]=='o'|| str[i+1]=='u')
            {
                count++;
                printf("%c%c  ",str[i],str[i+1]);
            }
        }
        i++;
    }
    printf("\noccurence of two vowels in succesion = %2d\n ",count);

    return 0;
}
