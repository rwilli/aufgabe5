/**
 * Abstract class Tree.
 * 
 * @author Gruppe222
 *
 */
public abstract class Tree<T> {
	protected Node root = null;
	
	
	public boolean contains(T element) {
		return false;
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
	
	protected class TestTreeIter implements TreeIter<T> {
		protected Node current = null;
		
		@Override
		public Iter<T> next() {
			if (this.current == null)
				return null;
			
			return null;
		}

		@Override
		public Iter<T> previous() {
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

		@Override
		public TreeIter<T> down() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
