package org.shweta.practice;

public class BinaryTreeSymmetric {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeSymmetric tree = new BinaryTreeSymmetric();
		tree.createSampleTree();
		System.out.println("Checking if tree is symmetric");
		boolean isSymm = tree.isSymmetric();
		System.out.println("Tree symmetric :: " + isSymm);
	}
	
	boolean isSymmetric(){
		return isMirror(root, root);
	}
	
	boolean isMirror(TreeNode a, TreeNode b){
		if(a == null && b == null) 
			return true;
		else if(a == null || b == null) return false;
		if(a.data == b.data)
			return isMirror(a.left, b.right) && isMirror(a.right, b.left);
		return false;
	}
	
	void createSampleTree(){
		root = new TreeNode(3, new TreeNode(1, new TreeNode(0, new TreeNode(3)), new TreeNode(2, null, new TreeNode(4))), new TreeNode(1, new TreeNode(2, new TreeNode(4)), new TreeNode(0, null, new TreeNode(3))));
		//root = new TreeNode(3, new TreeNode(1, new TreeNode(0, new TreeNode(3)), new TreeNode(2, null, new TreeNode(4))), new TreeNode(1, new TreeNode(0, new TreeNode(3)), new TreeNode(2, null, new TreeNode(4))));
	}

}

