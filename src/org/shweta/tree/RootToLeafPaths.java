package org.shweta.tree;

public class RootToLeafPaths {
	
	Node root;

	public static void main(String[] args) {
		RootToLeafPaths tree = new RootToLeafPaths();
		tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
    	
    	System.out.println("\nInorder traversal of binary tree is ");
    	tree.printInorder();
    	System.out.println();
    	System.out.println("Root to Leaf Path is :: ");
    	tree.printPaths();
	}
	
	void printPaths(){
		int path[] = new int[1000];
		printPathsRec(root, path, 0);
	}
	
	void printPathsRec(Node node, int path[], int pathLen){
		if(node == null)
			return;
		
		path[pathLen] = node.data;
		pathLen++;
		
		if(node.left == null && node.right == null)
			printArray(path, pathLen);
		else{
			printPathsRec(node.left, path, pathLen);
			printPathsRec(node.right, path, pathLen);
		}		
	}
	
	void printArray(int path[], int pathLen){
		for(int i=0;i<pathLen;i++)
			System.out.print(path[i] + " ");
		System.out.println();
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
