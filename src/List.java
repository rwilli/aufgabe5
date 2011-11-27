
public class List<T> {
	protected ListNode head = null;
	protected ListNode tail = null;
	
	public void add(T element) {
		if (head == null)
			tail = head = new ListNode(element);
		else
			tail = tail.next = new ListNode(element);
	}
	
	public Iter<T> iter() {
		return new ListIter();
	}
	
	protected class ListNode {
		private T data;
		private ListNode next = null;
		
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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasNext() {
			return n != null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		/*public T next() {
			if (p == null)
				return null;
			
			T data = p.data;
			p = p.next;
			
			return data;
		}

		public boolean hasNext() {
			return p != null;
		}*/
		
		

	}
}
