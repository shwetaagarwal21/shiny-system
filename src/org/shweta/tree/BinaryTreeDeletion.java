package org.shweta.tree;

public class BinaryTreeDeletion {
	
	Node root;
	 
    public BinaryTreeDeletion()
    {
        root = null;
    }
	
	public static void main(String[] args) {
		BinaryTreeDeletion tree = new BinaryTreeDeletion();
    	tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
    	
    	tree.deleteTree(tree.root);
    	tree.root = null;
    	System.out.println("Tree is deleted");
	}
	
	void deleteTree(Node node){
		if(node == null)
			return;
		deleteTree(node.left);
		deleteTree(node.right);
		System.out.println("The deleted node is " + node.data);
		node = null;
		
	}
	
}
