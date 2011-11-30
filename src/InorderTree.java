/**
 * InorderTree class extends SortedTree and
 * implements inorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class InorderTree<T extends Comparable<? super T>> extends SortedTree<T> {

	/*
	 * (non-Javadoc)
	 * @see Tree#iterator()
	 */
	@Override
	public TreeIter<T> iterator() {
		
		this.child = new List<Node>();
		traverse();
		
		return new TreeIterImp();
	}
	
	/**
	 * traverse tree
	 */
	private void traverse() {
		if (this.root != null)
			inorderTraverse(this.root);
	}

	/**
	 * First walk trough left sub-tree then root
	 * and then walk trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void inorderTraverse(Node node) {
		if (node == null) 
			return;

		inorderTraverse(node.left);		// walk trough left sub-tree
		this.child.add(node);
		inorderTraverse(node.right);	// walk trough right sub-tree
	}


}
