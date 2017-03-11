package org.shweta.binarytree;

import java.util.Stack;

public class InOrderTraversalIterative {
	
	TreeNode root;
	
	public static void main(String[] args) {
		InOrderTraversalIterative tree = new InOrderTraversalIterative();
		tree.createSampleTree();
		tree.printInOrder();
	}
	
	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
	}
	
	public void printInOrder(){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while(node!=null){
			stack.push(node);
			node = node.left;
		}
		
		while(stack.size()>0){
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
