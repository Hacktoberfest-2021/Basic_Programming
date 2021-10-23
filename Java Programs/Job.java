import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Job implements Comparable<Job>{
    int deadline,profit,jono;
    
    Job(int d,int p,int n)
    {
        deadline = d;
        profit = p;
        jono = n;
    }
    Job(){}
    @Override
    public int compareTo(Job o) {
       int i=this.deadline-o.deadline;
		if(i==0) {
			int j=o.profit-this.profit;
			return j;
		}
		return i;
    }
    
    public String toString(){
        return "Job no " + this.jono +
                " Profit "+ this.profit+
                " Deadline "+ this.deadline;
    }
    
    //greedy approach for scheduling job
    public void greddy(Job j[])
    {
        Arrays.sort(j);
        ArrayList<Job> ar1 = new ArrayList<>();
        Job job1 = j[0];
         
        for(int i=1;i<j.length;i++)
        {
            if(job1.deadline != j[i].deadline)
            {
                ar1.add(job1);
                job1 = j[i];
            }
        }
        if(!ar1.contains(job1)) ar1.add(job1);
        
        System.out.println("Completed jobs are::");
        for(Job j1:ar1)
        {
            System.out.println(j1);
        }
        
        profit(ar1);
    }
    
    //printing job method
    public void profit(ArrayList<Job> ar1)
    {
        int total =0;
        for(Job j:ar1)
        {
            total += j.profit;
        }
        System.out.println("Total profit is : " + total);
    }
    
    //naive approach for scheduling job
    public void naive(Job j[])
    {
        
        ArrayList<Job> js = new ArrayList<>(Arrays.asList(j));
        Collections.sort(js, new deadComp());
        ArrayList<Job> ar1 = new ArrayList<>();
        
        Job job1 = j[0];
        for(int i=1;i<j.length;i++)
        {
            while(job1.deadline == js.get(i).deadline)
            {
                if(job1.profit<js.get(i).profit )
                {
                    job1 = js.get(i);
                   // ar1.add(job1);
                }
                i++;
                if(i>=j.length)
                {
                    break;
                }
            }
            
            ar1.add(job1);
            if(i>=j.length)
            {
                break;
            }
            job1 = js.get(i);
        }
        if(ar1.get(ar1.size()-1).deadline != job1.deadline)
        {
            ar1.add(job1);
        }
        System.out.println("Completed jobs are::");
        for(Job j1:ar1)
        {
            System.out.println(j1);
        }
        profit(ar1);
    }
}

//main driver class
class Demo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of jobs");
        int n = sc.nextInt();
        Job j[] = new Job[n];
        Random r = new Random(); 
        for(int i=0;i<n;i++)
        {
            j[i] = new Job( r.nextInt(8)+1,r.nextInt(100) ,i+1);
        }
//        for(Job job: j)
//        {
//            System.out.println(job);
//        }
//        System.out.println("\n");
        Job j1 = new Job();
        System.out.println("Greedy approach");
        long start = System.currentTimeMillis();
        j1.greddy(j);
        long end = System.currentTimeMillis();
        
        System.out.println("Time required : "+ ((double)(end-start)/1000));
        
        System.out.println("Naive approach");
        start = System.currentTimeMillis();
        j1.naive(j);
        end = System.currentTimeMillis();
        //System.out.println(start +" " + end);
        System.out.println("Time required : "+ ((double)(end-start)/1000));
    }
}

//class for comparing jobs on bassis of deadline
class deadComp implements Comparator<Job>{

    @Override
    public int compare(Job o1, Job o2) {
         return o1.deadline-o2.deadline;
    }
    
}