package org.shweta.practice;

public class SpecialBinaryTree {
	
	class Index{
		int index = 0;
	}
	
	TreeNode root;
	Index myindex = new Index();

	public static void main(String[] args) {
		int in[] = new int[]{5, 10, 40, 30, 28};
		int len = in.length;
		SpecialBinaryTree tree = new SpecialBinaryTree();
		TreeNode node = tree.buildTree(in, 0, len - 1, tree.root);
		tree.printInOrder(node);
		
		int pre[] = new int[]{10, 30, 20, 5, 15};
		char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
		int n = pre.length;
		TreeNode node2 = tree.buildTree(pre, preLN, n, tree.root);
		System.out.println();
		tree.printInOrder(node2);
		
	}
	
	TreeNode buildTree(int pre[], char preLN[], int n, TreeNode node){
		return buildTree(pre, preLN, myindex, n, node);
	}
	
	TreeNode buildTree(int pre[], char preLN[], Index index_ptr, int n, TreeNode node){
		int index = index_ptr.index;
		if(index == n)
			return null;
		node = new TreeNode(pre[index]);
		(index_ptr.index)++;
		if(preLN[index] == 'N'){
			node.left = buildTree(pre, preLN, index_ptr, n, node.left);
			node.right = buildTree(pre, preLN, index_ptr, n, node.right);
		}
		return node;
	}
	
	TreeNode buildTree(int in[], int start, int end, TreeNode node){
		if(start > end)
			return null;
		int i = max(in, start, end);
		node = new TreeNode(in[i]);
		if(start == end)
			return node;
		node.left = buildTree(in, start, i-1,node.left);
		node.right = buildTree(in, i+1, end, node.right);
		return node;
	}
	
	int max(int arr[], int start, int end){
		int i;
		int max = arr[start];
		int maxIndex = start;
		for(i = start+1; i<=end;i++){
			if(max < arr[i]){
				max = arr[i];
				maxIndex = i;
			}			
		}
		return maxIndex;
	}
	
	
	void printInOrder(TreeNode n){
		if(n == null) return;
		printInOrder(n.left);
		System.out.print(n.data + " ");
		printInOrder(n.right);
	}

}
