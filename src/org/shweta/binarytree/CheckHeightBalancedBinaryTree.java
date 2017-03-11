package org.shweta.binarytree;

class Height{
	int h;
}

public class CheckHeightBalancedBinaryTree {
	
	TreeNode root;

	public static void main(String[] args) {
		CheckHeightBalancedBinaryTree tree = new CheckHeightBalancedBinaryTree();
		tree.createSampleTree();
		if(tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
		
		System.out.println("Another way to test if tree is balanced or not");
		Height height = new Height();
		if(tree.isBalanced(tree.root, height))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8)), new TreeNode(5)), new TreeNode(3));
	}
	
	boolean isBalanced(TreeNode node){
		if(node == null)
			return true;
		
		int lh = height(node.left);
		int rh = height(node.right);
		if(Math.abs(lh-rh) <=1 && isBalanced(node.left) && isBalanced(node.right))
			return true;
		return false;
	}
	
	boolean isBalanced(TreeNode node, Height height){
		if(node == null){
			height.h = 0;
			return true;
		}
		Height lh = new Height();
		Height rh = new Height();
		boolean l = isBalanced(node.left, lh);
		boolean r = isBalanced(node.right, rh);
		int lHeight = lh.h;
		int rHeight = rh.h;
		height.h = (lHeight > rHeight ? lHeight : rHeight) + 1;
		if(Math.abs(lHeight - rHeight) >= 2)
			return false;
		else 
			return l && r;
	}
	
	int height(TreeNode node){
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return (Math.max(lheight, rheight) + 1);
	}

}
