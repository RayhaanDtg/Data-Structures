package recursion;

public class Factorial{

	// Sequential Method
	public static int factSeqential(int n){
		if(n==0){
			return 1;
		}

		int Fact=1;
		for(int i=1;i<=n;i++){
			Fact = Fact*i; 
		}
		return Fact;
	}	

	//Recursive Method
	public static int factRecursive(int n){
		if(n==0){
			return 1;
		}
		else {
			return n*factRecursive(n-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Factorial: (sequential): " + factSeqential(-6));	
		System.out.println("Factorrial: (recursive): " + factRecursive(-6)); 
	}




}
