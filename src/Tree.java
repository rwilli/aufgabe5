/**
 * Abstract class Tree.
 * 
 * @author Gruppe222
 *
 */
public abstract class Tree<T> {
	protected List<Node> child = new List<Node>();
	protected Node root;
	
	public TreeIter<T> contains(T element) {
		return null;
	}
	
	public TreeIter<T> iterator() {
		return null;
	}
	
	public Iter<Boolean> search(T element) {
		return null;
	}
	
	public abstract void add(T element);
	
	protected class Node {
		protected T element;
		protected Node left;
		protected Node right;
		protected Node parent;
		
		Node(T element) {
			this.element = element;
		}
		
	}
	
	protected class TreeIterImp implements TreeIter<T> {
		private Node current = null;
		private List<Node> lstNodes = new List<Node>(); 
		
		@Override
		public T next() {
			if (this.current == null)
				return null;
			
			T element = this.current.element;
			//this.current = this.current.next;
			
			return element;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasNext() {
			return this.current != null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public TreeIter<T> down() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
