package org.shweta.binarytree;

public class LowestCommonAncestorWithTwoValues {
	
	TreeNode root;
	static boolean v1 = false, v2 = false;

	public static void main(String[] args) {
		LowestCommonAncestorWithTwoValues tree = new LowestCommonAncestorWithTwoValues();
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
 
        TreeNode lca = tree.findLCA(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");
 
        lca = tree.findLCA(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
        
        lca = tree.findLCA(1, 7);
        if (lca != null)
            System.out.println("LCA(1, 7) = " + lca.data);
        else
            System.out.println("Keys are not present");
	}
	
	TreeNode findLCA(int n1, int n2){
		v1 = false;
		v2 = false;
		TreeNode lca = findLCAUtil(root, n1, n2);
		if(v1 && v2)
			return lca;
		return null;
	}
	
	TreeNode findLCAUtil(TreeNode node, int n1, int n2){
		if(node == null) return null;
		
		if(node.data == n1){
			v1 = true;
			return node;
		}
		
		if(node.data == n2){
			v2 = true;
			return node;
		}
		
		TreeNode left_lca = findLCAUtil(node.left, n1, n2);
		TreeNode right_lca = findLCAUtil(node.right, n1, n2);
		
		if(left_lca != null && right_lca != null)
			return node;
		return left_lca != null ? left_lca : right_lca;		
	}

}
