/**
 * 
 * @author Gruppe222
 *
 */
public class List<T> {
	protected ListNode head = null;
	protected ListNode tail = null;
	
	public void add(T element) {
		if (head == null)
			tail = head = new ListNode(element);
		else {
			// TODO previous is not working
			tail.previous = tail = tail.next = new ListNode(element);
			
		}
	}
	
	public Iter<T> iter() {
		return new ListIter();
	}
	
	protected class ListNode {
		private T data;
		private ListNode next = null;
		private ListNode previous = null;
		
		ListNode(T data) {
			this.data = data;
		}
		
	}
	
	protected class ListIter implements Iter<T> {
		protected ListNode n = head;

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
			
			n = n.previous;
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
}
