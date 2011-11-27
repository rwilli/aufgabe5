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
	
	public TreeIter<T> iterator() {
		return null;
	}
	
	public abstract Iter<Boolean> search(T element);
	
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
				return lstNodes.first(); //???
			
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
		
		public TreeIter<T> iterator() {
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
			
			return new TreeIterImp();
		}
		
	}
}
