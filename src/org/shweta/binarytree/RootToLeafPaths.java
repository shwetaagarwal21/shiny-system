package org.shweta.binarytree;

import java.util.ArrayList;

class Maximum
{
    int max_no = Integer.MIN_VALUE;
}

public class RootToLeafPaths {
	
	TreeNode root;
	
	public static void main(String[] args) {
		RootToLeafPaths tree = new RootToLeafPaths();
		tree.createSampleTree();
		tree.printRootToLeafPaths();
		System.out.println();
		System.out.println("Max Sum Path in Binary Tree is  " + tree.getMaxSumPath());
		System.out.println("Max Sum Path in Binary Tree using 2nd approach is  " + tree.getMaxSum(tree.root));
	}
	
	private void createSampleTree(){
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
	
	public void printRootToLeafPaths(){
		if(root == null)
			return;
		ArrayList<Integer> path = new ArrayList<Integer>();
		printRootToLeafPaths(root, path);
	}
	
	private void printRootToLeafPaths(TreeNode root, ArrayList<Integer> path){
		path.add(root.data);
		if(root.left == null && root.right == null){
			printList(path);
			return;
		}
		if(root.left != null)
			printRootToLeafPaths(root.left, new ArrayList<Integer>(path));
		if(root.right != null)
			printRootToLeafPaths(root.right, new ArrayList<Integer>(path));
	}
	
	private void printList(ArrayList<Integer> path){
		for(Integer i: path){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	int getMaxSumPath(){
		Maximum max = new Maximum();
		ArrayList<Integer> path = new ArrayList<Integer>();
		getMaxSumPath(root, path, max);
		return max.max_no;
	}
	
	void getMaxSumPath(TreeNode root, ArrayList<Integer> path, Maximum max){
		path.add(root.data);
		if(root.left == null && root.right == null){
			int sum = 0;
			for(Integer i: path){
				sum = sum + i;
			}
			if(max.max_no < sum)
				max.max_no = sum;
			return;
		}
		if(root.left != null)
			getMaxSumPath(root.left, new ArrayList<Integer>(path), max);
		if(root.right != null)
			getMaxSumPath(root.right, new ArrayList<Integer>(path), max);
	}
	
	int getMaxSum(TreeNode node){
		if(node == null) return 0;
		if(node.left == null && node.right == null) return node.data;
		return node.data + Math.max(getMaxSum(node.left), getMaxSum(node.right));
	}
}
