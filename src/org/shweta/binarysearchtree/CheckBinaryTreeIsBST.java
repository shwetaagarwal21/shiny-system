package org.shweta.binarysearchtree;

/*
 * Check if Binary Tree is BST or not
 * Solu: Do In-Order Traversal of the given tree, keep track of previously visited node. 
 * If the value of the currently visited node is less than the previous value, then tree is not BST. 
 */
public class CheckBinaryTreeIsBST {
	
	TreeNode root;
	TreeNode prev;
	
	public static void main(String[] args) {
		CheckBinaryTreeIsBST tree = new CheckBinaryTreeIsBST();
		tree.createSampleTree();
		if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");

	}
	
	boolean isBST(){
		prev = null;
		return isBST(root);
	}
	
	boolean isBST(TreeNode node){
		if(node!=null){
			if(!isBST(node.left))
				return false;
			if(prev != null && node.data <= prev.data)
				return false;
			prev = node;
			return isBST(node.right);
		}
		return true;
	}
	
	public void createSampleTree(){
		//root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
	}

}
