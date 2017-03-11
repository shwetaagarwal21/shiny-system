package org.shweta.binarytree;

public class RootToLeafPathsEqualToNumber {
	
	TreeNode root;
	
	public static void main(String[] args) {
		RootToLeafPathsEqualToNumber tree = new RootToLeafPathsEqualToNumber();
		tree.createSampleTree();
		int sum = 21;
		if(tree.hasPathSum(tree.root, sum))
			System.out.println("There is a root to leaf path with sum " + sum);
		else
			System.out.println("There is no root to leaf path with sum " + sum);
	}
	
	boolean hasPathSum(TreeNode node, int sum){
		if(node == null)
			return (sum == 0);
		else{
			boolean ans = false;
			int subsum = sum - node.data;
			if(subsum == 0 && node.left == null && node.right == null)
				return true;
			if(node.left!=null)
				ans = ans || hasPathSum(node.left, subsum);
			if(node.right!=null)
				ans = ans || hasPathSum(node.right, subsum);
			return ans;
		}		
	}
	
	void createSampleTree(){
		root = new TreeNode(10, new TreeNode(8, new TreeNode(3), new TreeNode(5)), new TreeNode(2, new TreeNode(2)));
	}

}
