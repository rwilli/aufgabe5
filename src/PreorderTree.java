/**
 * PreorderTree class extends SortedTree and
 * implements preorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class PreorderTree extends SortedTree {
	
	/**
	 * default constructor
	 */
	public PreorderTree() {
		
	}
	
	/**
	 * constructor with root node
	 * 
	 * @param n root node
	 */
	public PreorderTree(INode n) {
		this.root = n;
	}
	
	/**
	 * constructor with root node and string label
	 * 
	 * @param n root node
	 * @param l string label
	 */
	public PreorderTree(INode n, String l) {
		this.root = n;
		this.root.setLabel(l);
	}
	
	/* (non-Javadoc)
	 * @see stringtree.SortedTree#traverse()
	 */
	@Override
	public String traverse() {
		if (this.root != null)
			preorderTraverse(this.root);
	    
		return this.order;
	}

	/**
	 * Preorder method
	 * First root node then walk trough the left sub-tree
	 * and then trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void preorderTraverse(INode node) {
		if (node == null) 
			return;

		this.order += node.getLabel() + " ";
		preorderTraverse(node.getLeftNode());	// walk trough left sub-tree
		preorderTraverse(node.getRightNode());	// walk trough right sub-tree
	}

}
