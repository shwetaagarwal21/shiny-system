package org.shweta.practice;

public class BinaryTreeViews {
	
	TreeNode root;
	Max_Level max = new Max_Level();
	Max_Level maxLeftView = new Max_Level();
	
	class Max_Level{
		int max_level;
	}

	public static void main(String[] args) {
		BinaryTreeViews tree = new BinaryTreeViews();
		tree.createSampleTree();
		System.out.println("Right view of tree is :: ");
		tree.rightView();
		System.out.println();
		System.out.println("Left view of tree is :: ");
		tree.leftView();
		
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(8, null, new TreeNode(10))), new TreeNode(5)), new TreeNode(3, new TreeNode(6, new TreeNode(9))));
	}
	
	void rightView(){
		rightView(root);
	}
	
	void rightView(TreeNode node){
		rightViewUtil(node, 1, max);
	}
	
	void rightViewUtil(TreeNode node, int level, Max_Level max_level){
		if(node == null)
			return;
		if(max_level.max_level < level){
			System.out.print(node.data + " ");
			max_level.max_level = level;
		}
		rightViewUtil(node.right, level + 1, max_level);
		rightViewUtil(node.left, level + 1, max_level);
	}
	
	void leftView(){
		leftView(root);
	}
	
	void leftView(TreeNode node){
		leftViewUtil(node, 1, maxLeftView);
	}
	
	void leftViewUtil(TreeNode node, int level, Max_Level max_level){
		if(node == null)
			return;
		if(max_level.max_level < level){
			System.out.print(node.data + " ");
			max_level.max_level = level;
		}
		leftViewUtil(node.left, level+1, max_level);
		leftViewUtil(node.right, level+1, max_level);
	}

}
