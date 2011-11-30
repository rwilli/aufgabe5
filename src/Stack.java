/**
 * Stack represents a stack
 * 
 * @author Gruppe222
 * 
 */
public class Stack<T> {
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
	 * Return true if stack is empty, otherwise return false
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
	 * @param item
	 *            to store
	 */
	public void push(T item) {
		StackNode oldfirst = this.first;
		this.first = new StackNode();
		this.first.item = item;
		this.first.next = oldfirst;
		this.size++;
	}

	/**
	 * Pop item from stack
	 * 
	 * @return node
	 */
	public T pop() {
		if (this.isEmpty())
			return null;

		T item = this.first.item;
		this.first = this.first.next;
		this.size--;

		return item;
	}

	/**
	 * Inner class StackNode represents an Item of type T in a stack.
	 * 
	 * @author Gruppe222
	 * 
	 */
	protected class StackNode {
		// item to store
		protected T item;

		// next stack element
		protected StackNode next;

		/**
		 * default constructor
		 */
		public StackNode() {

		}

	}

}
