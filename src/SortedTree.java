/**
 * Abstract class SortedTree extends StringTree and
 * represents a binary tree. The left nodes are smaller
 * than the right ones and the right nodes are equal or
 * taller then the left ones.
 * 
 * @author Gruppe222
 *
 */
public abstract class SortedTree<T extends Comparable<? super T>> extends Tree<T> {

	@Override
	public void add(T element) {
		this.child.add(new Node(element));
	}
	
	/**
	 * Insert new node with given label in the tree
	 * 
	 * @param root root node of the tree
	 * @param element to be stored in the tree
	 * @return new tree
	 */
	private Node insert(Node iterator, T element) {
		if (iterator == null)
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
