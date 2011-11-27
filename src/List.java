
public class List<T> {
	private ListNode head = null;
	
	public void add(T element, ListIter iter) {
		if (iter != null && iter.current != null)
			iter.current.next = new ListNode(element, iter.current.next);
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean remove(T element) {
		ListNode n = this.head;
		
		if (n.data.equals(element)) {
			this.head = n.next;
			n = null;
			
			this.size--;
			
			return true;
		}
		
		ListNode n2 = n;
		n = n.next;
		
		while (n != null) {
			if (n.data.equals(element)) {
				n2.next = n.next;
				n = null;
				this.size--;
				
				return true;
			}
		}
		
		return false;
	}
	
	protected class ListNode {
		private T data;
		private ListNode next = null;
		
		ListNode(T data) {
			this.data = data;
		}
		
		ListNode(T data, ListNode n) {
			this.data = data;
			this.next = n;
		}
	}
	
	protected class ListIter {
		protected ListNode current;

		public T next() {
			if (current == null)
				return null;
			
			T data = current.data;
			//n = n.next;
			
			return data;
		}

		public boolean hasNext() {
			return current != null;
		}

	}
}
