package recursion;

public class TestParade {

public static int Parade(int n){
		
		if(n==1){
			return 2;
		}
		else if(n==2)
		{
			return 3;
		}
		else{
		return	Parade(n-1) + Parade(n-2);
		}
			
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Parade(20));
		
	}

}
