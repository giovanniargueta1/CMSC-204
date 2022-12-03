import java.util.ArrayList;
/**
 *making the tree!
 *
 *
 * @author Giovanni Argueta
 * 
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	public MorseCodeTree() {
		root=null;
		buildTree();
	}
	
	/**
	 * 
	 * 
	 * @return reference (of root)
	 */
	@Override
	public TreeNode<String> getRoot() {

		return root;
	}
	
	/**
	 * sets roots
	 * 
	 * @param newNode 
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
	
		root=new TreeNode<String>(newNode);
		
	}

	/**
	 * adds in letter at correct position
	 * 
	 * 
	 * @param code
	 * 
	 * @param letter
	 * 
	 * 
	 * @return MorseCode tree 
	 */
	@Override
	public void insert(String code, String letter) {
		if(root==null){
			root=new TreeNode<String>(letter);
		}
		else {
			addNode(root,code,letter);
		}
		return;
	}

	/**
	 * inserts node a correct position
	 * 
	 * 
	 * @param root 
	 * 
	 * @param code 
	 * 
	 * @param letter 
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if(code.length()>1) {
			if(code.charAt(0)=='-') {
				addNode(root.right,code.substring(1),letter);
			}
			else {
				addNode(root.left,code.substring(1),letter);
			}
		}
		else {
			if(code.equals(".")) {
				root.left=new TreeNode<String>(letter);
			}
			else {
				root.right=new TreeNode<String>(letter);
			}
		}
		
	}

	/**
	 * 
	 * returns the string based on code
	 * 
	 * 
	 * @param code
	 * 
	 * @return a string 
	 */
	@Override
	public String fetch(String code){//code is converter 
		String result= fetchNode(root,code);
		
		return result;
	}

	/**
	 * gets data from tree
	 * 
	 *all current
	 * @param root 
	 * 
	 * @param code 
	 * 
	 * @return string  
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter="";
		if(code.length()>1) {
			if(code.charAt(0)=='.') {
				letter+=fetchNode(root.left,code.substring(1));
			}
			else {
				letter+=fetchNode(root.right,code.substring(1));
			}
			
		}
		else {
			if(code.equals(".")) {
				letter+=root.left.getData();
				return letter;
			}
			else { 
				letter+=root.right.getData();
				return letter;
			}
		}
		return letter;
	}

	/**
	 * throwing exception when operation is not included 
	 * 
	 * 
	 * @throws UnsupportedOperationException 
	 * 
	 * @param data
	 * 
	 * @return current tree(reference)
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *updating the exception from before
	 *
	 * @throws UnsupportedOperationException 
	 * 
	 * 
	 * @return current tree reference 
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * inserting the nodes from left to right
	 * 
	 */
	@Override
	public void buildTree() {
		//each line represents a different level (root, level 1 etc)
		
		insert("","");
		
		insert(".","e"); insert("-","t");
		
		insert("..","i"); insert(".-","a");insert("-.","n"); insert("--","m");
		
		insert("...","s"); insert("..-","u");insert(".-.","r"); insert(".--","w");insert("-..","d"); insert("-.-","k");insert("--.","g"); insert("---","o");
		

		insert("....","h"); insert("...-","v");insert("..-.","f"); insert(".-..","l");insert(".--.","p"); insert(".---","j");
		insert("-...","b"); insert("-..-","x");insert("-.-.","c"); insert("-.--","y");insert("--..","z"); insert("--.-","q");
		// last level became too long but these two are still the same level
		
		
	}

	/**
	 * 
	 * returns tree in LNR order
	 * 
	 * 
	 * @return arrayList 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String>list=new ArrayList<String>();
		LNRoutputTraversal(root,list);
		return list;
	}

	/**
	 * orders items in tree InOrder
	 * 
	 * @param root
	 * @param list
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		//making sure both children are present
		if(root.left==null && root.right==null) {
			list.add(root.getData()+" ");
		}
		else {
			if(root.left!=null) {
				LNRoutputTraversal(root.left,list);
				list.add(root.getData()+" ");
			}
			if(root.right!=null) {
				LNRoutputTraversal(root.right,list);
			}
		}
		
	}
	
}