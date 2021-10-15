# include <stdio.h>
# define MAX_SIZE 10

void inc_insertion_sort(int list[], int first, int last, int gap){
  int i, j, key;

  for(i=first+gap; i<=last; i=i+gap){
    key = list[i];
    for(j=i-gap; j>=first && list[j]>key; j=j-gap){
      list[j+gap] = list[j];
    }

    list[j+gap] = key;
  }
}

void shell_sort(int list[], int n){
  int i, gap;

  for(gap=n/2; gap>0; gap=gap/2){
    if((gap%2) == 0)(
      gap++;
    )

    for(i=0; i<gap; i++){
      inc_insertion_sort(list, i, n-1, gap);
    }
  }
}

void main(){
  int i;
  int n = MAX_SIZE;
  int list[n] = {10, 8, 6, 20, 4, 3, 22, 1, 0, 15, 16};

  shell_sort(list, n);

  for(i=0; i<n; i++){
    printf("%d\n", list[i]);
  }
}
