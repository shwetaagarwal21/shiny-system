package org.shweta.practice;

import java.util.Arrays;

public class BinaryTreeToBST {
	
	TreeNode root;
	final int treeSize = 9;

	public static void main(String[] args) {
		BinaryTreeToBST tree = new BinaryTreeToBST();
		tree.createSampleTree();
		tree.changeTreeToBST();

	}
	
	void changeTreeToBST(){
		int[] inorder = new int[treeSize];
		int[] index = new int[1];
		createInOrderArray(root, inorder, index);
		Arrays.sort(inorder);
		index[0] = 0;
		changeNodeValues(root, inorder, index);
	}
	
	void createInOrderArray(TreeNode node, int[] inorder, int[] index){
		if(node == null) return;
		createInOrderArray(node.left, inorder, index);
		inorder[index[0]] = node.data;
		index[0]++;
		createInOrderArray(node.right, inorder, index);
	}
	
	void changeNodeValues(TreeNode node, int[] inorder, int[] index){
		if(node == null) return;
		changeNodeValues(node.left, inorder, index);
		node.data = inorder[index[0]];
		index[0]++;
		changeNodeValues(node.right, inorder, index);
	}
	
	void createSampleTree(){
		root = new TreeNode(0, new TreeNode(1, new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))), new TreeNode(4)), new TreeNode(2, new TreeNode(5, null, new TreeNode(7))));
	}

}
