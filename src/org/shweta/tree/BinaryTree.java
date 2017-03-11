package org.shweta.tree;

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int d){
		this.data = d;
		this.left = this.right = null;
	}	
}

public class BinaryTree {
	Node root;
	
	BinaryTree(int key){
		root = new Node(key);
	}
	
	BinaryTree(){
		root = null;
	}
	
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		
		tree.root.left.left = new Node(4);
		
		int size = tree.size();
		System.out.println("size of a tree is :: " + size);
		
		int height = tree.height(tree.root);
		System.out.println("height of a tree is :: " + height);
		
	}
	
	int size(){
		return size(root);
	}
	
	int size(Node node){
		if(node == null)
			return 0;
		return size(node.left) + size(node.right) + 1;
	}
	
	int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
	
}
