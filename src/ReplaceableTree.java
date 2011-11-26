/**
 * PreplaceableTree class extends StringTree and
 * implements replace method which can be use to
 * replace one sub-tree by another one.
 * 
 * @author Gruppe222
 *
 */
public class ReplaceableTree extends StringTree {
	// current search path
	private String currentPath = "";
	
	// ?????TODO
	Replaceable rp = new Replaceable();

	/**
	 * default constructor
	 */
	public ReplaceableTree() {
		
	}
	
	/**
	 * constructor with root node
	 * 
	 * @param n root node
	 */
	public ReplaceableTree(INode n) {
		this.root = n;
	}
	
	/**
	 * constructor with root node and string label
	 * 
	 * @param n root node
	 * @param l string label
	 */
	public ReplaceableTree(INode n, String l) {
		this.root = n;
		this.root.setLabel(l);
	}
	
	/**
	 * Replace one subtree by another one
	 * 
	 * @param position to subtree, which will be replaced
	 * @param subTree to be inserted
	 */
	public void replace(String position, String subTree) {
		
		rp.replace(this.root, position, subTree);
	}
	
	/*
	 * (non-Javadoc)
	 * @see StringTree#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String node) {
		return search(node).equals("Knoten wurde nicht gefunden") ? false: true;

	}

	/*
	 * (non-Javadoc)
	 * @see StringTree#search(java.lang.String)
	 */
	@Override
	public String search(String node) {
		this.currentPath = this.searchPath;
		
		Stack s = new Stack();
		
		if (this.root != null) 
			s.push(this.root);	
		else 
			return "Knoten wurde nicht gefunden";
		  while ( !s.isEmpty() ) {                  
		        INode n = s.pop();               
		        do {
		        	if(n.getLabel().equals(node)){
		        		INode p = n.getParentNode();
		        		while(p != null){
		        			if(p.getLeftNode() == n)
		        				this.currentPath =  "left "+this.currentPath;
		        			else
		        				this.currentPath =  "right "+this.currentPath;
		        			n = p; 
		        			p = p.getParentNode();
		        		}
		        		return this.currentPath;
		        	}											
		            if (n.getRightNode() != null){       
		            	s.push(n.getRightNode());       
		            }
		            n = n.getLeftNode();               
		        } while (n != null);           
		    }
		  return "Knoten wurde nicht gefunden";
	}

	/*
	 * (non-Javadoc)
	 * @see StringTree#add(java.lang.String)
	 */
	@Override
	public void add(String node) {
		if (this.root == null) {
	        this.root = new Node(node);
	        this.root.setParentNode(null);
	        
	        // depth >= 0.
	        try {
				this.root.setDepthNode(0);
			} catch (IllegalValueException e) {
				e.printStackTrace();
			}
	        
	    } else {
	         
	    	INode n = findPlace(this.root, 0);
	    	INode child = new Node(node);
	    	child.setParentNode(n);
	    	setDepth(this.root);
	    	if(n.getLeftNode() == null){
	    		n.setLeftNode(child);
	    	}else{
	    		n.setRightNode(child);
	    	}
	    	setDepth(this.root);
	    }
	}
	
	/**
	 * 
	 * @param node
	 * @param depth
	 * @return
	 */
	private INode findPlace(INode node, int depth){

		// depth >= 0.
		try {
			node.setDepthNode(depth);
		} catch (IllegalValueException e) {
			e.printStackTrace();
		}
		
		if(node.getLeftNode() ==null || node.getRightNode() == null){
			return node;
		}else{
			depth++;
			INode n1,n2;
			n1 = findPlace(node.getLeftNode(), depth);
			n2 = findPlace(node.getRightNode(), depth);
			
			if(n1.getDepthNode() > n2.getDepthNode())
				return n2;
			else
				return n1;
					
		}	
		
	}
	
}
