package org.shweta.practice;

public class BinaryTreeRemoveNodesSumLessThan {

	TreeNode root;
	
	public static void main(String[] args) {
		BinaryTreeRemoveNodesSumLessThan tree = new BinaryTreeRemoveNodesSumLessThan();
		tree.createSampleTree();
		tree.deleteLessPath(23);
		System.out.println("Tree after deletion in preorder is :: ");
		tree.traversePreOrderRec();
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(6, null, new TreeNode(8))), new TreeNode(5, null, new TreeNode(7, new TreeNode(9, new TreeNode(10))))));
	}
	
	void deleteLessPath(int k){
		int sum[] = new int[1];
		deleteLessPath(root, sum, k);
		if(sum[0] < k)
			root = null;
	}
	
	TreeNode deleteLessPath(TreeNode node, int[] sum, int k){
		if(node == null) return null;
		int ls[] = new int[1];
		int rs[] = new int[1];
		ls[0] = rs[0] = sum[0] + node.data;
		
		node.left = deleteLessPath(node.left, ls, k);
		node.right = deleteLessPath(node.right, rs, k);
		sum[0] = ls[0] > rs[0] ? ls[0] : rs[0];
		if(sum[0] < k)
			node = null;
		return node;		
	}
	
	void traversePreOrderRec(){
		traversePreOrderRec(root);
	}
	
	void traversePreOrderRec(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.data + " ");
		traversePreOrderRec(node.left);
		traversePreOrderRec(node.right);
	}
}
