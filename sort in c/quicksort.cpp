# include <stdio.h>
# define MAX_SIZE 9
# define SWAP(x, y, temp) ( (temp)=(x), (x)=(y), (y)=(temp) )


int partition(int list[], int left, int right){
  int pivot, temp;
  int low, high;

  low = left;
  high = right + 1;
  pivot = list[left];

  do{
    do {
      low++;
    } while (low<=right && list[low]<pivot);

    do {
      high--;
    } while (high>=left && list[high]>pivot);


    if(low<high){
      SWAP(list[low], list[high], temp);
    }
  } while (low<high);

  SWAP(list[left], list[high], temp);

  return high;
}

void quick_sort(int list[], int left, int right){

  if(left<right){
    int q = partition(list, left, right);

    quick_sort(list, left, q-1);
    quick_sort(list, q+1, right);
  }

}

int main(){
  int i;
  int n = MAX_SIZE;
  int list[n] = {5, 3, 8, 4, 9, 1, 6, 2, 7};

  quick_sort(list, 0, n-1);

  for(i=0; i<n; i++){
    printf("%d\n", list[i]);
  }
}
