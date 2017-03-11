package org.shweta.practice;

public class BinarySearchTreeDeleteNode {

	TreeNode root;
	TreeNode prev;
	
	public static void main(String[] args) {
		BinarySearchTreeDeleteNode tree = new BinarySearchTreeDeleteNode();
		tree.createSampleTree();
		tree.deleteKey(30);
		TreeNode pre = null;
		TreeNode suc = null;
		tree.findPreSuc(pre, suc, 50);
	}
	
	void findPreSuc(TreeNode pre, TreeNode suc, int key){
		findPreSuc(root, pre, suc, key);
	}
	
	void findPreSuc(TreeNode root, TreeNode pre, TreeNode suc, int key){
		if(root == null)
			return;
		
		if(root.data == key){
			if(root.left!=null){
				TreeNode tmp = root.left;
				while(tmp.right!=null)
					tmp = tmp.right;
				pre = tmp;
			}
			if(root.right!=null){
				TreeNode tmp = root.right;
				while(tmp.left!=null)
					tmp = tmp.left;
				suc = tmp;
			}
			System.out.println("Pre:: " + pre.data + " Suc:: " + suc.data + " Key:: " + key);
		}
		
		if(root.data > key){
			suc = root;
			findPreSuc(root.left, pre, suc, key);
		}else{
			pre = root;
			findPreSuc(root.right, pre, suc, key);
		}
		if(pre!=null)
			System.out.println("Pre:: " + pre.data + " Key:: " + key);
		if(suc!=null)
			System.out.println("Suc:: " + suc.data + " Key:: " + key);		
	}
	
	boolean isBST(){
		prev = null;
		return isBST(root);
	}
	
	boolean isBST(TreeNode node){
		if(node!=null){
			if(!isBST(root.left))
				return false;
			if(prev!=null && node.data <= prev.data)
				return false;
			prev = node;
			return isBST(node.right);
		}
		return true;
	}
	
	void createSampleTree(){
		root = new TreeNode(50, new TreeNode(30, new TreeNode(20), new TreeNode(40)), new TreeNode(70, new TreeNode(60), new TreeNode(80)));
	}
	
	void deleteKey(int key){
		root = deleteRec(root, key);
	}
	
	TreeNode deleteRec(TreeNode root, int key){
		if(root == null)
			return root;
		
		if(key < root.data)
			return deleteRec(root.left, key);
		else if(key > root.data)
			return deleteRec(root.right, key);
		else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			root.data = minValue(root.right);
			
			root.right = deleteRec(root.right, root.data);			
		}
		return root;
	}

	int minValue(TreeNode node){
		int minv = node.data;
		while(node.left!=null){
			minv = node.left.data;
			node = node.left;
		}
		return minv;
	}
	
}
