import java.util.Scanner;

public class TestInfix2PostfixConverter {

	public static void main(String[] args) {
		Scanner key= new Scanner(System.in);
		System.out.print("infix: "  );
		String infix= key.nextLine();
		key.close();
		Infix2PostfixConverter conv= new Infix2PostfixConverter();
		
		String s= conv.convertPostFix(infix);
		System.out.println("postfix: " + s);
		System.out.println("result: "+ conv.getPostFix(s));
		
		
		
	}

}
