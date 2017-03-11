package org.shweta.practice;

import org.shweta.practice.SpecialBinaryTree.Index;

public class ConstructFullBTFromPrePostArray {
	
	class Index{
		int index = 0;
	}
	
	TreeNode root;
	Index myindex = new Index();

	public static void main(String[] args) {
		int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
	    int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
	    int size = pre.length;
	    ConstructFullBTFromPrePostArray tree = new ConstructFullBTFromPrePostArray();
	    TreeNode node = tree.constructTree(pre, post, size, tree.root);
	    
	    System.out.println("Inorder traversal of the tree is :: ");
	    tree.printInOrder(node);

	}
	
	TreeNode constructTree(int[] pre, int post[], int n, TreeNode node){
		int preIndex = 0;
		return constructTree(pre, post, 0, n-1, n, myindex, node);
	}
	
	TreeNode constructTree(int[] pre, int post[], int start, int end, int size, Index index_ptr, TreeNode node){
		if(index_ptr.index >= size || start > end)
			return null;
		int index_pre = index_ptr.index;
		node = new TreeNode(pre[index_pre]);
		//++preIndex;
		(index_ptr.index)++;
		if(start == end)
			return node;
		
		int i;
		for(i=start;i<=end;i++)
			if(pre[index_ptr.index] == post[i])
				break;
		
		if(i<=end){
			node.left = constructTree(pre, post, start, i, size, index_ptr, node.left);
			node.right = constructTree(pre, post, i+1, end, size, index_ptr, node.right);
		}
				
		return node;		
	}
	
	void printInOrder(TreeNode n){
		if(n == null) return;
		printInOrder(n.left);
		System.out.print(n.data + " ");
		printInOrder(n.right);
	}

}
