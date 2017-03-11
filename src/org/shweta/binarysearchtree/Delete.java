package org.shweta.binarysearchtree;

/*
 * 3 cases when deleting a node in BST
 * i. Node to delete is a leaf - Simply remove the node
 * ii. Node to delete has one child - Copy child to the node and delete the child
 * iii. Node to delete has two children - Find inorder successor of the node. 
 * Copy contents of the inorder successor to the node and delete the inorder successor. 
 * Note that inorder predecessor can also be used.
 */
public class Delete {
	
	TreeNode root;
	
	Delete(){
		root = null;
	}

	public static void main(String[] args) {
		Delete tree = new Delete();
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
        
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

	}
	
	void deleteKey(int key){
		root = deleteRec(root, key);
	}
	
	TreeNode deleteRec(TreeNode root, int key){
		if(root == null) 
			return root;
		
		if(key < root.data)
			root.left = deleteRec(root.left, key);
		else if(key > root.data)
			root.right = deleteRec(root.right, key);
		
		else {
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			
			// node with two children: Get the inorder successor (smallest
            // in the right subtree)
			root.data = minValue(root.right);
			
			// Delete the inorder successor
			root.right = deleteRec(root.right, root.data);
			
			// node with two children: Get the inorder predecessor (highest
            // in the left subtree)
			//root.data = maxValue(root.left);
			
			// Delete the inorder predecessor
			//root.left = deleteRec(root.left, root.data);
		}
		return root;
	}
	
	int maxValue(TreeNode node){
		int maxv = node.data;
		while(node.right != null){
			maxv = node.right.data;
			node = node.right;
		}
		return maxv;
	}
	
	int minValue(TreeNode node){
		int minv = node.data;
		while(node.left!=null){
			minv = node.left.data;
			node = node.left;
		}
		return minv;
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

}
