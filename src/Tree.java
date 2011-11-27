/**
 * Abstract class Tree.
 * 
 * @author Gruppe222
 *
 */
public abstract class Tree<T> {
	protected List<Node> child = new List<Node>();
	protected Node root;
	
	public abstract TreeIter<T> contains(T element);
	
	public abstract Iter<Boolean> search(T element);
	
	public abstract void add(T element);
	
	public abstract TreeIter<T> iterator();
		//TODO Baum in Liste konvertieren
		// pro Baum-Level eine Liste erstellen
		/*
		 * List<List<Node> > ol = new ArrayList<List<Node>>();
		build(root,0)
		
		void build (Node node,int level)
		{ 
		if(node==null)
		return;
		List<Node> il;
		if(ol.size() < level){
		il =  new ArrayList<Node>(); 
		}else{
		il= ol.get(level);
		}
		
		il.add(node);
		ol.put(level,il);
		build(node.left, level+1);
		build(node.right,level+1);
		}

		 */
		
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
		private Iter<Node> iter = null;
		protected Node current = null;
		
		public TreeIterImp() {
			this.iter = child.iter();
		}
		
		@Override
		public T next() {
			Node n = this.iter.next();
			
			current = n;
			
			return current.element;
		}

		@Override
		public T previous() {
			Node n = this.iter.previous();
			
			current = n;
			
			return current.element;
		}

		@Override
		public boolean hasNext() {
			return this.iter.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}

		@Override
		public TreeIter<T> down() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	protected class SearchItImp implements Iter<T> {
		private Iter<Node> iter = null;
		protected Node current = null;
		
		public SearchItImp() {
			this.iter = child.iter();
		}
		
		@Override
		public T next() {
			Node n = this.iter.next();
			
			current = n;
			
			return current.element;
		}

		@Override
		public T previous() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasNext() {
			return this.iter.hasNext();
		}

		@Override
		public boolean hasPrevious() {
			return this.iter.hasPrevious();
		}
		
	}
}
