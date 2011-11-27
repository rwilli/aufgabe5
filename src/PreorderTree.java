/**
 * PreorderTree class extends SortedTree and
 * implements preorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class PreorderTree<T extends Comparable<? super T>> extends SortedTree<T> {
	
	@Override
	public TreeIter<T> iterator() {
		traverse();
		
		return new TreeIterImp();
	}
	
	private void traverse() {
		if (this.root != null)
			preorderTraverse(this.root);
	}

	/**
	 * Preorder method
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
