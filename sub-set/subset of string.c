#include <stdio.h>  
#include <string.h>  
   
//User-defined substring function that will take string(str), position(p) and no of character(len) as input  
//Produces result c as output  
void substring(char s[], char sub[], int p, int len){  
   int c = 0;  
   while (c < len) {  
      sub[c] = s[p+c];  
      c++;  
   }  
   sub[c] = '\0';  
}  
   
int main()  
{  
    char c[10],str[10] ="ABC";  
    int i, j, len = strlen(str);  
      
    printf("All subsets for the given string are: ");  
    //This loop maintains the starting character  
    for(i = 0; i < len; i++){  
        //This loop adds the next character every iteration for the subset to form and add it to the array  
        for(j = 1; j <= len-i; j++){  
            substring(str,c,i,j);  
            printf("%s\n",c);  
        }  
    }  
    return 0;  
}  

