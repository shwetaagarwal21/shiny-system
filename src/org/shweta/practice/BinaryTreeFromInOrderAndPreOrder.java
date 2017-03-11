package org.shweta.practice;

import java.util.LinkedList;

public class BinaryTreeFromInOrderAndPreOrder {
	
	//TreeNode root;
	static int preIndex = 0;

	public static void main(String[] args) {
		BinaryTreeFromInOrderAndPreOrder tree = new BinaryTreeFromInOrderAndPreOrder();
		int[] inOrder = new int[]{4,2,5,1,3};
		int[] preOrder = new int[]{1,2,4,5,3};
		int length = inOrder.length;
		
		/*TreeNode root = tree.buildTree(inOrder, preOrder, 0, length - 1);
		System.out.println("Inorder traversal is:: ");
		tree.printInOrder(root);*/
		
		int[] postOrder = new int[]{4,5,2,3,1};
		TreeNode root = tree.buildTreePostInOrder(inOrder, postOrder, 0, length-1, 0, postOrder.length - 1);
		System.out.println("Inorder traversal is:: ");
		tree.printInOrder(root);
		
	}
	
	TreeNode buildTreePostInOrder(int[] in, int[] post, int start, int end, int pStart, int pEnd){
		if(start > end || pStart > pEnd)
			return null;
		
		TreeNode node = new TreeNode(post[pEnd]);
		int inIndex = search(in, post[pEnd]);
		//pEnd--;
		node.left =  buildTreePostInOrder(in, post, start, inIndex - 1, pStart, pStart + inIndex - (start + 1));
		node.right = buildTreePostInOrder(in, post, inIndex + 1, end, pStart + inIndex - start, pEnd - 1);
		return node;
	}
	
	TreeNode buildTree(int[] in, int[] pre, int start, int end){
		if(start > end)
			return null;
		
		TreeNode node = new TreeNode(pre[preIndex]);
		int inIndex = search(in, pre[preIndex]);
		preIndex++;
		node.left = buildTree(in, pre, start, inIndex - 1);
		node.right = buildTree(in, pre, inIndex + 1, end);
		return node;		
	}
	
	int search(int[] in, int key){
		int i;
		for(i=0;i<in.length;i++){
			if(in[i] == key)
				return i;
		}
		return i;
	}
	
	public void printInOrder(TreeNode root){
		if(root == null)
			return;
		
		printInOrder(root.left);
		System.out.print(root.data + " ");
		printInOrder(root.right);		
	}
	
	int depthDeepestOddLevelLeafNode(TreeNode node, int currLevel){
		if(node == null)
			return 0;
		if(isLeaf(node) && (currLevel & 1) != 0)
			return currLevel;
		return Math.max(depthDeepestOddLevelLeafNode(node.left, currLevel + 1), depthDeepestOddLevelLeafNode(node.right, currLevel + 1));		
	}
	
	boolean isLeaf(TreeNode node){
		return (node.left == null && node.right == null)? true : false;
	}
	
	boolean checkBinaryTreeFull(TreeNode node){
		if(node == null)
			return true;
		if(node.left == null && node.right == null)
			return true;
		if(node.left!=null && node.right!=null)
			return checkBinaryTreeFull(node.left) && checkBinaryTreeFull(node.right);		
		return false;			
	}
	
	boolean checkCompleteBinaryTree(TreeNode node){
		if(node == null) return true;
		LinkedList<TreeNode> queue = new LinkedList();
		boolean nonFullNodeSeen = false;
		queue.add(node);
		
		while(!queue.isEmpty()){
			TreeNode currentNode = queue.remove();
			if(currentNode.left!=null && currentNode.right!=null){
				if(nonFullNodeSeen){
					return false;
				}
				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
			
			if(currentNode.left!=null && currentNode.right==null){
				if(nonFullNodeSeen){
					return false;
				}
				nonFullNodeSeen = true;
				queue.add(currentNode.left);
			}
			
			if(currentNode.left==null && currentNode.right!=null)
				return false;
		}
		return true;		
	}
	//isCousin(root, nodeA, nodeB);
	boolean isCousin(TreeNode node, TreeNode node1, TreeNode node2){		
		return (findLevel(node, node1, 1) == findLevel(node, node2, 1)) && !isSibling(node, node1, node2);		
	}
	
	int findLevel(TreeNode node, TreeNode nodeA, int level){
		if(node == null)
			return 0;
		if(node == nodeA)
			return level;
		int l = findLevel(node.left, nodeA, level+1);
		if(l!=0)
			return l;
		else
			return findLevel(node.right, nodeA, level+1);
	}
	
	boolean isSibling(TreeNode node, TreeNode nodeA, TreeNode nodeB){
		if(node == null) return false;
		
		return (node.left == nodeA && node.right == nodeB)
				|| (node.left == nodeB && node.right == nodeA)
				|| (isSibling(node.left, nodeA, nodeB))
				|| (isSibling(node.right, nodeA, nodeB));
	}
	
	boolean identicalTrees(TreeNode node1, TreeNode node2){
		if(node1 == null && node2 == null)
			return true;
		if(node1!=null && node2!=null)
			return node1.data == node2.data && identicalTrees(node1.left, node2.left) && identicalTrees(node1.right, node2.right);
		return false;
	}
	
	TreeNode mirror(TreeNode node){
		if(node == null) return node;
		TreeNode left = mirror(node.left);
		TreeNode right = mirror(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
	
	TreeNode buildSpecialInOrderTree(int[] in, int start, int end, TreeNode node){
		if(start > end) return null;
		int i = max(in, start, end);
		node = new TreeNode(in[i]);
		if(start == end) return node;
		
		node.left = buildSpecialInOrderTree(in, start, i-1, node.left);
		node.right = buildSpecialInOrderTree(in, i+1, end, node.right);
		return node;
	}
	
	int max(int[] arr, int start, int end){
		int max = arr[start];
		int max_index = start;
		for(int i=start+1;i<=end;i++){
			if(max < arr[i]){
				max = arr[i];
				max_index = i;
			}
		}
		return max_index;
	}
	
	
	class Index{
		int index = 0;
	}
	Index myindex = new Index();
	//call it with parameters as pre[], preLN[], n and root
	TreeNode buildSpecialPreOrderTree(int pre[], char preLN[], int n, TreeNode node){
		return buildSpecialPreOrderTreeRec(pre, preLN, n, myindex, node);
	}
	
	TreeNode buildSpecialPreOrderTreeRec(int pre[], char preLN[], int n, Index index_ptr, TreeNode node){
		int index = index_ptr.index;
		if(index == n) return null;
		node = new TreeNode(pre[index]);
		index_ptr.index++;
		if(preLN[index] == 'N'){
			node.left = buildSpecialPreOrderTreeRec(pre, preLN, n, index_ptr, node.left);
			node.right = buildSpecialPreOrderTreeRec(pre, preLN, n, index_ptr, node.right);
		}
		return node;
	}
	
}
