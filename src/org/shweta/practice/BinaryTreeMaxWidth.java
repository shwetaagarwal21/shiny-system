package org.shweta.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxWidth {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeMaxWidth tree = new BinaryTreeMaxWidth();
		tree.createSampleTree();
		int maxWidth = tree.maxWidthUsingQueue();
		System.out.println("Max Width of tree using queue is :: " + maxWidth);

	}
	
	int maxWidthUsingQueue(){
		return maxWidthUsingQueue(root);
	}
	
	int maxWidthUsingQueue(TreeNode node){
		if(node == null) return 0;
		int result = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()){
			result = Math.max(result, queue.size());
			TreeNode n = queue.remove();
			if(n.left != null)
				queue.add(n.left);
			if(n.right!=null)
				queue.add(n.right);
		}
		return result;
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(8, new TreeNode(6), new TreeNode(7))));
	}
	
}
