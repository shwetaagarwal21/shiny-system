package org.shweta.binarytree;

public class PostOrderTraversal {
	
	TreeNode root;
	
	public static void main(String[] args) {
		PostOrderTraversal tree = new PostOrderTraversal();
		tree.createSampleTree();
		tree.printPostOrder();

	}
	
	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
	}
	
	public void printPostOrder(){
		printPostOrder(root);
	}
	
	public void printPostOrder(TreeNode root){
		if(root == null)
			return;
		
		printPostOrder(root.left);
		printPostOrder(root.right);
		
		System.out.print(root.data + " ");
	}

}
