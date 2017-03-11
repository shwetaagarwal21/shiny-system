package org.shweta.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeTraversals tree = new BinaryTreeTraversals();
		tree.createSampleTree();
		System.out.println("Minimum depth is :: " + tree.getMinDepth(tree.root));
		System.out.println();
		
		//Depth First Traversal
		System.out.println("Inorder Traversal using recursion is :: ");
		tree.traverseInorderRec();
		System.out.println();
		System.out.println("Inorder Traversal using iteration is :: ");
		tree.traverseInorderIter();
		System.out.println();
		System.out.println("Preorder Traversal using recursion is :: ");
		tree.traversePreOrderRec();
		System.out.println();
		System.out.println("Preorder Traversal using iteration is :: ");
		tree.traversePreOrderIter();
		System.out.println();
		System.out.println("Postorder Traversal using recursion is :: ");
		tree.traversePostOrderRec();
		System.out.println();
		System.out.println("Postorder Traversal using iteration is :: ");
		tree.traversePostOrderIterUsingStacks();
		//tree.traversePostOrderIter();
		System.out.println();
		

		
		//Breadth First Traversal
		tree.createSampleTree();
		System.out.println("Level Order Traversal is :: ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("Level Order Traversal Using Queue is :: ");
		tree.printLevelOrderQueue();
		System.out.println();
		
		System.out.println("Root to Leaf Paths are :: ");
		tree.printRootToLeafPaths();
		System.out.println();
		
		System.out.println("Level order traversal in spiral form is :: ");
		tree.printLevelOrderSpiral();
		System.out.println();
		
		tree.createSampleTree2();
		System.out.println("checkChildrenSumProperty():: " + tree.checkChildrenSumProperty(tree.root));
	}
	
	void createSampleTree(){
		root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));		
	}
	
	void createSampleTree2(){
		root = new TreeNode(10, new TreeNode(8, new TreeNode(3), new TreeNode(5)), new TreeNode(2, new TreeNode(2)));		
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
	
	void traverseInorderIter(){
		if(root == null)
			return;
		TreeNode n = root;
		Stack<TreeNode> stack = new Stack<>();
		while(n != null){
			stack.push(n);
			n = n.left;
		}
		while(!stack.isEmpty()){
			n = stack.pop();
			System.out.print(n.data + " ");
			if(n.right != null){
				n = n.right;
				while(n!=null){
					stack.push(n);
					n = n.left;
				}
			}
		}
	}
	
	void traversePreOrderRec(){
		traversePreOrderRec(root);
	}
	
	void traversePreOrderRec(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.data + " ");
		traversePreOrderRec(node.left);
		traversePreOrderRec(node.right);
	}
	
	void traversePreOrderIter(){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode n = stack.pop();
			System.out.print(n.data + " ");
			if(n.right != null){
				stack.push(n.right);
			}
			if(n.left!=null){
				stack.push(n.left);
			}
		}
	}
	
	void traversePostOrderRec(){
		traversePostOrderRec(root);
	}
	
	void traversePostOrderRec(TreeNode node){
		if(node == null)
			return;
		traversePostOrderRec(node.left);
		traversePostOrderRec(node.right);
		System.out.print(node.data + " ");
	}
	
	void traversePostOrderIter(){
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode n = stack.peek();
			if(n.left == null && n.right == null){
				TreeNode node = stack.pop();
				System.out.print(node.data + " ");
			}else{
				if(n.right != null){
					stack.push(n.right);
					n.right = null;
				}
				if(n.left != null){
					stack.push(n.left);
					n.left = null;
				}
			}
		}		
	}
	
	void traversePostOrderIterUsingStacks(){
		if(root == null)
			return;
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		TreeNode node = null;
		while(!s1.isEmpty()){
			node = s1.pop();
			s2.push(node);
			if(node.left!=null)
				s1.push(node.left);
			if(node.right!=null)
				s1.push(node.right);
		}
		while(!s2.isEmpty()){
			node = s2.pop();
			System.out.println(node.data + " ");
		}
	}
	
	void printLevelOrder()
    {
        int h = height(root);
        System.out.println("Height of tree is :: " + h);
        int i;
        for (i=1; i<=h; i++){
            printGivenLevel(root, i);
        	System.out.println("     ");
        }
    }
	
	void printGivenLevel(TreeNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
	
	int height(TreeNode node){
		if(node == null)
			return 0;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return (Math.max(lheight, rheight) + 1);
	}
	
	void printLevelOrderQueue(){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
	}
	
	boolean identicalTrees(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		if(a!=null && b!=null)
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
		return false;
	}
	
	void mirror(){
		root = mirror(root);
	}
	
	TreeNode mirror(TreeNode node){
		if(node == null)
			return node;
		TreeNode left = mirror(node.left);
		TreeNode right = mirror(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
	
	void printRootToLeafPaths(){
		if(root == null)
			return;
		List<Integer> path = new ArrayList<Integer>();
		printRootToLeafPaths(root, path);
	}
	
	void printRootToLeafPaths(TreeNode root, List<Integer> path){
		path.add(root.data);
		if(isLeaf(root)){
			printPath(path);
			return;
		}
		printRootToLeafPaths(root.left, new ArrayList<Integer>(path));
		printRootToLeafPaths(root.right, new ArrayList<Integer>(path));
	}
	
	boolean isLeaf(TreeNode node){
		return (node.left == null && node.right == null)? true : false;
	}
	
	void printPath(List<Integer> path){
		for(Integer i : path){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	void printLevelOrderSpiral(){
		if(root == null)
			return;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				TreeNode n = s1.pop();
				System.out.print(n.data + " ");
				if(n.right != null)
					s2.push(n.right);
				if(n.left != null)
					s2.push(n.left);
			}
			
			while(!s2.isEmpty()){
				TreeNode n = s2.pop();
				System.out.print(n.data + " ");
				if(n.left!=null)
					s1.push(n.left);
				if(n.right!=null)
					s1.push(n.right);
			}
		}		
	}
	
	boolean checkChildrenSumProperty(TreeNode node){
		
		if(node == null || (node.left == null && node.right == null))
			return true;
		
		return (node.data == (node.left!=null?node.left.data:0) + (node.right!=null?node.right.data:0)) 
				&& checkChildrenSumProperty(node.left) && checkChildrenSumProperty(node.right);	
	}
	
	int getMinDepth(TreeNode node){
		if(node == null)
			return 0;
		if(isLeaf(node))
			return 1;
		int leftDepth = node.left!=null?getMinDepth(node.left):Integer.MAX_VALUE;
		int rightDepth = node.right!=null?getMinDepth(node.right):Integer.MAX_VALUE;
		return Math.min(leftDepth, rightDepth) + 1;		
	}
	
}
