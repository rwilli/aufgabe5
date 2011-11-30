/**
 * List Container class needed for the node list of a tree.
 * 
 * @author Gruppe222
 * 
 */
public class List<T> {
	private ListNode head = null;
	private ListNode tail = null;
	private int size;

	/**
	 * adds a new Element to the list.
	 * 
	 * @param element
	 *            to add.
	 */
	public void add(T element) {
		if (head == null) {
			head = new ListNode(element);
			tail = new ListNode(element);
			head.next = tail;
			tail.previous = head;
		} else {
			ListNode tmp = new ListNode(element);
			ListNode last = getLast();
			last.next = tmp;
			tmp.previous = last;
		}
		size++;
	}

	/**
	 * returns the last element of the list
	 * 
	 * @return a ListNode being the last element.
	 */
	private ListNode getLast() {
		ListNode tmp = this.head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}

		return tmp;
	}

	/**
	 * creates a new list iterator.
	 * 
	 * @return Iter<T> an iterator.
	 */
	public Iter<T> iter() {
		return new ListIter();
	}

	/**
	 * Inner Class ListNode, represents a node in the list.
	 * 
	 * @author Gruppe222
	 * 
	 */
	protected class ListNode {
		private T data;
		private ListNode next = null;
		private ListNode previous = null;

		ListNode(T data) {
			this.data = data;
		}

	}

	/**
	 * Inner class ListIter implements Iter<T> represents an iterator over the
	 * list.
	 * 
	 * @author Gruppe222
	 * 
	 */
	protected class ListIter implements Iter<T> {
		protected ListNode n = head.next;

		@Override
		public T next() {
			if (n == null)
				return null;

			T data = n.data;
			n = n.next;

			return data;
		}

		@Override
		public T previous() {
			if (n == null)
				return null;

			n = n.previous.previous;
			T data = n.data;

			return data;
		}

		@Override
		public boolean hasNext() {
			return n != null;
		}

		@Override
		public boolean hasPrevious() {
			return n.previous != null;
		}

	}

	/**
	 * returns the current size of the list
	 * 
	 * @return size as integer
	 */
	public int size() {
		return this.size;
	}
}
