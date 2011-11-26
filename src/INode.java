/**
 * Interface INode implements all necessary
 * node methods for a tree
 * 
 * @author Gruppe222
 *
 */
public interface INode {
	
	/**
	 * Getter Label
	 * 
	 * @return label of the node
	 */
	public Object getLabel();
	
	/**
	 * Setter Label
	 * 
	 * @param o label to set
	 */
	public void setLabel(Object o);
	
	/**
	 * Getter ParentNode
	 * 
	 * @return parent node
	 */
	public INode getParentNode();
	
	/**
	 * Setter ParentNode
	 * 
	 * @param n parent node to set
	 */
	public void setParentNode(INode n);
	
	/**
	 * Getter LeftNode
	 * 
	 * @return left child node
	 */
	public INode getLeftNode();
	
	/**
	 * Setter LeftNode
	 * 
	 * @param n node to set as left child
	 */
	public void setLeftNode(INode n);
	
	/**
	 * Getter RightChild
	 * 
	 * @return right child node
	 */
	public INode getRightNode();
	
	/**
	 * Setter RightChild
	 * 
	 * @param n node to set as right child
	 */
	public void setRightNode(INode n);
	
	/**
	 * Getter DepthNode
	 * 
	 * @return depth
	 */
	public int getDepthNode();
	
	
	/**
	 * Setter for node's depth
	 * @param d
	 * @throws IllegalValueException if the value is < 0.
	 */
	public void setDepthNode(int d) throws IllegalValueException;
	
	/**
	 * toString method
	 * 
	 * @return the node as String
	 */
	public String toString();
	
}
