package org.shweta.tree;

public class BinaryTreeMirror {
	
	Node root;
	 
    public BinaryTreeMirror()
    {
        root = null;
    }
	
	public static void main(String[] args) {
		BinaryTreeMirror tree = new BinaryTreeMirror();
    	tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
    	
    	System.out.println("\nInorder traversal of binary tree is ");
    	tree.printInorder();
    	
    	tree.mirror();
    	System.out.println("\nInorder traversal of mirror binary tree is ");
    	tree.printInorder();
    	
	}
	
	void mirror(){
		root = mirror(root);
	}
	
	Node mirror(Node node){
		
		if (node == null)
            return node;
		
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		return node;
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
	
}
