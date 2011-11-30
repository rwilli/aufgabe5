/**
 * PostorderTree class extends SortedTree and
 * implements postorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class PostorderTree<T extends Comparable<? super T>> extends SortedTree<T> {

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
			postorderTraverse(this.root);
	}

	/**
	 * First walk trough the left sub-tree 
	 * then trough the right sub-tree and then root node
	 * 
	 * @param node root node
	 */
	private void postorderTraverse(Node node) {
		if (node == null) 
			return;

		postorderTraverse(node.left);		// walk trough left sub-tree
		postorderTraverse(node.right);		// walk trough right sub-tree
		this.child.add(node);
	}


}