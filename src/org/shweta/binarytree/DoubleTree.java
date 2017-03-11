package org.shweta.binarytree;

public class DoubleTree {
	
	TreeNode root;

	public static void main(String[] args) {
		DoubleTree tree = new DoubleTree();
		tree.createSampleTree();
		System.out.println("Inorder traversal of binary tree is :: ");
		tree.traverseInorderRec(tree.root);
		System.out.println();
		System.out.println("Double binary tree in inorder traversal is :: ");
		tree.doubleTree(tree.root);
		tree.traverseInorderRec(tree.root);
	}
	
	public void doubleTree(TreeNode root){
		if(root == null)
			return;
		
		TreeNode oldLeft;
		
		doubleTree(root.left);
		doubleTree(root.right);
		
		oldLeft = root.left;
		root.left = new TreeNode(root.data);
		root.left.left = oldLeft;
		
	}
	
	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
	}
	void traverseInorderRec(TreeNode node){
		if(node == null)
			return;
		traverseInorderRec(node.left);
		System.out.print(node.data + " ");
		traverseInorderRec(node.right);
	}
}
