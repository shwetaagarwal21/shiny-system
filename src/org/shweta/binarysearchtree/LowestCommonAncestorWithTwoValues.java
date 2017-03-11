package org.shweta.binarysearchtree;

public class LowestCommonAncestorWithTwoValues {
	
	TreeNode root;
	
	public static void main(String[] args) {
		LowestCommonAncestorWithTwoValues tree = new LowestCommonAncestorWithTwoValues();
		tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);
        
        int n1 = 10, n2 = 14;
        TreeNode t = tree.lcaIterative(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 14;
        n2 = 8;
        t = tree.lcaIterative(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
        n1 = 10;
        n2 = 22;
        t = tree.lcaIterative(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	}
	
	TreeNode lca(TreeNode node, int n1, int n2){
		if(node == null)
			return null;
		
		if(node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);
		
		if(node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);
		
		return node;		
	}
	
	TreeNode lcaIterative(TreeNode node, int n1, int n2){
		while(node!=null){
			if(node.data > n1 && node.data > n2)
				node = node.left;
			else if(node.data < n1 && node.data < n2)
				node = node.right;
			else
				break;
		}
		return node;
	}

}
