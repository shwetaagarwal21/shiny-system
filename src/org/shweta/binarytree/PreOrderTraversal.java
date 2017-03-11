package org.shweta.binarytree;

public class PreOrderTraversal {
	
	TreeNode root;
	
	public static void main(String[] args) {
		PreOrderTraversal tree = new PreOrderTraversal();
		tree.createSampleTree();
		tree.printPreOrder();
	}
	
	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
	}
	
	public void printPreOrder(){
		printPreOrder(root);
	}
	
	public void printPreOrder(TreeNode root){
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

}
