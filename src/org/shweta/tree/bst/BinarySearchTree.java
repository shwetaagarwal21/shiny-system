package org.shweta.tree.bst;

import org.shweta.tree.BinaryTree;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int d){
		this.data = d;
		this.left = this.right = null;
	}	
}

public class BinarySearchTree {
	Node root;
	
	BinarySearchTree(int key){
		root = new Node(key);
	}
	
	BinarySearchTree(){
		root = null;
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.root = new Node(46);
		
		tree.root.left = new Node(17);
		tree.root.right = new Node(63);
		
		tree.root.left.right = new Node(25);
		tree.root.right.left = new Node(55);
		tree.root.right.right = new Node(97);
		
		boolean found = tree.search(55);
		System.out.println("Node 55 present in BST :: " + found);
		
	}
	
	boolean search(int key){
		return search(root, key);
	}
	
	boolean search(Node node, int item){
		if(node == null)
			return false;
		
		if(item < node.data)
			search(node.left, item);
		else if(item > node.data)
			search(node.right, item);
		else 
			return true;
		
		return false;
	}

}
