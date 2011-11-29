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
	//public abstract TreeIter<T> contains(T element);
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

	public abstract Iter<Boolean> search(T element);

	public abstract void add(T element);

	public abstract TreeIter<T> iterator();
	
	public abstract Tree<T> clone();

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


	protected class Node {
		protected T element;
		protected Node left;
		protected Node right;
		protected Node parent;
		protected int depth;

		Node(T element) {
			this.element = element;
		}
		Node(T element, Node left, Node right){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
		 public Node deepCopy() { //recursive!
			 
			 return new Node(element,left.deepCopy(),right.deepCopy());
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
		
		public TreeIterImp(List<Node> sectionBeamList) {
			this.iter = sectionBeamList.iter();
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
					return new TreeIterImp(sectionBeamList);
				}
				current = n;
				
			}
			sectionBeamList.add(current);
			
			while (hasNext()) {
				sectionBeamList.add(iter.next());
			}
			
			return new TreeIterImp(sectionBeamList);
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
}
