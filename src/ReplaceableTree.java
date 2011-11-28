import java.util.Scanner;

/**
 * PreplaceableTree class extends StringTree and
 * implements replace method which can be use to
 * replace one sub-tree by another one.
 * 
 * @author Gruppe222
 *
 */
public class ReplaceableTree<T> extends Tree<T> {

	@Override
	public void add(T element) {
		if (this.root == null) {
	        this.root = new Node(element);
	        this.root.parent = null;
	        this.root.depth = 0;
	    } else {    
	    	Node n = findPlace(this.root, 0);
	    	Node child = new Node(element);
	    	child.parent = n;
	    	
	    	setDepth(this.root);
	    	
	    	if(n.left == null){
	    		n.left = child;
	    	}else{
	    		n.right = child;
	    	}
	    	
	    	setDepth(this.root);
	    }
	}

	private Node findPlace(Node node, int depth){

		node.depth = depth;
		
		if (node.left == null || node.right == null) {
			return node;
		}else{
			depth++;
			Node n1,n2;
			n1 = findPlace(node.left, depth);
			n2 = findPlace(node.right, depth);
			
			if(n1.depth > n2.depth)
				return n2;
			else
				return n1;
					
		}	
		
	}
	
	/**
	 * Sets the depth for each node of a tree.
	 * 
	 * @param root
	 *            the root has depth 0.
	 */
	private void setDepth(Node root) {
		Stack<Node> stack = new Stack<Node>();

		root.depth = 0;
		
		// push root to the stack
		stack.push(root);

		// walk through every node and set the according depth.
		while (stack.size() > 0) {

			Node temp = (Node) stack.pop();

			if (temp != null) {
				if (temp.left != null) {
					int leftOfTempDepth = temp.depth + 1;

					temp.left.depth = leftOfTempDepth;
					
					stack.push(temp.left);
				}

				if (temp.right != null) {
					int rightOfTempDepth = temp.depth + 1;

					temp.right.depth = rightOfTempDepth;
					
					stack.push(temp.right);
				}
			}

		}

	}
	
	@Override
	public TreeIter<T> contains(T element) {
		Iter<Boolean> iter = search(element);
		Node n;
		
		if (iter != null) {
			n = this.root;
			
			while (iter.hasNext()) {
				// left sub-tree
				if (iter.next() == false)
					n = n.left;
				// right sub-tree
				else
					n = n.right;
			}
		} else
			return null;
		
		this.child = new List<Node>();
		
		inorderTraverse(n);
		
		return new TreeIterImp();
	}

	@Override
	public Iter<Boolean> search(T element) {
		Stack<Node> s = new Stack<Node>();
		
		if (this.root != null) 
			s.push(this.root);	
		else 
			return null;
		  while ( !s.isEmpty() ) {                  
		        Node n = s.pop();               
		        do {
		        	if (n.element.equals(element)) {
		        		Node p = n.parent;
		        		while (p != null) {
		        			if(p.left == n)
		        				this.b.add(false);
		        			else
		        				this.b.add(true);
		        			n = p; 
		        			p = p.parent;
		        		}
		        		return new SearchIterImp();
		        	}											
		            if (n.right != null){       
		            	s.push(n.right);       
		            }
		            n = n.left;               
		        } while (n != null);           
		    }
		  return null;
	}

	@Override
	public TreeIter<T> iterator() {
		traverse();
		
		return new TreeIterImp();
	}
	
	public void replace(Iter<Boolean> position, Tree<? extends T> tree) {
	
		if(this.root == null)
			return;
		// Kopieren?
		Tree<? extends T> temp = tree
		
		Node n = this.root;
		Node parent = null;
		Boolean direction = null;
		// there is min one position
		while(position.hasNext()){
			
			// If Parent of the next Node is null, we can abort 
			if(n == null)
				return;
			
			parent = n;
			direction = position.next();
			if(!direction){
				n = n.left;
			}else{
				n = n.right;
			}
		}
		
		// check a second time, if parent is null
		if(parent == null)
			return;
		else{
			
			// depending of the last direction, set new tree left or right
			if(!direction){
				parent.left = temp.root;
			}else{
				parent.right = temp.root;
			}
			temp.root.parent = parent;

		}
	
	}
	
	private void traverse() {
		if (this.root != null)
			inorderTraverse(this.root);
	}

	/**
	 * Preorder method
	 * First root node then walk trough the left sub-tree
	 * and then trough the right sub-tree
	 * 
	 * @param node root node
	 */
	private void inorderTraverse(Node node) {
		if (node == null) 
			return;

		inorderTraverse(node.left);	// walk trough left sub-tree
		this.child.add(node);
		inorderTraverse(node.right);	// walk trough right sub-tree
	}
	
}
