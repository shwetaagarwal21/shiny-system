package org.shweta.binarytree;

public class SumLeftLeaves {
	
	TreeNode root;
	
	public static void main(String[] args) {
		SumLeftLeaves tree = new SumLeftLeaves();
		tree.createSampleTree();
		int[] leftLeavesSum = new int[1];
		tree.findLeftLeavesSum(tree.root, leftLeavesSum);
		System.out.println("Left Leaves Sum in the tree is :: " + leftLeavesSum[0]);

	}
	
	public void createSampleTree(){
		root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(8);
		TreeNode n8 = new TreeNode(9);
		TreeNode n9 = new TreeNode(10);
		
		root.left = n1;
		root.right = n2;
		
		n1.left = n3;
		n1.right = n4;
		
		n2.left = n5;
		n2.right = n6;
		
		n3.left = n8;
		n4.left = n7;
		n5.right = n9;		
	}
	
	public void findLeftLeavesSum(TreeNode root, int[]leftLeavesSum){
		if(root == null)
			return;
		if(isLeafNode(root.left)){
			leftLeavesSum[0] += root.left.data;
		}
		findLeftLeavesSum(root.left, leftLeavesSum);
		findLeftLeavesSum(root.right, leftLeavesSum);
	}
	
	private boolean isLeafNode(TreeNode node){
		if(node==null)
			return false;
		if(node.left == null && node.right == null)
			return true;
		return false;
	}

}
