package org.shweta.practice.bst;

public class BinarySearchTree {
	
	TreeNode root;
	TreeNode prev;

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		
		System.out.println("Tree in order traversal is :: ");
		bst.inOrder();
		
		/*bst.delete(20);
		System.out.println();
		System.out.println("Deleted 20");
		bst.inOrder();
		
		bst.delete(30);
		System.out.println();
		System.out.println("Deleted 30");
		bst.inOrder();
		
		bst.delete(50);
		System.out.println();
		System.out.println("Deleted 50");
		bst.inOrder();*/
		
		TreeNode pre = null;
		TreeNode suc = null;
		bst.findPreSuc(pre, suc, 65);

	}
	
	TreeNode inOrderSucc(TreeNode root, TreeNode node){
		if(node.right != null)
			return minValueForSucc(node.right);
		TreeNode succ = null;
		while(root!=null){
			if(node.data < root.data){
				succ = root;
				root = root.left;
			}else if(node.data > root.data){
				root = root.right;
			}else
				break;
		}
		return succ;
	}
	
	TreeNode minValueForSucc(TreeNode node){
		while(node.left!=null){
			node = node.left;
		}
		return node;
	}
	
	TreeNode lca(TreeNode node, int n1, int n2){
		if(node == null) return null;
		if(node.data > n1 && node.data > n2)
			return lca(node.left, n1, n2);
		if(node.data < n1 && node.data < n2)
			return lca(node.right, n1, n2);
		return node;
	}
	
	TreeNode lcaIterative(TreeNode node, int n1, int n2){
		if(node == null) return null;
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
	
	void findPreSuc(TreeNode pre, TreeNode suc, int key){
		findPreSuc(root, pre, suc, key);
	}
	
	void findPreSuc(TreeNode node, TreeNode pre, TreeNode suc, int key){
		if(node == null) return;
		if(node.data == key){
			if(node.left!=null){
				TreeNode tmp = node.left;
				while(tmp.right!=null)
					tmp = tmp.right;
				pre = tmp;
			}
			if(node.right!=null){
				TreeNode tmp = node.right;
				while(tmp.left!=null)
					tmp = tmp.left;
				suc = tmp;
			}
			return;
		}
		
		if(node.data > key){
			suc = node;
			findPreSuc(node.left, pre, suc, key);
		}else if(node.data < key){
			pre = node;
			findPreSuc(node.right, pre, suc, key);
		}
		if(pre!=null)
			System.out.println("PRE is :: " + pre.data);
		if(suc!=null)
			System.out.println("SUC is :: " + suc.data);
	}
	
	void insert(int key){
		root = insertRec(root, key);
	}
	
	TreeNode insertRec(TreeNode node, int key){
		if(node == null){
			root = new TreeNode(key);
			return root;
		}
		if(key < node.data)
			node.left = insertRec(node.left, key);
		else if(key > node.data)
			node.right = insertRec(node.right, key);
		return node;		
	}
	
	TreeNode search(TreeNode node, int key){
		if(node == null || node.data == key)
			return node;
		if(node.data > key)
			return search(node.left, key);
		return search(node.right, key);
	}
	
	void delete(int key){
		root = deleteRec(root, key);
	}
	
	TreeNode deleteRec(TreeNode node, int key){
		if(node == null) return null;
		if(key < node.data)
			node.left = deleteRec(node.left, key);
		else if(key > node.data)
			node.right = deleteRec(node.right, key);
		else{
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			
			node.data = minValue(node.right);
			node.right = deleteRec(node.right, node.data);
		}			
		return node;
	}
	
	int minValue(TreeNode node){
		int min = node.data;
		while(node.left !=null){
			min = node.left.data;
			node = node.left;
		}
		return min;
	}
	
	int findMinimum(TreeNode node){
		TreeNode curr = node;
		while(curr.left!=null)
			curr = curr.left;
		return curr.data;
	}
	
	boolean isBST(){
		return isBST(root);
	}
	
	boolean isBST(TreeNode node){
		if(node != null) {
			if(!isBST(node.left)) return false;
			if(prev!=null && node.data <= prev.data) return false;
			prev = node;
			return isBST(node.right);
		}
		return true;		
	}
	
	void inOrder(){
		if(root == null) return;
		inOrderRec(root);
	}
	
	void inOrderRec(TreeNode node){
		if(node!=null){
			inOrderRec(node.left);
			System.out.print(node.data + " ");
			inOrderRec(node.right);
		}
	}

}
