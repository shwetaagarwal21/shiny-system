package org.shweta.binarytree;

public class InOrderTraversal {
	
	TreeNode root;
	
	public static void main(String[] args) {
		InOrderTraversal tree = new InOrderTraversal();
		tree.createSampleTree();
		tree.printInOrder();
	}
	
	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
	}
	
	public void printInOrder(){
		printInOrder(root);
	}
	
	public void printInOrder(TreeNode root){
		if(root == null)
			return;
		
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);		
	}
	
}
