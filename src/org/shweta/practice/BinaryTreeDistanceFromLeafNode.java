package org.shweta.practice;

public class BinaryTreeDistanceFromLeafNode {
	TreeNode root;
	public static void main(String[] args) {
		BinaryTreeDistanceFromLeafNode tree = new BinaryTreeDistanceFromLeafNode();
		tree.createSampleTree();
		tree.printKDistantFromLeaf(tree.root, 2);
	}
	
	void printKDistantFromLeaf(TreeNode node, int k){
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(node, path, visited, 0, k);
	}
	
	void kDistantFromLeafUtil(TreeNode node, int[] path, boolean[] visited, int pathLen, int k){
		if(node == null) return;
		
		path[pathLen] = node.data;
		visited[pathLen] = false;
		pathLen++;
		
		if(node.left == null && node.right == null && pathLen - k -1 >=0 && visited[pathLen - k -1] == false){
			System.out.print(path[pathLen - k -1] + " ");
			visited[pathLen - k -1] = true;
			return;
		}
		
		kDistantFromLeafUtil(node.left, path, visited, pathLen, k);
		kDistantFromLeafUtil(node.right, path, visited, pathLen, k);
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6, null, new TreeNode(8)), new TreeNode(7)));
	}

}
