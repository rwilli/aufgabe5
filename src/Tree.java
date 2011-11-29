/**
 * Abstract class Tree.
 * 
 * @author Gruppe222
 * 
 */
public abstract class Tree<T> {
	protected List<Node> child = new List<Node>();
	protected List<Boolean> b = null;
	protected Node root;
	// tree order output
	protected String order = "";

	
	// evtl hier implementieren
	public abstract TreeIter<T> contains(T element);

	public abstract Iter<Boolean> search(T element);

	public abstract void add(T element);

	public abstract TreeIter<T> iterator();
	
	public abstract Tree<T> clone();


	// TODO Baum in Liste konvertieren
	// pro Baum-Level eine Liste erstellen

	/*
	List<List<Node>> ol = new List<List<Node>>();
	void build(Node node, int level) {
		if (node == null)
			return;
		
		List<Node> il;
		if (ol.size() < level) {
			il = new List<Node>();
		} else {

			// il= ol.get(level);
		}

		il.add(node);
		// ol.put(level,il);
		build(node.left, level + 1);
		build(node.right, level + 1);
	}
	*/
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		String p = traverseForToString();

		// remove dash in front of root
		if (p.startsWith("-"))
			p = p.substring(1, p.length());

		order = "";
		return  p;

	}
	
	/**
	 * Use preorder traversal for getting an adequate String represanation for
	 * the tree.
	 * 
	 * @param node
	 *            usually the root of the tree.
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
	public String traverseForToString() {
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
	public void setDepth(Node root) {
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


	protected class Node {
		protected T element;
		protected Node left;
		protected Node right;
		protected Node parent;
		protected int depth;

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
		 * Calculates the hardspaces to add for the toString method according to the
		 * depth
		 * 
		 * @param depth the depth of a node
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

	protected class TreeIterImp implements TreeIter<T> {
		private Iter<Node> iter = null;
		protected Node current = null;

		public TreeIterImp() {
			this.iter = child.iter();
		}

		@Override
		public T next() {
			Node n = this.iter.next();

			current = n;

			return current.element;
		}

		@Override
		public T previous() {
			Node n = this.iter.previous();

			current = n;

			return current.element;
		}

		@Override
		public boolean hasNext() {
			return this.iter.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}

		@Override
		public TreeIter<T> down() {
			List<Node> sectionBeamList = new List<Node>();
			
			if (current == null) {
				Node n = this.iter.next();

				if (n == null) {
					// return new EmptyIterator();
				}
				current = n;
				
			}
			
			while (iter.hasNext()) {
				
				Node n = iter.next();
				current = n;
				
				sectionBeamList.add(current);
				
			}
			this.iter = sectionBeamList.iter();
			return new TreeIterImp();
		}

	}

	protected class SearchIterImp implements Iter<Boolean> {
		private Iter<Boolean> iter = null;
		protected Boolean current = null;

		public SearchIterImp() {
			this.iter = b.iter();
		}

		@Override
		public Boolean next() {
			Boolean n = this.iter.next();

			current = n;

			return current;
		}

		@Override
		public Boolean previous() {
			Boolean n = this.iter.previous();

			current = n;

			return current;
		}

		@Override
		public boolean hasNext() {
			return this.iter.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}

	}

	// TODO: added EmptyIter, not sure if correct
	protected class EmptyIterImp implements Iter<Boolean> {

		public EmptyIterImp() {
		}

		@Override
		public Boolean next() {
			return null;
		}

		@Override
		public Boolean previous() {
			return null;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

	}
}
