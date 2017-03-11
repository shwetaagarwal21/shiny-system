package org.shweta.practice;

public class CheckBTIsSumTree {
	TreeNode root;
	
	public static void main(String[] args) {
		CheckBTIsSumTree tree = new CheckBTIsSumTree();
		//tree.createSampleTree();
		
		tree.root = new TreeNode(26);
        tree.root.left = new TreeNode(10);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(6);
        tree.root.right.right = new TreeNode(3);
        
		if(tree.isSumTree(tree.root)!=0)
			System.out.println("IS SUM TREE");
		else
			System.out.println("NOT A SUM TREE");
		
	}
	
	void createSampleTree(){
		root = new TreeNode(26, new TreeNode(10, new TreeNode(4, new TreeNode(6)), new TreeNode(3, null, new TreeNode(3))));
	}
	
	int isLeaf(TreeNode n){
		if(n == null) return 0;
		if(n.left == null && n.right == null) return 1;
		return 0;
	}
	
	int isSumTree(TreeNode n){
		if(n == null || (isLeaf(n) == 1)) return 1;
		int ls,rs;		
		if(isSumTree(n.left)!=0 && isSumTree(n.right)!=0){
			if(n.left == null)
				ls = 0;
			else if(n.left.left == null && n.left.right == null)
				ls = n.left.data;
			else
				ls = 2 * n.left.data;
			
			if(n.right == null)
				rs = 0;
			else if(n.right.left == null && n.right.right == null)
				rs = n.right.data;
			else
				rs = 2 * n.right.data;
			
			if(n.data == ls + rs) return 1;
			else
				return 0;
		}
		return 0;
	}
}
