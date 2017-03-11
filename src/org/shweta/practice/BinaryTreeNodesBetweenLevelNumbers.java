package org.shweta.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNodesBetweenLevelNumbers {
	TreeNode root;
	public static void main(String[] args) {
		BinaryTreeNodesBetweenLevelNumbers tree = new BinaryTreeNodesBetweenLevelNumbers();
		tree.createSampleTree();
		tree.printLevels(tree.root, 2, 3);
	}
	
	void printLevels(TreeNode node, int low, int high){
		Queue<TreeNode> Q = new LinkedList<>();
		TreeNode marker = new TreeNode(4);
		Q.add(node);
		Q.add(marker);
		int level = 1;
		while(!Q.isEmpty()){
			TreeNode n = Q.peek();
			Q.remove();
			if(n == marker){
				System.out.println();
				level++;
				
				if(Q.isEmpty() || level > high)
					break;
				
				Q.add(marker);
				continue;
			}
			if(level>=low)
				System.out.print(n.data + " ");
			if(n.left!=null)
				Q.add(n.left);
			if(n.right!=null)
				Q.add(n.right);
		}
	}
	
	void createSampleTree(){
		root = new TreeNode(20, new TreeNode(8, new TreeNode(4), new TreeNode(12, new TreeNode(10), new TreeNode(14))), new TreeNode(22));
	}

}
