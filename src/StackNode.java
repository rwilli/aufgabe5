/**
 * StackNode reperesents a node on the stack
 * 
 * @author Gruppe222
 *
 */
public class StackNode {
	// item to store
	private INode item;
	
	// next stack element
	private StackNode next;
	
	/**
	 * default constructor
	 */
	public StackNode() {
		
	}
	
	/**
	 * Getter item
	 * 
	 * @return the item
	 */
	public INode getItem() {
		return item;
	}
	
	/**
	 * Setter item
	 * 
	 * @param item the item to set
	 */
	public void setItem(INode item) {
		this.item = item;
	}
	
	/**
	 * Getter next
	 * 
	 * @return the next
	 */
	public StackNode getNext() {
		return next;
	}
	
	/**
	 * Setter next
	 * 
	 * @param next the next to set
	 */
	public void setNext(StackNode next) {
		this.next = next;
	}
	
}
