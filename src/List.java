/**
 * 
 * @author Gruppe222
 *
 */
public class List<T> {
	/**
	 * Attribut aktuelles Element.
	 */
	private ListNode current;
 
	/**
	 * Attribut erstes Element der Liste
	 */
	private ListNode first;
 
	/**
	 * Attribut letztes Element der Liste.
	 */
	private ListNode last;
	/*protected ListNode head = null;
	protected ListNode tail = null;
	
	public void add(T element) {
		if (head == null)
			tail = head = new ListNode(element);
		else {
			// TODO previous is not working
			tail.previous = tail = tail.next = new ListNode(element);
		}
	}*/
	
	public void add(T element)
	{
		ListNode newElement;
			if (this.isEmpty())
			{// Erstes und einziges Element in die Liste einfügen
				newElement = new ListNode(element, null, null); //(pObject, null, null);
				this.first = newElement;
				this.last = newElement;
				this.current = null;
			}
			else
			{ // Die Liste ist nicht leer
				newElement = new ListNode(element, null, this.first); //pObject, null, this.first);
					this.first.previous = newElement;
					this.first = newElement;
					this.current = null;
				
				/*else
				{	// Der Positionszeiger steht mitten in der Liste.
					newElement = new ListNode(element, this.current, this.current.next);
					if (this.current == this.last)
					{ // Nachfolger existiert nicht - Schwanzzeiger korregieren
						this.last = newElement;
					}
					else
					{ // Nachfolger korregieren
						this.current.next.previous = newElement; //.getNext().setPrevious(newElement);
					}
					// Vorgänger koregieren
					this.current.next = newElement; //setNext(newElement);
					// Aktuelles Element bleibt aktuelles Element
				}*/
			}
	}
	
	public boolean isEmpty()
	{
		return this.first == null;
	}
	
	public Iter<T> iter() {
		return new ListIter();
	}
	
	protected class ListNode {
		private T data;
		private ListNode next = null;
		private ListNode previous = null;
		
		ListNode(T data, ListNode prev, ListNode next) {
			this.data = data;
			this.next = next;
			this.previous = prev;
		}
		
	}
	
	protected class ListIter implements Iter<T> {
		protected ListNode n = first;

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
