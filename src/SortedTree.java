/**
 * Abstract class SortedTree extends StringTree and
 * represents a binary tree. The left nodes are smaller
 * than the right ones and the right nodes are equal or
 * taller then the left ones.
 * 
 * @author Gruppe222
 *
 */
public abstract class SortedTree<T extends Comparable<T>> extends Tree<T> {

	@Override
	public void add(T element) {
		if (this.root == null)
			this.root = new Node(element);
		else
			this.root = insert(this.root, element);
	}
	
	/**
	 * Insert new node with given label in the tree
	 * 
	 * @param root root node of the tree
	 * @param element to be stored in the tree
	 * @return new tree
	 */
	private Node insert(Node root, T element) {
		if (root == null)
			root = new Node(element);
		// left side
		else if (element.compareTo(root.element) < 0 ) {
			root.left = insert(root.left, element);
			//TODO root.left.parent = root;
		// right side
		} else if (element.compareTo(root.element) >= 0 ) {
			root.right = insert(root.right, element);
			//TODO root.right.parent = root;
		}
		
		return root;
	} 

	@Override
	public Iter<Boolean> search(T element) {
		// TODO Auto-generated method stub
		return super.search(element);
	}
	
	public abstract TreeIter<T> iterator();

}
