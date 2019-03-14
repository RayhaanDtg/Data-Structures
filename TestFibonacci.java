package recursion;

public class TestFibonacci {

	
	public static int Fibonacci(int n){
		
		if(n<=2){
			return 1;
		}
		else{
		return	Fibonacci(n-1) + Fibonacci(n-2);
		}	
	}
	
	public static int FibonacciIterative(int n)
	{
		int previous=1, current=1, next=1;
		for(int i=3;i<=n;i++)
		{
			next = previous + current;
			
			previous = current;
			current = next;  
		}
		return next;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Fibonacci(10));
	//	System.out.println(FibonacciIterative(10));
		
	}

}
