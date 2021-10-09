
import java.util.Scanner;
import java.util.*;


public class AirTraffic {
    public Point[] closestPair = new Point[2];
    public static float mindis;
    public AirTraffic() {
    }
    
    public AirTraffic(Point a[])
    {
        closestPair[0]=a[0];
        closestPair[1]=a[1];
    }
    public static float dist(Point p1,Point p2)
    {
       return (float)Math.sqrt(Math.pow((p2.x-p1.x), 2)+Math.pow((p2.y-p1.y), 2));
    }
    public Point[] brutForce(Point p[],int n)
    {
        Point[] close = new Point[2];
        float mindis = 9999;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if( dist(p[i],p[j]) < mindis)
                {
                    mindis = dist(p[i],p[j]);
                    close[0] = p[i];
                    close[1] = p[j];
                }
            }
        }
        System.out.printf("Minimum Distance is %.2f \n", mindis);
        return close;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of points");
        int n = sc.nextInt();
        Point p1[] = new Point[n];
        
        for(int i=0;i<n;i++)
        {
            p1[i] = new Point((float)Math.random()*10,(float)Math.random()*10,i+1);
        }
//        for(int i=0;i<n;i++)
//        {
//            System.out.printf("x:%.2f  y:%.2f  \n", p1[i].getx(),p1[i].gety());
//        }
        AirTraffic a1 = new AirTraffic();
        
        System.out.println("Brute Force");
        long beg=System.currentTimeMillis();
        Point[] a = a1.brutForce(p1, n);
        System.out.println("Closest point is:" + a[0].getno()  + " " + a[1].getno());
        long fin=System.currentTimeMillis()-beg;
        System.out.println("Time required "+(double)fin/1000);
        
        System.out.println("\nDivide and Conqure");
        Arrays.sort(p1,new Sortby());
//        for(int i=0;i<n;i++)
//        {
//            System.out.printf("%.2f %d\n",p1[i].getx(),p1[i].getno());
//        }
        beg=System.currentTimeMillis();
        p1=DAC.sort(p1);
        DAC.mindist=DAC.findClosestPair(p1, 0, n);
        DAC.mindist=DAC.merge(p1, 0, p1.length, DAC.mindist);
        DAC.display();  
        fin=System.currentTimeMillis()-beg;
        System.out.println("Time required "+(double)fin/1000);
    }
}

class Point{
    float x,y;
    int no;
    Point(float x,float y,int no)
    {
        this.x = x;
        this.y = y;
        this.no = no;
    }
    float getx()
    {
        return this.x;
    }
    float gety()
    {
        return this.y;
    }
    int getno()
    {
        return this.no;
    }
}
class Sortby implements Comparator<Point>{

    @Override
    public int compare(Point o1, Point o2) {
        return Float.compare(o1.getx(),o2.getx());
    }
    
}
class SortbyY implements Comparator<Point>{

    @Override
    public int compare(Point o1, Point o2) {
        return Float.compare(o1.gety(), o2.gety());
    }
    
}



 class DAC {
	//static Point a[];
	static float mindist;
	static Point closestpair[]=new Point[2];
	public static Point[] sort(Point a[]) {
		ArrayList<Point> ps=new ArrayList<Point>(Arrays.asList(a));
		Collections.sort(ps,new Sortby());
		
		a=ps.toArray(a);
		closestpair[0]=a[0];
		closestpair[1]=a[1];
		return a;
	}
	public static float findClosestPair(Point x[],int start,int end) {
		 
		if(end-start==2) {
			chkclos(x[start],x[start+1]);
			//System.out.println("Returning 2");
			return AirTraffic.dist(x[start],x[start+1]);
		}
		if(end-start==3) {
			float a1=AirTraffic.dist(x[start], x[start+1]);
			float a2=AirTraffic.dist(x[start+1], x[start+2]);
			//System.out.println("Returning 3");
			if(a1<a2) {
				chkclos(x[start],x[start+1]);
			}
			else {
				chkclos(x[start+1],x[start+2]);
			}
			a1=Math.min(a1, a2);
			a2=AirTraffic.dist(x[start], x[start+2]);
			if(a1<a2) {
				return a1;
			}
			chkclos(x[start],x[start+2]);
			return a2;
		}
		int mid=(start+end)/2;
		//System.out.println("Mid= "+mid);
		float st=findClosestPair(x,start,mid);
		float ed=findClosestPair(x,mid,end);
		float mindist1 = Math.min(st, ed);
		return mindist1;
		//System.out.println("Min dist "+mindist1);
	
	}
	public static float merge(Point x[],int start,int end,float mindist1) {
		ArrayList<Point> pn=new ArrayList<>();
		int i=0;
		while(x[i].x-x[i+1].x>mindist1) {
			i++;
		}
		for(;i<x.length-1;i++) {
			if(x[i].x-x[i+1].x<=mindist1) {
				pn.add(x[i]);
				//System.out.println(x[i].x+","+x[i].y);
			}
		}
		
		Collections.sort(pn,new SortbyY());
	    Point l[] = new Point[pn.size()];
	    //for(int i=0;i<pn.size();i++) {
		//	l[i]=pn.get(i);
			
		//}
	    l=pn.toArray(l);
	    //l=sorty(l);
	    float mindist2=findClosestPair(l, 0, l.length);
	    return Math.min(mindist1, mindist2);
	}
	public static void chkclos(Point p1,Point p2) {
		if(AirTraffic.dist(p1, p2)<AirTraffic.dist(closestpair[0], closestpair[1])) {
			closestpair[0]=p1;
			closestpair[1]=p2;
		}
	}
	public static void display() {
		System.out.println("Closest point is:" + closestpair[0].getno()  + " " + closestpair[1].getno());
		System.out.printf("Minimum Distance is %.2f \n", mindist);
	}
}
