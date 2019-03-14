/**
 * This class aims at defining a Node, which is a link to another object item in
 * the reference based list
 * @author Rayhaan Dustagheer
 * @ version: 08.02.18
 */
public class Node<E> {
  private Node <E> next ; // field next is a Node, that is a link to another node
  private E data ; // this field is of type object and is created to store an item
  
  /**
   * The constructor builds a new Node, and initializes the first node
   * to null as well as the data to be stored null.
   */
  public Node   () {
	  next=null;
	  data=null;
  }
  /**
   * This constructor creates a new Node with an object data
   * @param o
   */
	public Node ( E o) {
		next=null;
		data=o;
	}
	/**
	   * This constructor creates a new Node with an object data and a node 
	   * to point to
	   * @param o
	   */
	public Node (E o, Node<E> n) {
		next=n;
		data=o;
	}
	/**
	 * Returns the item pointed by the node
	 * @return data
	 */
	public E getItem() {
		return data ;
	}
	/**
	 * Returns the next node the current hand is pointing to
	 * @return
	 */
	public Node<E> getNext() {
		return next ;
	}
	/**
	 * Sets the item to what a node is pointing
	 * @param o
	 */
	public void setItem(E o) {
		data=o;
	}
	/**
	 * Sets a node to point to another node
	 * @param n
	 */
	public void setNext (Node<E> n) {
		next=n;
	}
	}


