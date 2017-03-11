package org.shweta.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePerfectSpecificLevelOrder {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreePerfectSpecificLevelOrder tree = new BinaryTreePerfectSpecificLevelOrder();
		tree.createSampleTree();
		tree.printSpecificLevelOrder(tree.root);
	}
	
	void printSpecificLevelOrder(TreeNode node){
		if(node == null) return;
		System.out.print(node.data);
		if(node.left!=null)
			System.out.print(" " + node.left.data + " " + node.right.data);
		if(node.left.left == null)
			return;
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(node.left);
		Q.add(node.right);
		TreeNode first = null, second = null;
		while(!Q.isEmpty()){
			first = Q.peek();
			Q.remove();
			second = Q.peek();
			Q.remove();
			System.out.print(" " + first.left.data + " " + second.right.data);
			System.out.print(" " + first.right.data + " " + second.left.data);
			if(first.left.left!=null){
				Q.add(first.left);
				Q.add(second.right);
				Q.add(first.right);
				Q.add(second.left);
			}
		}
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5, new TreeNode(10), new TreeNode(11))), new TreeNode(3, new TreeNode(6, new TreeNode(12), new TreeNode(13)), new TreeNode(7, new TreeNode(14), new TreeNode(15))));
	}

}
