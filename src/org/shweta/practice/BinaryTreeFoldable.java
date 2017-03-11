package org.shweta.practice;

public class BinaryTreeFoldable {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeFoldable tree = new BinaryTreeFoldable();
		tree.createSampleTree();
		boolean isFoldable = tree.isFoldable(tree.root);
		System.out.println(isFoldable);
		System.out.println();
		isFoldable = tree.isFoldable2(tree.root);
		System.out.println(isFoldable);
		
		tree.printKDistant(2);
		
	}
	
	boolean isFoldable(TreeNode node){
		if(node == null) return true;
		mirror(node.left);
		boolean res;
		res = isStructSame(node.left, node.right);
		mirror(node.left);
		return res;
	}
	
	boolean isStructSame(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		if(a!=null && b!=null && isStructSame(a.left, b.left) 
				&& isStructSame(a.right, b.right))
			return true;
		return false;
	}
	
	boolean isFoldable2(TreeNode node){
		if(node == null) return true;
		return isFoldableUtil(node.left, node.right);
	}
	
	boolean isFoldableUtil(TreeNode a, TreeNode b){
		if(a == null && b == null) return true;
		if(a != null && b == null) return false;
		if(a == null && b != null) return false;
		return isFoldableUtil(a.left, b.right) && isFoldableUtil(a.right, b.left);
	}
	
	TreeNode mirror(TreeNode node){
		if(node == null)
			return node;
		TreeNode left = mirror(node.left);
		TreeNode right = mirror(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
	
	void createSampleTree(){
		//root = new TreeNode(10, new TreeNode(7, new TreeNode(9), new TreeNode(10)), new TreeNode(15, new TreeNode(12)));
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(8)));
	}
	
	void printKDistant(int k){
		printKDistant(root, 0, k);
	}
	
	void printKDistant(TreeNode node, int level, int k){
		if(node == null) return;
		if(level == k){
			System.out.print(node.data + " ");
			return;
		}
		printKDistant(node.left, level+1, k);
		printKDistant(node.right, level+1, k);
	}
	
	int getLevel(int key){
		return getLevel(root, key, 1);		
	}
	
	int getLevel(TreeNode node, int key, int level){
		if(node == null) return 0;
		if(node.data == key) return level;
		int l = getLevel(node.left, key, level+1);
		if(l!=0)
			return l;
		else
			return getLevel(node.right, key, level + 1);
	}
	
	boolean printAncestors(TreeNode node, int target){
		if(node == null) return false;
		if(node.data == target) return true;
		
		if(printAncestors(node.left, target) || printAncestors(node.right, target)){
			System.out.print(node.data + " ");
			return true;
		}
		return false;
	}

}
