/**
 * Abstract class Tree. Tree is a generic type with the type variable T
 * 
 * @author Gruppe222
 * 
 * @param <T>
 *            type variable
 */
public abstract class Tree<T> {
	protected List<Node> child = new List<Node>();
	protected List<Boolean> b = null;
	protected Node root;
	// tree order output
	protected String order = "";

	/**
	 * Checks if a tree contains an element.
	 * 
	 * @param element
	 *            type T
	 * @return a new TreeIter iterating over the found element and the elements
	 *         of the subtree.
	 */
	public TreeIter<T> contains(T element) {
		Iter<Boolean> iter = search(element);
		Node n;

		if (iter != null) {
			n = this.root;

			while (iter.hasNext()) {
				// left sub-tree
				if (iter.next() == false)
					n = n.left;
				// right sub-tree
				else
					n = n.right;
			}
		} else
			return null;

		this.child = new List<Node>();

		inorderTraverse(n);

		return new TreeIterImp();
	}

	/**
	 * Inorder method First root node then walk trough the left sub-tree and
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
	 * Abstract method search should be implemented by subtypes of tree.
	 * Searches an element in a tree.
	 * 
	 * @param element
	 *            type T
	 * @return Iter<Boolean> an Iterator describing the path to the located
	 *         element.
	 */
	public abstract Iter<Boolean> search(T element);

	/**
	 * Abstract method add should be implemented by subtypes of tree. Adds an
	 * element to the tree.
	 * 
	 * @param element
	 *            type T
	 */
	public abstract void add(T element);

	/**
	 * Abstract method iterator should be implemented by subtypes of tree.
	 * Returns an iterator over the tree.
	 * 
	 * @return TreeIter<T> an iterator
	 */
	public abstract TreeIter<T> iterator();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String p = traverseForToString();

		// remove dash in front of root
		if (p.startsWith("-"))
			p = p.substring(1, p.length());

		order = "";
		return p;

	}

	/**
	 * Use preorder traversal for getting an adequate String representation for
	 * the tree.
	 * 
	 * @param node
	 *            commonly the root of the tree.
	 */
	private void preorderTraverseForToString(Node node) {
		if (node == null)
			return;

		this.order += node + "\n";

		// walk trough left sub-tree
		preorderTraverseForToString(node.left);
		// walk trough right sub-tree
		preorderTraverseForToString(node.right);
	}

	/**
	 * Returns the tree as String.
	 * 
	 * @return a string representation of the tree.
	 */
	private String traverseForToString() {
		if (this.root != null)
			preorderTraverseForToString(this.root);

		return this.order;
	}

	/**
	 * Sets the depth for each node of a tree.
	 * 
	 * @param root
	 *            the root has depth 0.
	 */
	protected void setDepth(Node root) {
		Stack<Node> stack = new Stack<Node>();

		root.depth = 0;

		// push root to the stack
		stack.push(root);

		// walk through every node and set the according depth.
		while (stack.size() > 0) {

			Node temp = (Node) stack.pop();

			if (temp != null) {
				if (temp.left != null) {
					int leftOfTempDepth = temp.depth + 1;

					temp.left.depth = leftOfTempDepth;

					stack.push(temp.left);
				}

				if (temp.right != null) {
					int rightOfTempDepth = temp.depth + 1;

					temp.right.depth = rightOfTempDepth;

					stack.push(temp.right);
				}
			}

		}

	}

	/**
	 * Inner class Node represents a node of a tree.
	 * 
	 * @author Gruppe222
	 * 
	 */
	protected class Node {
		protected T element;
		protected Node left;
		protected Node right;
		protected Node parent;
		protected int depth;

		/**
		 * Constructor
		 * 
		 * @param element
		 *            type T
		 */
		Node(T element) {
			this.element = element;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see node.INode#setDepth(int)
		 */
		@Override
		public String toString() {
			return calculateHardspaces(this.depth) + "-" + this.element;
		}

		/**
		 * Calculates the hardspaces to add for the toString method according to
		 * the depth
		 * 
		 * @param depth
		 *            the depth of a node
		 * @return amount of hardspaces
		 */
		private String calculateHardspaces(int depth) {

			String hardspaces = "";
			for (int level = 1; level < depth; level++) {
				hardspaces += " ";
			}
			return hardspaces;
		}

	}

	/**
	 * Inner class TreeIterImp implements TreeIter<T>
	 * 
	 * @author Gruppe222
	 * 
	 */
	protected class TreeIterImp implements TreeIter<T> {
		private Iter<Node> iter = null;
		protected Node current = null;

		/**
		 * Constructor
		 */
		public TreeIterImp() {
			this.iter = child.iter();
		}

		/**
		 * Alternative constructor needed for down method.
		 * 
		 * @param sectionBeamList
		 *            the list of the section beam.
		 */
		public TreeIterImp(List<Node> sectionBeamList) {
			this.iter = sectionBeamList.iter();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#next()
		 */
		@Override
		public T next() {
			Node n = this.iter.next();

			current = n;

			return current.element;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#previous()
		 */
		@Override
		public T previous() {
			Node n = this.iter.previous();

			current = n;

			return current.element;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return this.iter.hasNext();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#hasPrevious()
		 */
		@Override
		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see TreeIter#down()
		 */
		@Override
		public TreeIter<T> down() {

			List<Node> sectionBeamList = new List<Node>();

			if (current == null) {
				Node n = this.iter.next();

				if (n == null) {
					return new TreeIterImp(sectionBeamList);
				}
				current = n;

			}
			sectionBeamList.add(current);

			Node nextNode;
			Node previousNode = current;
			while (hasNext()) {

				nextNode = iter.next();

				if (nextNode.depth >= previousNode.depth) {
					sectionBeamList.add(nextNode);
					previousNode = nextNode;
				} else {
					break;
				}

			}
			return new TreeIterImp(sectionBeamList);
		}

	}

	/**
	 * Inner class SearchIterImp implements the interface Iter<Boolean> and
	 * represents a search Iterator
	 * 
	 * @author Gruppe222
	 * 
	 */
	protected class SearchIterImp implements Iter<Boolean> {
		private Iter<Boolean> iter = null;
		protected Boolean current = null;

		/**
		 * Constructor
		 */
		public SearchIterImp() {
			this.iter = b.iter();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#next()
		 */
		@Override
		public Boolean next() {
			Boolean n = this.iter.next();

			current = n;

			return current;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#previous()
		 */
		@Override
		public Boolean previous() {
			Boolean n = this.iter.previous();

			current = n;

			return current;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return this.iter.hasNext();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see Iter#hasPrevious()
		 */
		@Override
		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}

	}
}
