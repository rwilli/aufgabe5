/**
 * InorderTree class extends SortedTree and
 * implements inorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class InorderTree extends SortedTree {

	/**
	 * default constructor
	 */
	public InorderTree() {
		
	}
	
	/**
	 * constructor with root node
	 * 
	 * @param n root node
	 */
	public InorderTree(INode n) {
		this.root = n;
	}
	
	/**
	 * constructor with root node and string label
	 * 
	 * @param n root node
	 * @param l string label
	 */
	public InorderTree(INode n, String l) {
		this.root = n;
		this.root.setLabel(l);
	}
	
	/* (non-Javadoc)
	 * @see stringtree.SortedTree#traverse()
	 */
	@Override
	public String traverse() {
		if (this.root != null)
			inorderTraverse(this.root);
	         
		return this.order;
	}
	
	/**
	 * Inorder method
	 * First walk trough the left sub-tree
	 * then the root node and finally
	 * trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void inorderTraverse(INode node) {
		if (node == null) 
			return;
		
		inorderTraverse(node.getLeftNode());	// walk trough left sub-tree
		this.order += node.getLabel() + " ";
		inorderTraverse(node.getRightNode());	// walk trough right sub-tree
	}
}
