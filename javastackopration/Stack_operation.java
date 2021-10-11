import java.util.*;

class stack{
	int n=5;
	int[] s = new int[n];
	int top=-1,x;
	
	void push()
	{
		Scanner br = new Scanner(System.in);
		try
		{
			System.out.print("Enter Value x = : ");
			x = br.nextInt();		
		}
		catch(Exception e)
		{}
		if(top >= n-1)
		{
			System.out.print("stack is overflow");
			
		}
		else
		{
			top=top+1;
			s[top]=x;
			System.out.println("Value Inserted Successful..");
		}	

	}

	void dis()	
	{
		int i=top;
		if(top==-1){
			System.out.println("Stack is Empty!");
		}
		else{
			do{
			System.out.println(s[i]);
			i--;
			}while(i>-1);
		}		
	}
	void pop(){
		int temp;
		if(top==-1)
		{
			System.out.println("Stack Underflow Error(Stack is empty)");
		}
		else{
			temp=s[top];
			top--;
			System.out.println("This Item Removed : "+temp);
		}		
	}
}
class Stack_operation{
	 public static void main(String args[])
	 {
		 char st;
		 int ch=0;
		 stack ob1=new stack();
		 do{
			 System.out.println("********* MENU *********\n1.PUSH\n2.POP\n3.DISPLAY\n4.EXIT");
			 
			 Scanner myObj = new Scanner(System.in);
			 System.out.print("Enter Your Choice (1-4) : ");
			 ch = myObj.nextInt();
			 switch(ch)
				{
					case 1:
					ob1.push();
					//System.out.println("push function is under maintenance ");
					break;

					case 2:
					ob1.pop();
					//System.out.println("pop function is under maintenance ");
					break;

					case 3:
					ob1.dis();
					//System.out.println("dis function is under maintenance ");
					break;
					
					case 4:
					System.out.println("Bye Bye Come Again");
					System.exit(0);
					break;
					
					default: System.out.println("only 1-4 allow ");
					break;

				}
				Scanner a = new Scanner(System.in);
				System.out.print("\n Do You Want to Continue y/n : "); 
				st = a.nextLine().charAt(0);System.out.println("Bye Bye Come Again");
		}while(st=='Y' || st=='y');
	 }
 }