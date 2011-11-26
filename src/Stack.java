/**
 * Stack represents a stack
 * 
 * @author Gruppe222
 *
 */
public class Stack {
	// stack size
	private int size;
	
	// first stack element
	private StackNode first;
	
	/**
	 * default constructor
	 */
	public Stack() {
		this.size = 0;
		this.first = null;
	}
	
	/**
	 * Return true if stack is empty,
	 * otherwise return false
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return this.first == null;
	}
	
	/**
	 * Return size of the stack
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Push item on stack
	 * 
	 * @param item to store
	 */
	public void push(INode item) {
		StackNode oldfirst = this.first;
		this.first = new StackNode();
		this.first.setItem(item);
		this.first.setNext(oldfirst);
		this.size++;
	}
	
	/**
	 * Pop item from stack
	 * 
	 * @return node
	 */
	public INode pop() {
		if (this.isEmpty())
			return null;
		INode item = this.first.getItem();
		this.first = this.first.getNext();
		this.size--;
		
		return item;
	}

}
