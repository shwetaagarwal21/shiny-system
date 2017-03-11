package org.shweta.practice;

import java.util.ArrayList;

class Passing {	 
    int i;
    int m = 0;
    int n = 0;
}

public class BinaryTreeSubtreeCheck {
	
	TreeNode root1;
	TreeNode root2;
	Passing p = new Passing();

	public static void main(String[] args) {
		BinaryTreeSubtreeCheck tree = new BinaryTreeSubtreeCheck();
		tree.createSampleTrees();
		boolean isSubtree = tree.isSubtree(tree.root1, tree.root2);
		System.out.println("Using First method:: " + isSubtree);
		boolean isSubTree2 = tree.isSubtree2(tree.root1, tree.root2);
		System.out.println("Using Second method:: " + isSubTree2);

	}
	
	//Returns true if S is a subtree of T, else false
	boolean isSubtree2(TreeNode T, TreeNode S){
		if(S == null) return true;
		if(T == null) return false;
		int inT[] = new int[100];
		String op1 = String.valueOf(inT);
		int inS[] = new int[100];
        String op2 = String.valueOf(inS);
        storeInOrder(T, inT, p);
        storeInOrder(S, inS, p);
        System.out.println("In Order Array of T is ");
        printInOrderArray(inT);
        System.out.println();
        System.out.println("In Order Array of S is ");
        printInOrderArray(inS);
        System.out.println();
        
        if(substr(op1,op2)!=null) return false;
        
        int preT[] = new int[100];
		String op3 = String.valueOf(preT);
		int preS[] = new int[100];
        String op4 = String.valueOf(preS);
        storePreOrder(T, preT, p);
        storePreOrder(S, preS, p);
        
        return substr(op3, op4)!=null;
	}
	
	void printInOrderArray(int[] arr){
		for(int x=0;x<arr.length;x++){
        	System.out.print(arr[x]);
        }
	}
	
	String substr(String str1, String str2){
		if(str1 == null || str2 == null) return null;
		int str1Len = str1.length();
		int str2Len = str2.length();
		if(str1Len<str2Len)
			return null;
		if(str2Len == 0)
			return str1;
		
		for(int i = 0; i<= str1Len - str2Len;i++){
			if(str1.charAt(i) == str2.charAt(0)){
				int j = 0;
				for(;j<str2Len;j++){
					if(str1.charAt(i+j) != str2.charAt(j)){
						break;
					}
				}
				if(j==str2Len){
					return str1.substring(i);
				}
			}
		}
		return null;		
	}
	
	void storeInOrder(TreeNode node, int arr[], Passing i){
		if(node == null) return;
		storeInOrder(node.left, arr, i);
		arr[i.i++] = node.data;
		storeInOrder(node.right, arr, i);
	}
	
	void storePreOrder(TreeNode node, int arr[], Passing i){
		if(node == null) return;
		arr[i.i++] = node.data;
		storePreOrder(node.left, arr, i);
		storePreOrder(node.right, arr, i);
	}
	
	//Returns true if S is a subtree of T, else false
	boolean isSubtree(TreeNode T, TreeNode S){
		if(S == null) return true;
		if(T == null) return false;
		
		if(identicalTrees(T, S)) return true;
		return isSubtree(T.left, S) || isSubtree(T.right, S);		
	}
	
	boolean identicalTrees(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		if(a!=null && b!=null)
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));
		return false;
	}
	
	void createSampleTrees(){
		root1 = new TreeNode(26, new TreeNode(10, new TreeNode(4, null, new TreeNode(30)), new TreeNode(6)), new TreeNode(3, null, new TreeNode(3)));
		root2 = new TreeNode(10, new TreeNode(4, null, new TreeNode(30)), new TreeNode(6));
	}

}
