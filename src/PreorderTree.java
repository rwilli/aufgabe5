/**
 * PreorderTree class extends SortedTree and
 * implements preorder traverse method
 * PreorderTree is a generic type with type variable T.
 * 
 * @author Gruppe222
 *
 */
public class PreorderTree<T extends Comparable<? super T>> extends SortedTree<T> {
	
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
	 * traverse method
	 */
	private void traverse() {
		if (this.root != null)
			preorderTraverse(this.root);
	}

	/**
	 * First root node then walk trough the left sub-tree
	 * and then trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void preorderTraverse(Node node) {
		if (node == null) 
			return;

		this.child.add(node);
		preorderTraverse(node.left);	// walk trough left sub-tree
		preorderTraverse(node.right);	// walk trough right sub-tree
	}


}
