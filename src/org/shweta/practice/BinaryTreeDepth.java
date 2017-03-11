package org.shweta.practice;

public class BinaryTreeDepth {
	
	class Level{
		int maxlevel = 0;
	}
	
	TreeNode root;
	TreeNode result;

	public static void main(String[] args) {
		BinaryTreeDepth tree = new BinaryTreeDepth();
		tree.createSampleTree();
		tree.deepestLeftLeaf(tree.root);
		if(tree.result!=null){
			System.out.println("Deepest left child in the tree is :: " + tree.result.data);
		}else{
			System.out.println("There is no left leaf in the tree");		}

	}
	
	void deepestLeftLeaf(TreeNode node){
		Level level = new Level();
		deepestLeftLeafUtil(node, 0, level, false);
	}
	
	void deepestLeftLeafUtil(TreeNode node, int lvl, Level level, boolean isLeft){
		if(node == null) return;
		if(isLeft && node.left == null && node.right == null && lvl > level.maxlevel){
			result = node;
			level.maxlevel = lvl;			
		}
		deepestLeftLeafUtil(node.left, lvl+1, level, true);
		deepestLeftLeafUtil(node.right, lvl+1, level, false);
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(3, new TreeNode(5, null, new TreeNode(7, new TreeNode(9))), new TreeNode(6, null, new TreeNode(8, null, new TreeNode(10)))));
	}
	
	boolean isLeaf(TreeNode node){
		return (node.left == null && node.right == null)? true : false;
	}
	
}
