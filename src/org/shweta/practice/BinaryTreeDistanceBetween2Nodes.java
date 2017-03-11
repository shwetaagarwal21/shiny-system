package org.shweta.practice;

public class BinaryTreeDistanceBetween2Nodes {
	TreeNode root;
	public static void main(String[] args) {
		BinaryTreeDistanceBetween2Nodes tree = new BinaryTreeDistanceBetween2Nodes();
		tree.createSampleTree();
		int distance = tree.findDistance(tree.root, 8, 5);
		System.out.println(distance);
	}
	
	int findDistance(TreeNode node, int n1, int n2){
		int d1 = -1, d2 = -1;
		int dist = 0;
		TreeNode lca = findDistUtil(node, n1, n2, d1, d2, dist, 1);
		System.out.println(d1 + " " + d2);
		if(d1!=-1 && d2!=-1)
			return dist;
		if(d1!=-1){
			dist = findLevel(lca, n2, 0);
			return dist;
		}
		if(d2!=-1){
			dist = findLevel(lca, n1, 0);
			return dist;
		}
		return -1;		
	}
	
	TreeNode findDistUtil(TreeNode node, int n1, int n2, int d1, int d2, int dist, int lvl){
		if(node == null) return null;
		if(node.data == n1){
			d1 = lvl;
			return node;
		}
		if(node.data == n2){
			d2 = lvl;
			return node;
		}
		TreeNode left_lca = findDistUtil(node.left, n1, n2, d1, d2, dist, lvl+1);
		TreeNode right_lca = findDistUtil(node.right, n1, n2, d1, d2, dist, lvl+1);
		if(left_lca!=null && right_lca!=null){
			dist = d1 + d2 - 2*lvl;
			return node;
		}
		return (left_lca!=null)?left_lca:right_lca;
	}
	
	int findLevel(TreeNode node, int key, int level){
		if(node == null) return -1;
		if(node.data == key)
			return level;
		int l = findLevel(node.left, key, level+1);
		return (l!=-1)?l:findLevel(node.right, key, level+1);
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6, null, new TreeNode(8)), new TreeNode(7)));
	}

}
