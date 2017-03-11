package org.shweta.practice;

public class BinaryTreeRemoveNodesPathLessThan {

	TreeNode root;
	
	public static void main(String[] args) {
		BinaryTreeRemoveNodesPathLessThan tree = new BinaryTreeRemoveNodesPathLessThan();
		tree.createSampleTree();
		int k = 4;
		tree.printInorder(tree.root);
		System.out.println();
		TreeNode res = tree.removeShortPathNodes(tree.root, k);
		tree.printInorder(res);
	}
	
	TreeNode removeShortPathNodes(TreeNode node, int k){
		int pathLen = 0;
		return removeShortPathNodes(node, 1, k);
	}
	
	TreeNode removeShortPathNodes(TreeNode node, int level, int k){
		if(node == null) return null;
		
		node.left = removeShortPathNodes(node.left, level + 1, k);
		node.right = removeShortPathNodes(node.right, level + 1, k);
		
		if(isLeaf(node) && level < k)
			return null;
		
		return node;		
	}
	
	boolean isLeaf(TreeNode node){
		return (node.left == null && node.right == null)? true : false;
	}
	
	void printInorder(TreeNode node) 
    {
        if (node != null){
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7)), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, new TreeNode(8))));
	}

}
