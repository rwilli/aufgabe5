
public class List<T> {
	protected ListNode head = null;
	protected ListNode tail = null;
	
	public void add(T element) {
		if (head == null)
			tail = head = new ListNode(element);
		else
			tail = tail.next = new ListNode(element);
	}
	
	protected class ListNode {
		private T data;
		private ListNode next = null;
		
		ListNode(T data) {
			this.data = data;
		}
		
	}
	
	protected class ListIter {
		protected ListNode p = head;

		public T next() {
			if (p == null)
				return null;
			
			T data = p.data;
			p = p.next;
			
			return data;
		}

		public boolean hasNext() {
			return p != null;
		}

	}
}
