package org.shweta.binarytree;

public class BinaryTreeFromInPreOrder {
	
	TreeNode root;
	static int preIndex = 0;

	public static void main(String[] args) {
		BinaryTreeFromInPreOrder tree = new BinaryTreeFromInPreOrder();
		int in[] = new int[]{4, 2, 5, 1, 6, 3};
		int pre[] = new int[]{1, 2, 4, 5, 3, 6};
		int len = in.length;
		TreeNode root = tree.buildTree(in, pre, 0, len - 1);
		
		System.out.println("Inorder traversal of constructed tree is : ");
		tree.traverseInorderRec(root);
	}
	
	void traverseInorderRec(TreeNode node){
		if(node == null)
			return;
		traverseInorderRec(node.left);
		System.out.print(node.data + " ");
		traverseInorderRec(node.right);
	}
	
	TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd){
		if(inStrt > inEnd)
			return null;
		
		TreeNode tNode = new TreeNode(pre[preIndex++]);
		
		if(inStrt == inEnd)
			return tNode;
		
		int inIndex = search(in, inStrt, inEnd, tNode.data);
		
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
		
		return tNode;		
	}
	
	int search(int arr[], int strt, int end, int value){
		int i;
		for(i=strt;i<=end;i++)
		{
			if(arr[i] == value)
				return i;
		}
		return i;
	}

}
