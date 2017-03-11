package org.shweta.tree;

public class BinaryTreeDFTraversal {

	Node root;
	 
    public BinaryTreeDFTraversal()
    {
        root = null;
    }
	
	public static void main(String[] args) {
		BinaryTreeDFTraversal tree = new BinaryTreeDFTraversal();
    	tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
        
    	System.out.println("\nInorder traversal of binary tree is ");
    	tree.printInorder();
    	
    	System.out.println("\nPreorder traversal of binary tree is ");
    	tree.printPreorder();
    	
    	System.out.println("\nPostorder traversal of binary tree is ");
    	tree.printPostorder();

	}
	
	void printInorder(){
		printInorder(root);
	}
	
	void printInorder(Node node){
		if(node == null)
			return;
		
		printInorder(node.left);
		
		System.out.print(node.data + " ");
		
		printInorder(node.right);		
	}
	
	void printPreorder(){
		printPreorder(root);
	}
	
	void printPreorder(Node node){
		if(node == null)
			return;
		
		System.out.print(node.data + " ");
		
		printPreorder(node.left);
		printPreorder(node.right);
		
	}
	
	void printPostorder(){
		printPostorder(root);
	}
	
	void printPostorder(Node node){
		if(node == null)
			return;
		
		printPostorder(node.left);
		printPostorder(node.right);
		
		System.out.print(node.data + " ");
	}

}
