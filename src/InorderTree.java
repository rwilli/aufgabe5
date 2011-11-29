/**
 * InorderTree class extends SortedTree and
 * implements inorder traverse method
 * 
 * @author Gruppe222
 *
 */
public class InorderTree<T extends Comparable<? super T>> extends SortedTree<T> {

	@Override
	public TreeIter<T> iterator() {
		traverse();
		
		return new TreeIterImp();
	}
	
	private void traverse() {
		if (this.root != null)
			inorderTraverse(this.root);
	}

	/**
	 * Preorder method
	 * First root node then walk trough the left sub-tree
	 * and then trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void inorderTraverse(Node node) {
		if (node == null) 
			return;

		inorderTraverse(node.left);	// walk trough left sub-tree
		this.child.add(node);
		inorderTraverse(node.right);	// walk trough right sub-tree
	}
	@Override
	public Tree<T> clone() {
		
		InorderTree<T> tmp =  new InorderTree<T>();
		tmp.root = this.root.deepCopy();
		tmp.setDepth(tmp.root);
		return tmp;
		
	}


}
