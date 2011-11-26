/**
 * Abstract class Tree.
 * 
 * @author Gruppe222
 *
 */
public abstract class Tree<T extends Comparable<T>> {
	// root node
	protected INode root;

	// tree search path
	protected String searchPath = "";

	// tree order output
	protected String order = "";

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

		return p;
	}

	/**
	 * Use preorder traversal for getting an adequate String representation for
	 * the tree.
	 * 
	 * @param node
	 *            usually the root of the tree.
	 */
	private void preorderTraverseForToString(INode node) {
		if (node == null)
			return;

		this.order += node + "\n";

		// walk trough left sub-tree
		preorderTraverseForToString(node.getLeftNode());
		// walk trough right sub-tree
		preorderTraverseForToString(node.getRightNode());
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
	public void setDepth(INode root) {
		Stack stack = new Stack();

		// depth >= 0.
		try {
			root.setDepthNode(0);
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}
		// push root to the stack
		stack.push(root);

		// walk through every node and set the according depth.
		while (stack.size() > 0) {

			Node temp = (Node) stack.pop();

			if (temp != null) {
				if (temp.getLeftNode() != null) {
					int leftOfTempDepth = temp.getDepthNode() + 1;

					// depth >= 0.
					try {
						temp.getLeftNode().setDepthNode(leftOfTempDepth);
					} catch (IllegalValueException e) {
						e.printStackTrace();
					}
					stack.push(temp.getLeftNode());
				}

				if (temp.getRightNode() != null) {
					int rightOfTempDepth = temp.getDepthNode() + 1;

					// depth >= 0.
					try {
						temp.getRightNode().setDepthNode(rightOfTempDepth);
					} catch (IllegalValueException e) {
						e.printStackTrace();
					}
					stack.push(temp.getRightNode());
				}
			}

		}

	}
}
