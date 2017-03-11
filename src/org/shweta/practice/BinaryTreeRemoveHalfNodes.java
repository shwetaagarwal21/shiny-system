package org.shweta.practice;

public class BinaryTreeRemoveHalfNodes {

	TreeNode root;
	
	public static void main(String[] args) {
		BinaryTreeRemoveHalfNodes tree = new BinaryTreeRemoveHalfNodes();
		tree.createSampleTree();
		tree.removeHalfNodes();
		tree.traverseInOrderRec();
	}
	
	void removeHalfNodes(){
		removeHalfNodes(root);
	}
	
	TreeNode removeHalfNodes(TreeNode node){
		if(node == null) return null;
		
		node.left = removeHalfNodes(node.left);
		node.right = removeHalfNodes(node.right);
		
		if(node.left == null && node.right != null)
			return node.right;
		
		if(node.left != null && node.right == null)
			return node.left;
		
		return node;		
	}
	
	void createSampleTree(){
		root = new TreeNode(2, new TreeNode(7, null, new TreeNode(6, new TreeNode(1), new TreeNode(11))), new TreeNode(5, null, new TreeNode(9, new TreeNode(4))));
	}
	
	void traverseInOrderRec(){
		traverseInOrderRec(root);
	}
	
	void traverseInOrderRec(TreeNode node){
		if(node == null)
			return;
		traverseInOrderRec(node.left);
		System.out.print(node.data + " ");		
		traverseInOrderRec(node.right);
	}

}
