package org.shweta.binarysearchtree;

public class PredecessorSuccessorGivenKey {
	
	TreeNode root;
	
	public static void main(String[] args) {
		PredecessorSuccessorGivenKey tree = new PredecessorSuccessorGivenKey();
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
        
        System.out.println("Predecessor and Successor of key 50 are :: ");
        TreeNode pre = null;
        TreeNode suc = null;
        tree.findPreSuc(pre, suc, 50);
        if(pre!=null){
        	System.out.println("Predecessor is " + pre.data);
        }
        if(suc!=null){
        	System.out.println(" Successor is " + suc.data);
        }
        tree.findPreSuc(pre, suc, 65);
        /*System.out.println("Predecessor and Successor of key 65 are :: ");
        pre = null; suc = null;
        tree.findPreSuc(pre, suc, 65);
        if(pre!=null){
        	System.out.println("Predecessor is " + pre.data);
        }
        if(suc!=null){
        	System.out.println(" Successor is " + suc.data);
        }*/
        
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
				while(tmp.right != null)
					tmp = tmp.right;
				pre = tmp;
			}
			
			if(root.right!=null){
				TreeNode tmp = root.right;
				while(tmp.left != null)
					tmp = tmp.left;
				suc = tmp;
			}
			System.out.println(key + "            " +pre.data + "     " + suc.data);
			return;
		}
		
		if(root.data > key){
			suc = root;
			findPreSuc(root.left, pre, suc, key);
		}
		else{
			pre = root;
			findPreSuc(root.right, pre, suc, key);
		}
		if(pre!=null){
			System.out.println(key + "            1111 " + pre.data);
		}
		if(suc!=null){
			System.out.println(key + "            1111 " + suc.data);
		}
			
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
