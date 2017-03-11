package org.shweta.practice;

public class ConvertBTToHoldChildrenSumProperty {
	
	TreeNode root;
	
	public static void main(String[] args) {
		ConvertBTToHoldChildrenSumProperty tree = new ConvertBTToHoldChildrenSumProperty();
		tree.createSampleTree();
		System.out.println("Given Tree in Inorder Traversal is :: ");
		tree.traverseInorderRec();
		System.out.println();
		tree.convertTree(tree.root);
		System.out.println("Tree after conversion in Inorder Traversal is :: ");
		tree.traverseInorderRec();
	}
	
	void convertTree(TreeNode node){
		int diff;
		int left_data = 0, right_data = 0;
		if(node == null || (node.left == null && node.right == null))
			return;
		else{
			convertTree(node.left);
			convertTree(node.right);
			
			if(node.left != null)
				left_data = node.left.data;
			if(node.right != null)
				right_data = node.right.data;
			diff = left_data + right_data - node.data;
			
			if(diff > 0)
				node.data = node.data + diff;
			
			if(diff < 0)
				increment(node, -diff);			
		}
	}
	
	void increment(TreeNode node, int diff){
		if(node.left!=null){
			node.left.data = node.left.data + diff;
			increment(node.left, diff);
		}
		else if(node.right!=null){
			node.right.data = node.right.data + diff;
			increment(node.right, diff);
		}		
	}
	
	void createSampleTree(){
		root = new TreeNode(50, new TreeNode(7, new TreeNode(3), new TreeNode(5)), new TreeNode(2, new TreeNode(1), new TreeNode(30)));		
	}
	
	void traverseInorderRec(){
		traverseInorderRec(root);
	}
	
	void traverseInorderRec(TreeNode node){
		if(node == null)
			return;
		traverseInorderRec(node.left);
		System.out.print(node.data + " ");
		traverseInorderRec(node.right);
	}
	
	boolean isChildrenSumProperty(TreeNode node){
		int lft_data = 0, rgt_data = 0;
		if(node == null || (node.left == null && node.right == null))
			return true;
		else{
			if(node.left!=null)
				lft_data = node.left.data;
			if(node.right!=null)
				rgt_data = node.right.data;
			return (node.data == lft_data + rgt_data) && isChildrenSumProperty(node.left) && isChildrenSumProperty(node.right);
		}
	}

}
