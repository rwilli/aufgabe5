/**
 * PostorderTree class extends SortedTree and
 * implements postorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class PostorderTree<T extends Comparable<? super T>> extends SortedTree<T> {

	@Override
	public TreeIter<T> iterator() {
		traverse();
		
		return new TreeIterImp();
	}
	
	private void traverse() {
		if (this.root != null)
			postorderTraverse(this.root);
	}

	/**
	 * Preorder method
	 * First root node then walk trough the left sub-tree
	 * and then trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void postorderTraverse(Node node) {
		if (node == null) 
			return;

		postorderTraverse(node.left);		// walk trough left sub-tree
		postorderTraverse(node.right);	// walk trough right sub-tree
		this.child.add(node);
	}
	@Override
	public Tree<T> clone() {
		
		PostorderTree<T> tmp =  new PostorderTree<T>();
		tmp.root = this.root.deepCopy();
		tmp.setDepth(tmp.root);
		return tmp;
		
	}

}