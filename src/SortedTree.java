/**
 * Abstract class SortedTree extends StringTree and
 * represents a binary tree. The left nodes are smaller
 * than the right ones and the right nodes are equal or
 * taller then the left ones.
 * 
 * @author Gruppe222
 *
 */
public abstract class SortedTree extends StringTree {
	// current node
	private INode currentNode;

	// current search path
	private String currentPath;
	
	// tree order output
	protected String order = "";

	/**
	 * Traverse method
	 * 
	 * @return result of traverse method whitespace-seperated
	 */
	public abstract String traverse();

	/*
	 * (non-Javadoc)
	 * @see StringTree#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String node) {
		return search(node).equals("Knoten wurde nicht gefunden") ? false: true;
	}

	/*
	 * (non-Javadoc)
	 * @see StringTree#search(java.lang.String)
	 */
	@Override
	public String search(String node) {
		currentNode = this.root;
		currentPath = this.searchPath;
		
		while (currentNode != null && !currentNode.getLabel().equals(node)) {  
			if (node.compareTo((String) currentNode.getLabel()) < 0) {
				currentNode = currentNode.getLeftNode();
				currentPath += "left ";
			} else {
				currentNode = currentNode.getRightNode();
				currentPath += "right ";
			}
		}
		
		return currentNode == null ? "Knoten wurde nicht gefunden" : currentPath;
	}

	/*
	 * (non-Javadoc)
	 * @see StringTree#add(java.lang.String)
	 */
	@Override
	public void add(String node) {
		if (this.root == null && node != null) {
	        this.root = new Node(node);
	        
	        // depth >= 0.
	        try {
				this.root.setDepthNode(0);
			} catch (IllegalValueException e) {
				e.printStackTrace();
			}
	        this.root.setParentNode(null);
	        
		} else if (node != null) {
	        this.root = insert(this.root, node);
			setDepth(this.root);
		}
	}

	/**
	 * Insert new node with given label in the tree
	 * 
	 * @param root root node of the tree
	 * @param label to be stored in the node
	 * @return new root node with child nodes
	 */
	private INode insert(INode root, String label) {
		if (root == null)
			root = new Node(label);
		// left side
		else if (label.compareTo((String) root.getLabel()) < 0 ) {
			root.setLeftNode(insert(root.getLeftNode(), label));
			root.getLeftNode().setParentNode(new Node(root.getLabel()));
		// right side
		} else if (label.compareTo((String) root.getLabel()) >= 0 ) {
	    	root.setRightNode(insert(root.getRightNode(), label));
	    	root.getRightNode().setParentNode(new Node(root.getLabel()));
		}
		return root;
	} 

}
