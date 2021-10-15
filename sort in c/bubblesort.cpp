# include <stdio.h>
# define MAX_SIZE 5

void bubble_sort(int list[], int n){
  int i, j, temp;

  for(i=n-1; i>0; i--){
    for(j=0; j<i; j++){
      if(list[j]<list[j+1]){
        temp = list[j];
        list[j] = list[j+1];
        list[j+1] = temp;
      }
    }
  }
}

void main(){
  int i;
  int n = MAX_SIZE;
  int list[n] = {7, 4, 5, 1, 3};

  bubble_sort(list, n);

  for(i=0; i<n; i++){
    printf("%d\n", list[i]);
  }
}
