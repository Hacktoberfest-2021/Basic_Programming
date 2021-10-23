
public class rangeprime {


	public static void main(String[] args) 
	{
		int n=2,m=17,i,j;
		boolean isprime=true;
	for (j=n;j<=m;j++)
	{
		
		for(i=2;i<j;i++)
		{
			if(j%i==0)
			{
				isprime=false;
				break;
			}
		}
		if(i==j)
		{
			System.out.println(j +" Is a prime number");
		}
	}
		
	}

}
