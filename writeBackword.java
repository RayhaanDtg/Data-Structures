package recursion;

public class writeBackword {


	public static void writeBack(String s){

		if(s.length()>0)
		{   
			System.out.print(s.charAt(s.length()-1));	
			writeBack(s.substring(0, s.length()-1));
		}
	}
	
	public static void writeBack(String s, int size)
	{
		if(size>0){
		System.out.print(s.charAt(size-1));
		writeBack(s,size-1);
		}
	}

	
	public static void writeBackIterative(String s, int size)
	{
		while(size>0){
		System.out.print(s.charAt(size-1));
		--size;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		writeBack("SYSC2100");
	//	System.out.println("\n");
	//	writeBack("SYSC2100",8);
    //	System.out.println("\n");
	//	writeBackIterative("SYSC2100",8);
	}

}
