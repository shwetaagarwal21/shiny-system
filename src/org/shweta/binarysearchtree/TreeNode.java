package org.shweta.binarysearchtree;

public class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(){
		super();
	}
	
	TreeNode(int d){
		super();
		this.data = d;
		this.left = this.right = null;
	}
	
	TreeNode(int d, TreeNode left, TreeNode right){
		super();
		this.data = d;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString(){
		return data + "";
	}
}
