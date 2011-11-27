
public class List<T> {
	private ListNode head = null;
	private int size = 0;
	
	public void add(T element) {
		ListNode old = this.head;
		this.head = new ListNode(element);
		this.head.next = old;
		
		this.size++;
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
	}
	
	protected class ListIter {
		protected ListNode n = head;

		public T next() {
			if (n == null)
				return null;
			
			T data = n.data;
			n = n.next;
			
			return data;
		}

		public boolean hasNext() {
			return n != null;
		}

	}
}
