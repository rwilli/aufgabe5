/**
 * Abstract class SortedTree extends Tree and represents a binary tree. The left
 * nodes are smaller than the right ones and the right nodes are equal or taller
 * then the left ones. SortedTree is a generic type with type variable T.
 * 
 * @author Gruppe222
 * 
 */
public abstract class SortedTree<T extends Comparable<? super T>> extends
		Tree<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Tree#add(java.lang.Object)
	 */
	@Override
	public void add(T element) {
		if (this.root == null) {
			this.root = new Node(element);
			this.root.depth = 0;
		} else {
			this.root = insert(this.root, element);
			this.setDepth(this.root);
		}
	}

	/**
	 * Insert new node with given label in the tree
	 * 
	 * @param root
	 *            root node of the tree
	 * @param element
	 *            to be stored in the tree
	 * @return new tree node
	 */
	private Node insert(Node root, T element) {
		if (root == null)
			root = new Node(element);
		// left side
		else if (element.compareTo(root.element) < 0) {
			root.left = insert(root.left, element);
			root.left.parent = root;
			// right side
		} else if (element.compareTo(root.element) >= 0) {
			root.right = insert(root.right, element);
			root.right.parent = root;
		}

		return root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Tree#search(java.lang.Object)
	 */
	@Override
	public Iter<Boolean> search(T element) {
		this.b = new List<Boolean>();

		Node currentNode = this.root;

		if (element.compareTo(this.root.element) == 0) {
			return new SearchIterImp();
		} else {
			while (currentNode != null) {
				if (element.compareTo(currentNode.element) < 0) {
					currentNode = currentNode.left;
					this.b.add(false);
				} else if (element.compareTo(currentNode.element) > 0) {
					currentNode = currentNode.right;
					this.b.add(true);
				} else
					return new SearchIterImp();
			}
		}

		return new SearchIterImp();
	}

	/**
	 * adds nodes to a tree. Additionally writes them into the list child for
	 * iterator purposes.
	 * 
	 * @param node to add.
	 */
	private void addNodes(Node node) {
		if (node == null)
			return;

		addNodes(node.left); // walk trough left sub-tree
		this.child.add(node);
		addNodes(node.right); // walk trough right sub-tree
	}

}
