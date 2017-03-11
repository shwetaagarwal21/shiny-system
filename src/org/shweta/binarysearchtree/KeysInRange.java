package org.shweta.binarysearchtree;

public class KeysInRange {
	
	TreeNode root;
	
	public static void main(String[] args) {
		KeysInRange tree = new KeysInRange();
		tree.createSampleTree();
		int k1 = 10, k2 = 25;
		System.out.println("Keys between 10 and 25 are:: ");
		tree.keysInRange(k1, k2);
	}
	
	void createSampleTree(){
		root = new TreeNode(20, new TreeNode(8, new TreeNode(4), new TreeNode(12)), new TreeNode(22));
	}
	
	void keysInRange(int k1, int k2){
		keysInRange(root, k1, k2);
	}
	
	void keysInRange(TreeNode root, int k1, int k2){
		if(root == null)
			return;
		
		if(root.data > k1)
			keysInRange(root.left, k1, k2);
		
		if(k1<=root.data && k2>= root.data)
			System.out.print(root.data + " ");
		
		if(root.data < k2)
			keysInRange(root.right, k1, k2);
	}

}
