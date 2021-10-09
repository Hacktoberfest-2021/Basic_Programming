
import java.util.*;
import java.time.*;

public class MinMax {
    int array[];
    
    MinMax(int arr[])
    {
        array = arr;
    }
     void linearMinMax()
    {
        int min,max;
        min = array[0];
        max = array[0];
        for(int i=1;i<array.length;i++)
        {
            if(array[i]>max) max=array[i];
            if(array[i]<min) min = array[i];
        }
        System.out.println("Minimum ="+ min);
        System.out.println("Maximum ="+ max);
    }
     void printArr()
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }
    }
     int[] dacMinMax(int start,int end)
    {
        int min=999999,max=0;
        if(start == end)
        {
            min = array[start];
            max = array[start];
            int ans[] = {max,min};
            return ans;
        }
        if(start+1 == end)
        {
            if(array[end]>array[start])
            {
                max = array[end];
                min = array[start];
            }
            else
            {
                max = array[start];
                min = array[end];
            }
            int ans[] = {max,min};
            return ans;
        }
        
            int mid = (start+end)/2;
            int left[] = dacMinMax(start,mid);
            int right[] = dacMinMax(mid+1,end);
            if(left[0]>right[0])
                max = left[0];
            else
                max = right[0];
            
            if(left[1]<right[1])
                min = left[1];
            else min = right[1];
        
        int ans[] = {max,min};
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        int upper = 992104;
        System.out.println("Enter test cases.");
        int t = sc.nextInt();
        while(t-- > 0)
        {
        System.out.println("Enter Size of array");
        int size =sc.nextInt();
        int arr[] = new int[size];
        
        long start,end;
        
        for(int i=0;i<size;i++)
        {
            arr[i] = ra.nextInt(upper);
        }
        MinMax a1 = new MinMax(arr);

   //     a1.printArr();
        System.out.println("Linear Approach:");        
        start = System.currentTimeMillis();
        a1.linearMinMax();
        end = System.currentTimeMillis();
        System.out.println("Time required in sec.." + (float)(end-start)/1000);




        System.out.println("\nDAC Approach:"); 
        start = System.currentTimeMillis();
        int ans[] = a1.dacMinMax(0,size-1);
        System.out.println("Minimum ="+ ans[1]);
        System.out.println("Maximum ="+ ans[0]);
        end = System.currentTimeMillis();
        System.out.println("Time required in sec.." + (float)(end-start)/1000);
    }
  }
}