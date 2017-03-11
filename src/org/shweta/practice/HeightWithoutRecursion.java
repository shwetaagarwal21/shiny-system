package org.shweta.practice;

import java.util.LinkedList;
import java.util.Queue;

public class HeightWithoutRecursion {
	
	TreeNode root; 

	public static void main(String[] args) {
		HeightWithoutRecursion tree = new HeightWithoutRecursion();
		tree.createSampleTree();
		
		int ht = tree.height();
		System.out.println("Height of tree is :: " + ht);
	}
	
	int height(){
		if(root == null) return 0;
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(root);
		int height = 0;
		while(true){
			int nodeCount = Q.size();
			if(nodeCount == 0)
				return height;
			height++;
			
			while(nodeCount>0){
				TreeNode newnode = Q.peek();
				Q.remove();
				if(newnode.left!=null)
					Q.add(newnode.left);
				if(newnode.right!=null)
					Q.add(newnode.right);
				nodeCount--;
			}			
		}
	}
	
	int getLevelDiff(TreeNode node){
		if(node == null) return 0;
		return node.data - getLevelDiff(node.left) - getLevelDiff(node.right);
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
	}

}
