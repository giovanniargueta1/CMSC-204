/** 
 * Creating the node for the tree
 * 
 * 
 * @author Giovanni Argueta
 *
 *
 * @param <T> datatype Tree will hold
 */
public class TreeNode<T> {
	
	TreeNode<T> left;
	TreeNode<T> right;
	private T data;
	

	public TreeNode(T dataNode) {
		left = right = null;
		data = dataNode;
	}
	
	/** 
	 * copy constructor 
	 * 
	 * @param node 
	 * 
	 */
	public TreeNode(TreeNode<T> node) {
		//always makes sure to include both children
		this(node.getData());
		left = node.left;
		right = node.right;
	}
	
	/**
	 * gets data
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}
}