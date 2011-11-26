import java.util.Scanner;



public class Replaceable {
	public void replace(INode root, String position, String subtree) {
		
		if(root == null)
			return;
//		System.out.println("Position:  " + position);
//		System.out.println("Subtree:  " + subtree);
		
		
		Scanner s = new Scanner(position);
		INode n	= root;
		
		while(s.hasNext()){
			String temp = s.next();
			if(temp.contains("left")){
				n = n.getLeftNode();
			}else{
				n = n.getRightNode();
			}
		}
		
		INode parent = n.getParentNode();
		
		n = createTree(subtree);
//		n.setParentNode(parent);
	//TODO ich kann ja kein neuen REAPLACABLE TREE erstellen hier 
		StringTree t = new ReplaceableTree(n);
		System.out.println("New SubTree:   " + t.toString());
		
	
		
	}
	
	private INode createTree(String subtree) {
		
	//	System.out.println("Subtree in Create:\n" + subtree);

		if(subtree.isEmpty())
			return null;
		
		Scanner sc = new Scanner(subtree);
		String s = sc.nextLine();
//		System.out.println("Before depth:" + s);

		int depth = s.length()-1;
		
		String leftTree= getLeftTree(subtree);
//		System.out.println("LeftTree:" + leftTree);
		String rightTree= getRightTree(subtree);
//		System.out.println("Right:" + rightTree);

		
		INode  n = new Node();
		
//		System.out.println("New Label:  " + s.charAt(s.length()-1));

		n.setLabel(s.charAt(s.length()-1));
		
		try {
			n.setDepthNode(depth);
		} catch(IllegalValueException e) {
			e.printStackTrace();
		}
		
		
		if( !leftTree.isEmpty()){

			INode nLeft = createTree(leftTree);
			if(nLeft != null)
				n.setLeftNode(nLeft);
//				System.out.println("LeftNodeLabel:  " + n.getLabel() + "   "  +n.getLeftNode().getLabel());

		}

		if( !rightTree.isEmpty() ){
			//System.out.println("String in Right:  " +s);

			INode nRight = createTree(rightTree);
			if(nRight != null)
				n.setRightNode(nRight);
//				System.out.println("RightNodeLabel:  " + n.getLabel() + "   "  +n.getRightNode().getLabel());

		}
	
		return n;
	}
	
	private String getLeftTree(String subtree){
	//	System.out.println("getLeftTree:" +subtree);
		String leftTree="";	
		Scanner sc = new Scanner(subtree);
		String s = sc.nextLine();

		int depth = s.length();
		boolean flag = false;
	//	System.out.println("leftTREEdepth:" + depth);

		while( sc.hasNextLine()  ){
			
			String temp = sc.nextLine();
			if(temp.length() == depth+1) flag = !flag;
			if(!flag)break;
	//		System.out.println("leftTREETemp:" + temp);

			if(temp.length() > depth ){
				leftTree +=temp+"\n";
			}
		}
		
		return leftTree;
	}
	private String getRightTree(String subtree){
		//System.out.println("getRightTree:" +subtree);
		String rightTree="";	
		Scanner sc = new Scanner(subtree);
		String s = sc.nextLine();

		int depth = s.length();
		if(sc.hasNextLine())sc.nextLine();
		boolean flag = false;
	//	System.out.println("rightTREEdepth:" + depth);
		String temp = "";
		while( sc.hasNextLine()  ){
			
			 temp = sc.nextLine();
			if(temp.length() == depth+1) flag = !flag;
			if(flag)break;
		//	System.out.println("rightTREETemp:" + temp);
		}
	
		while( !temp.isEmpty() ){
		//	System.out.println("rightTREETemp222:" + temp);
				rightTree +=temp+"\n";
				if(sc.hasNextLine()) 
					temp = sc.nextLine();
				else 
					break;

		}
		
		return rightTree;
	}

}
