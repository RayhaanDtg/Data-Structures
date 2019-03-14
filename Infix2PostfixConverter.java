/**
	 * Converts a given infix expression to a postfix expression
	 * Evaluates the postfix expression
	 * @ author GOOLAM DUSTAGHEER Mohammad Rayhaan
	 * 
	 */
public class Infix2PostfixConverter {
	/**
	 * converts a string to an array of characters
	 * @param s
	 * @return
	 */
	public static char[] toCharacterArray(String s) {
		
		if (s==null) {
			return null;
		}
		
		
		char[] array= s.replaceAll(" ", "").toCharArray();
		
			
		return array;
		}
		/**
		 * Uses position of operators in an array to check for precedence
		 * The operator with the higher index has the more precedence
		 * @param ch1
		 * @param ch2
		 * @return
		 */
	
	public static boolean checkPreced(char ch1, char ch2) {
		 char[] array= {'+','-','/','*'};
		  int num1=0;
		  int num2=0 ;
		
		
		for (int i=0; i<array.length; i++) {
			if (array[i]==ch1) {
				num1=i;
				
			}
			if (array[i]==ch2){
				num2=i ;
			}
	}
		
		return (num1<=num2);
		}
	/**
	 * converts the string into a postfix expression
	 * @param s
	 * @return
	 */
	public static String convertPostFix(String s) {
		String postFixExp="";
		StackReferenceBased <Character>  stack = new StackReferenceBased<Character>();
		char[] array= toCharacterArray(s);
		for (int i=0; i<array.length; i++) {
			char ch=array[i] ;
			if (ch=='(') {
				stack.push(ch);
				
			}
			else if( ch==')') {
				while ( ( stack.peek())!='(') {
					if(!(postFixExp.endsWith(" "))) {
						postFixExp=postFixExp+" ";
					}
					postFixExp= postFixExp+ (stack.pop())+ " ";
				}
				  stack.pop();
			}
					
			else if (array[i]=='+' || array[i]=='-' ||  array[i]=='*' ||  array[i]=='/') {
				if(!(postFixExp.endsWith(" "))) {
					postFixExp=postFixExp+" ";
				}
				while( !(stack.isEmpty()) && stack.peek()!='(' &&  checkPreced( ch,  stack.peek()) ) {
					postFixExp= postFixExp+  (stack.pop())+ " ";
				}
				stack.push(ch);
			}
			else {
				postFixExp= postFixExp+ ch;
			}
		
		}
		
		while (!stack.isEmpty()) {
			if(!(postFixExp.endsWith(" "))) {
				postFixExp=postFixExp+" ";
			}
			postFixExp=postFixExp  +  stack.pop();
		}
		return postFixExp ;
	}
	/**
	 * checks to which operator the character refers to, then evaluates
	 * the operands accordingly
	 * @param opr1
	 * @param opr2
	 * @param ch
	 * @return
	 */
	public static int operation( int opr1,int opr2, String ch) {
		if (ch.equals("+")) {
			return opr1+opr2 ;
			
		}
		else if (ch.equals("-")) {
			return opr1-opr2;
		}
		else if (ch.equals("*")) {
			return opr1*opr2;
		}
		else {
			return opr1/opr2;
		}
	}
	/**
	 * evaluates the postfix and returns the result
	 * @param postFix
	 * @return
	 */
	public static int getPostFix( String postFix) {
		StackReferenceBased<Integer> stack= new StackReferenceBased<Integer>();
		for (String s: postFix.split(" ")) {
		 if (!s.equals("+") && !s.equals("-") &&  !s.equals("*") &&  !s.equals("/")) { 
			 stack.push(Integer.valueOf(s));
				
				
			}
		 else {
			 int opr2= (stack.pop());
				int opr1= stack.pop();
				int answer= operation(opr1,opr2,s);
				stack.push(answer);
				
			 
		 }
		}
		return (stack.pop());
	}
	

	

}
