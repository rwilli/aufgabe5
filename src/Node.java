/**
 * Node implements INode and
 * stands for a tree node label
 * with Object
 * 
 * @author Gruppe222
 *
 */
public class Node implements INode {
	// parent node
	private INode parent;
	
	// left child node
	private INode left;
	
	// right child node
	private INode right;
	
	// node label
	private Object label;
	
	// node depth
	private int depth;
	
	/**
	 * default constructor
	 */
	public Node() {
		
	}
	
	/**
	 * constructor with label object o
	 * 
	 * @param o object for label
	 */
	public Node(Object o) {
		this.label = o;
	}
	
	/**
	 * constructor with label object o
	 * and parent node p
	 * 
	 * @param o object for label
	 * @param p parent node
	 */
	public Node(Object o, INode p) {
		this.label = o;
		this.parent = p;
	}

	/*
	 * (non-Javadoc)
	 * @see node.INode#getLabel()
	 */
	@Override
	public Object getLabel() {
		return this.label;
	}

	/*
	 * (non-Javadoc)
	 * @see node.INode#setLabel(java.lang.Object)
	 */
	@Override
	public void setLabel(Object o) {
		this.label = o;
	}

	/*
	 * (non-Javadoc)
	 * @see node.INode#getParentNode()
	 */
	@Override
	public INode getParentNode() {
		return this.parent;
	}

	/*
	 * (non-Javadoc)
	 * @see node.INode#setParentNode(node.INode)
	 */
	@Override
	public void setParentNode(INode n) {
		this.parent = n;
	}
	
	/*
	 * (non-Javadoc)
	 * @see node.INode#getLeftNode()
	 */
	@Override
	public INode getLeftNode() {
		return this.left;
	}
	
	/*
	 * (non-Javadoc)
	 * @see node.INode#setLeftNode(node.INode)
	 */
	@Override
	public void setLeftNode(INode n) {
		this.left = n;
	}
	
	/*
	 * (non-Javadoc)
	 * @see node.INode#getRightNode()
	 */
	@Override
	public INode getRightNode() {
		return this.right;
	}
	
	/*
	 * (non-Javadoc)
	 * @see node.INode#setRightNode(node.INode)
	 */
	@Override
	public void setRightNode(INode n) {
		this.right = n;
	}

	/* (non-Javadoc)
	 * @see node.INode#getDepthNode()
	 */
	@Override
	public int getDepthNode() {
		return this.depth;
	}

	/* (non-Javadoc)
	 * @see node.INode#setDepthNode(int)
	 */
	@Override
	public void setDepthNode(int d) throws IllegalValueException {
		if (d < 0) {
			throw new IllegalValueException(d);
		}
		this.depth = d;	
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see node.INode#setDepth(int)
	 */
	@Override
	public String toString() {
		return calculateHardspaces(this.depth) + "-" + this.label;
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
