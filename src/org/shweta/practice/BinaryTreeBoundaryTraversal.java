package org.shweta.practice;

public class BinaryTreeBoundaryTraversal {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeBoundaryTraversal tree = new BinaryTreeBoundaryTraversal();
		tree.createSampleTree();
		tree.printBoundary(tree.root);

	}
	
	void printBoundary(TreeNode node){
		if(node!=null){
			System.out.print(node.data + " ");
			printBoundaryLeft(node.left);
			
			printLeaves(node.left);
			printLeaves(node.right);
			
			printBoundaryRight(node.right);
		}
	}
	
	void printBoundaryLeft(TreeNode node){
		if(node!=null){
			if(node.left!=null){
				System.out.print(node.data + " ");
				printBoundaryLeft(node.left);
			}else if(node.right!=null){
				System.out.print(node.data + " ");
				printBoundaryLeft(node.right);
			}
		}
	}
	
	void printLeaves(TreeNode node){
		if(node!=null){
			printLeaves(node.left);
			if(node.left == null && node.right == null)
				System.out.print(node.data + " ");
			printLeaves(node.right);
		}
	}
	
	void printBoundaryRight(TreeNode node){
		if(node!=null){
			if(node.right!=null){
				printBoundaryRight(node.right);
				System.out.print(node.data + " ");
			}else if(node.left!=null){
				printBoundaryRight(node.left);
				System.out.print(node.data + " ");
			}
		}
	}
	
	void createSampleTree(){
		root = new TreeNode(20, new TreeNode(8, new TreeNode(4), new TreeNode(12, new TreeNode(10), new TreeNode(14))), new TreeNode(22, null, new TreeNode(25)));
	}

}
