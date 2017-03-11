package org.shweta.tree;

import java.util.Stack;

public class LevelSpiralOrder {
	
	Node root;
	
	public static void main(String[] args) {
		LevelSpiralOrder tree = new LevelSpiralOrder();
		tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
    	tree.root.right.left= new Node(6);
    	tree.root.right.right= new Node(7);
    	System.out.println("Level spiral order traversal of binary tree is ");
    	tree.printLevelSpiralOrder();

	}
	
	void printLevelSpiralOrder(){
		if(root == null) return;
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");
				
				if(temp.right!=null)
					s2.push(temp.right);
				if(temp.left!=null)
					s2.push(temp.left);				
			}
			
			while(!s2.isEmpty()){
				Node temp = s2.peek();
				s2.pop();
				System.out.print(temp.data + " ");
				
				if(temp.left != null)
					s1.push(temp.left);
				if(temp.right != null)
					s1.push(temp.right);
			}			
		}
		
	}
	
	int height(Node node){
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		
		return 1 + ((lheight > rheight) ? lheight : rheight); 
	}

}
