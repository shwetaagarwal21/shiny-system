package org.shweta.practice;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeDiagonalSum {
	
	TreeNode root;
	
	public static void main(String[] args) {
		BinaryTreeDiagonalSum tree = new BinaryTreeDiagonalSum();
		tree.createSampleTree();
		HashMap<Integer, Integer> diagSum = new HashMap<>();
		tree.computeDiagonalSum(diagSum);
		
		for(Map.Entry<Integer, Integer> entry: diagSum.entrySet()){
			System.out.println("Diagonal sum for level " + entry.getKey() + " : " + entry.getValue());
		}		
	}
	
	void computeDiagonalSum(HashMap<Integer, Integer> diagSum){
		computeDiagonalSum(root, 0, diagSum);
	}
	
	void computeDiagonalSum(TreeNode node, int currDiag, HashMap<Integer, Integer> diagSum){
		if(node == null) return;
		
		computeDiagonalSum(node.left, currDiag + 1, diagSum);
		int prevSum = diagSum.get(currDiag) != null ? diagSum.get(currDiag) : 0;
		diagSum.put(currDiag, prevSum + node.data);
		computeDiagonalSum(node.right, currDiag, diagSum);
		
	}
	
	void createSampleTree(){
		root = new TreeNode(0, new TreeNode(1, new TreeNode(4), new TreeNode(5, new TreeNode(7))), new TreeNode(2, new TreeNode(3), new TreeNode(6)));
	}

}
