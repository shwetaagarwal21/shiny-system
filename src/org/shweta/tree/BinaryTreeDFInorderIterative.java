package org.shweta.tree;

import java.util.Stack;

public class BinaryTreeDFInorderIterative {

	Node root;
	 
    public BinaryTreeDFInorderIterative()
    {
        root = null;
    }
	
	public static void main(String[] args) {
		BinaryTreeDFInorderIterative tree = new BinaryTreeDFInorderIterative();
    	tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
        
    	System.out.println("\nInorder traversal of binary tree is ");
    	tree.printInorder();
	}
	
	void printInorder(){
		if(root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		
		while(node!=null){
			stack.push(node);
			node = node.left;
		}
		
		while(stack.size() > 0){
			node = stack.pop();
			System.out.print(node.data + " ");
			if(node.right!=null){
				node = node.right;
				while(node!=null){
					stack.push(node);
					node = node.left;
				}
			}
		}
		
	}

}
