public class TreeNode {
	
	Integer smallItem;
	Integer largeItem;
	Integer midItem;
	TreeNode leftChild;
	TreeNode midChild;
	TreeNode midRight;
	TreeNode rightChild;
	
	public TreeNode(Integer smallItem, Integer largeItem){
		this.smallItem = smallItem;
		this.largeItem = largeItem;
		leftChild = null;
		midChild = null;
		rightChild = null;
	}
	
	public TreeNode(Integer smallItem, Integer largeItem,TreeNode leftChild,TreeNode rightChild){
		this.smallItem = smallItem;
		this.largeItem = largeItem;
		this.leftChild = leftChild;
		midChild = null;
		this.rightChild = rightChild;
	}
	
	public boolean isLeaf(){
		return (leftChild == null && midChild == null && rightChild == null);
	}
	
	public boolean hasTwoItems(){
		return (smallItem != null && largeItem != null);
	}
	public boolean hasOneItem(){
		return (smallItem == null && largeItem != null ||smallItem != null && largeItem == null );
	}
	
	public String toString(){
		if(this.hasTwoItems()){
			return "(" + smallItem + "  " + largeItem + ")";
		}else{
			return "(" + smallItem +")";
		}
	}
}
