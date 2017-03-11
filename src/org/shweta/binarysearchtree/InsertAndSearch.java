package org.shweta.binarysearchtree;

public class InsertAndSearch {
	
	TreeNode root;
	
	InsertAndSearch(){
		root = null;
	}
	
	public static void main(String[] args) {
		InsertAndSearch tree = new InsertAndSearch();
		tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        System.out.println("Inorder traversal of binary search tree is :: ");
        tree.inorder();
        System.out.println();
        
        TreeNode found = tree.search(40);
        System.out.println(found != null ? true : false);
        
	}
	
	void insert(int key){
		root = insertRec(root, key);
	}
	
	TreeNode insertRec(TreeNode root, int key){
		if(root == null){
			root = new TreeNode(key);
			return root;
		}
		
		if(key < root.data)
			root.left = insertRec(root.left, key);
		else
			root.right = insertRec(root.right, key);
		return root;
	}
	
	void inorder(){
		inorderRec(root);
	}
	
	void inorderRec(TreeNode root){
		if(root != null){
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}
	
	TreeNode search(int key){		
		return searchTree(root, key);		
	}
	
	TreeNode searchTree(TreeNode root, int key){
		if(root == null || root.data == key)
			return root;
		if(key < root.data){
			return searchTree(root.left, key);
		} else {
			return searchTree(root.right, key);	
		}
	}
}
