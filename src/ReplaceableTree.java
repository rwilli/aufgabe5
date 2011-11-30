/**
 * PreplaceableTree class extends Tree. ReplaceableTree is a generic type with
 * type variable T.
 * 
 * @author Gruppe222
 * 
 */
public class ReplaceableTree<T> extends Tree<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Tree#add(java.lang.Object)
	 */
	@Override
	public void add(T element) {
		if (this.root == null) {
			this.root = new Node(element);
			this.root.parent = null;
			this.root.depth = 0;
		} else {
			Node n = findPlace(this.root, 0);
			Node child = new Node(element);
			child.parent = n;

			setDepth(this.root);

			if (n.left == null) {
				n.left = child;
			} else {
				n.right = child;
			}

			setDepth(this.root);
		}
	}

	/**
	 * Finds the place of a node.
	 * 
	 * @param node
	 *            a Node
	 * @param depth
	 *            as integer
	 * @return a Node
	 */
	private Node findPlace(Node node, int depth) {

		node.depth = depth;

		if (node.left == null || node.right == null) {
			return node;
		} else {
			depth++;
			Node n1, n2;
			n1 = findPlace(node.left, depth);
			n2 = findPlace(node.right, depth);

			if (n1.depth > n2.depth)
				return n2;
			else
				return n1;

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Tree#search(java.lang.Object)
	 */
	@Override
	public Iter<Boolean> search(T element) {
		this.b = new List<Boolean>();
		Stack<Boolean> s2 = new Stack<Boolean>();
		Stack<Node> s = new Stack<Node>();

		if (this.root != null)
			s.push(this.root);
		else
			return null;
		while (!s.isEmpty()) {
			Node n = s.pop();
			do {
				if (n.element.equals(element)) {
					Node p = n.parent;
					while (p != null) {
						if (p.left == n) {
							s2.push(false);

						} else {
							s2.push(true);

						}
						n = p;
						p = p.parent;
					}

					while (!s2.isEmpty()) {
						this.b.add(s2.pop());
					}

					return new SearchIterImp();
				}
				if (n.right != null) {
					s.push(n.right);
				}
				n = n.left;
			} while (n != null);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Tree#iterator()
	 */
	@Override
	public TreeIter<T> iterator() {
		traverse();

		return new TreeIterImp();
	}

	/**
	 * traverse method
	 */
	private void traverse() {
		if (this.root != null)
			inorderTraverse(this.root);
	}

	/**
	 * Inorder method first root node then walk trough the left sub-tree and
	 * then trough the right sub-tree
	 * 
	 * @param node
	 *            root node
	 */
	private void inorderTraverse(Node node) {
		if (node == null)
			return;

		inorderTraverse(node.left); // walk trough left sub-tree
		this.child.add(node);
		inorderTraverse(node.right); // walk trough right sub-tree
	}

	/**
	 * Replaces a Node with a Subtree tree.
	 * 
	 * @param position
	 *            as iterator<Boolean>
	 * @param tree
	 *            a Tree
	 */
	public void replace(Iter<Boolean> position, Tree<? extends T> tree) {

		if (this.root == null)
			return;

		Node sub = createSubTree(tree.root);

		Node n = this.root;
		Node parent = null;
		Boolean direction = null;

		// there is min one position
		while (position.hasNext()) {

			// If Parent of the next Node is null, we can abort
			if (n == null)
				return;

			parent = n;
			direction = position.next();
			if (!direction) {
				n = n.left;
			} else {
				n = n.right;
			}
		}

		// check a second time, if parent is null
		if (parent == null)
			return;
		else {
			// depending of the last direction, set new tree left or right
			if (!direction) {
				parent.left = sub;
			} else {
				parent.right = sub;
			}
			sub.parent = parent;
			setDepth(this.root);
		}

	}

	/**
	 * Creates a Subtree with Node type T
	 * 
	 * @param n 
	 * @return rootNode
	 */
	private Node createSubTree(Tree<? extends T>.Node n) {

		if (n != null) {
			Node node = new Node(n.element);

			node.left = createSubTree(n.left);
			node.right = createSubTree(n.right);
			return node;
		} else
			return null;
	}

}
