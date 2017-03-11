package org.shweta.practice;

public class BinaryTreeMaxSumPathLeaves {
	class Res{
		int val;
	}
	TreeNode root;
	public static void main(String[] args) {
		BinaryTreeMaxSumPathLeaves tree = new BinaryTreeMaxSumPathLeaves();
		tree.createSampleTree();
		System.out.println(tree.maxPathSum(tree.root));
	}
	
	int maxPathSum(TreeNode node){
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		maxPathSumUtil(node, res);
		return res.val;
	}
	
	int maxPathSumUtil(TreeNode node, Res res){
		if(node == null) return 0;
		if(node.left == null && node.right == null) return node.data;
		int ls = maxPathSumUtil(node.left, res);
		int rs = maxPathSumUtil(node.right, res);
		if(node.left != null && node.right != null){
			res.val = Math.max(res.val, ls+rs+node.data);
			return Math.max(ls,rs) + node.data;
		}
		return node.left == null ? rs + node.data : ls +node.data;		
	}

	void createSampleTree(){
		root = new TreeNode(-15, new TreeNode(5, new TreeNode(-8, new TreeNode(2), new TreeNode(6)), new TreeNode(1)), new TreeNode(6, new TreeNode(3), new TreeNode(9, null, new TreeNode(0, new TreeNode(4), new TreeNode(-1, new TreeNode(10))))));
	}
}
