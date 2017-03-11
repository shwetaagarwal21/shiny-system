package org.shweta.binarytree;

import java.util.Stack;

public class PrePostOrderTraversalIterative {
	
	TreeNode root;
	
	public static void main(String[] args) {
		PrePostOrderTraversalIterative tree = new PrePostOrderTraversalIterative();
		tree.createSampleTree();
		System.out.println("Pre Order Traversal is :: ");
		tree.printPreOrder();
		System.out.println();
		System.out.println("Post Order Traversal is :: ");
		tree.printPostOrder();
	}

	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
	}
	
	public void printPreOrder(){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curr = stack.peek();
			System.out.print(curr.data + " ");
			stack.pop();
			if(curr.right!=null)
				stack.push(curr.right);
			if(curr.left!=null)
				stack.push(curr.left);			
		}		
	}
	
	public void printPostOrder(){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode curr = stack.peek();
			if(isLeaf(curr)){
				TreeNode node = stack.pop();
				System.out.print(node.data + " ");
			}else{
				if(curr.right!=null){
					stack.push(curr.right);
					curr.right = null;
				}
				if(curr.left!=null){
					stack.push(curr.left);
					curr.left = null;
				}
			}
		}		
	}
	
	private boolean isLeaf(TreeNode node){
		return node.left == null && node.right == null ? true : false;
	}
	
}
