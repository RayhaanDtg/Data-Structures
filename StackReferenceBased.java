/**
 * A  stack referenced based class to store data
 * under the principle of LIFO
 * @author Rayhaan Dustagheer
 *
 * @param <E>
 */


public class StackReferenceBased <E>  {
	private Node<E> top; // field node which references to another node

	/**
	 * Constructor to create a new stack object
	 */
	public StackReferenceBased () {
		top=null;
	}
	/** Checks whether stack is empty
	 * 
	 * @return
	 */
	public boolean isEmpty( ) {
		return top==null;
	}
	/**
	 * adds a new item to the stack
	 * @param newItem
	 */
	public void push( E newItem) {
		top= new Node<E>(newItem,top);

	}
	/**
	 * deletes the item at the top of the stack
	 * returns the item at top of stack
	 * @return
	 */
	public E pop( ){

		if(!(isEmpty( ))) {
			Node <E> temp=top;
			temp=top;
			top=top.getNext();
			return temp.getItem();
		}
		else {
			
			System.out.println("Error.Stack empty");
			return null;
		}




	}
	/**
	 * Empties the stack
	 */
	public void popAll() {
		top=null;
	}
	public E peek() {
		if(!(isEmpty())) {
			return top.getItem();
		}
		else {
			System.out.println("Error.Stack empty");
			return null;
			
		}
	}

	
}
