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
		// TODO Auto-generated method stub
		return null;
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
