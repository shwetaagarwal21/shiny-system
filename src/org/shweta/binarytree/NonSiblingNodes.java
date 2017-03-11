package org.shweta.binarytree;

public class NonSiblingNodes {
	
	TreeNode root;
	
	public static void main(String[] args) {
		NonSiblingNodes tree = new NonSiblingNodes();
		tree.createSampleTree();
		tree.printNonSiblingNodes();
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
	
	public void printNonSiblingNodes(){
		printNonSiblingNodes(root);
	}
	
	public void printNonSiblingNodes(TreeNode root){
		if(root == null) return;
		if(root.left==null && root.right!=null)
			System.out.print(root.right.data + " ");
		if(root.left!=null && root.right==null)
			System.out.print(root.left.data + " ");
		printNonSiblingNodes(root.left);
		printNonSiblingNodes(root.right);
	}
}
