package org.shweta.practice;

public class DiameterBinaryTree {
	
	TreeNode root;

	public static void main(String[] args) {
		DiameterBinaryTree tree = new DiameterBinaryTree();
		tree.createSampleTree();
		System.out.println("The diameter of the given binary tree is :: " + tree.diameter());
		System.out.println("The diameter of the given binary tree using 2nd approach is :: " + tree.diameter2());
	}
	
	public void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
	}
	
	int height(TreeNode node){
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return (Math.max(lheight, rheight) + 1);
	}
	
	int diameter(){
		return diameter(root);
	}
	
	int diameter(TreeNode root){
		if(root == null)
			return 0;
		
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
	
	class Height{
		int h;
	}
	
	int diameter2(){
		Height height = new Height();
		return diameterOpt(root, height);
	}
	
	int diameterOpt(TreeNode root, Height height){
		Height lh = new Height();
		Height rh = new Height();
		
		if(root == null){
			height.h = 0;
			return 0;
		}
		
		lh.h++;
		rh.h++;
		int ldiameter = diameterOpt(root.left, lh);
		int rdiameter = diameterOpt(root.right, rh);
		height.h = Math.max(lh.h, rh.h) + 1;
		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));		
	}

}
