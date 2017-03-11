package org.shweta.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNextRightLeftOfKey {

	TreeNode root;
	
	public static void main(String[] args) {
		BinaryTreeNextRightLeftOfKey tree = new BinaryTreeNextRightLeftOfKey();
		tree.createSampleTree();
		
		/*TreeNode nextRight = tree.nextLeft(tree.root, 8);
		if(nextRight!=null)
			System.out.println("nextRight of 4 is :: " + nextRight.data);*/
		
		TreeNode nextRight = tree.next(tree.root, 4, false);
		if(nextRight!=null)
			System.out.println("nextRight of 4 is :: " + nextRight.data);
		TreeNode nextLeft = tree.next(tree.root, 4, true);
		if(nextLeft!=null)
			System.out.println("nextLeft of 4 is :: " + nextLeft.data);
	}
	
	TreeNode next(TreeNode node, int key, boolean isLeft){
		if(node == null) return null;
		Queue<TreeNode> qn = new LinkedList<TreeNode>();
		Queue<Integer> ql = new LinkedList<Integer>();
		int level = 0;
		qn.add(node);
		ql.add(level);
		while(!qn.isEmpty()){
			TreeNode n = qn.peek();
			level = ql.peek();
			qn.remove();
			ql.remove();
			if(n.data == key){
				if(qn.size() == 0 || ql.peek() != level)
					return null;
				else
					return qn.peek();
			}
			if(isLeft){
				if(n.right!=null){
					qn.add(n.right);
					ql.add(level+1);
				}
				if(n.left!=null){
					qn.add(n.left);
					ql.add(level+1);
				}				
			}else{
				if(n.left!=null){
					qn.add(n.left);
					ql.add(level+1);
				}
				if(n.right!=null){
					qn.add(n.right);
					ql.add(level+1);
				}
			}
			
		}
		return null;
	}

	TreeNode nextRight(TreeNode node, int key){
		if(node == null) return null;
		Queue<TreeNode> qn = new LinkedList<TreeNode>();
		Queue<Integer> ql = new LinkedList<Integer>();
		int level = 0;
		qn.add(node);
		ql.add(level);
		while(!qn.isEmpty()){
			TreeNode n = qn.peek();
			level = ql.peek();
			qn.remove();
			ql.remove();
			if(n.data == key){
				if(qn.size() == 0 || ql.peek() != level)
					return null;
				else
					return qn.peek();
			}
			if(n.left!=null){
				qn.add(n.left);
				ql.add(level+1);
			}
			if(n.right!=null){
				qn.add(n.right);
				ql.add(level+1);
			}
		}
		return null;
	}
	
	TreeNode nextLeft(TreeNode node, int key){
		if(node == null) return null;
		Queue<TreeNode> qn = new LinkedList<TreeNode>();
		Queue<Integer> ql = new LinkedList<Integer>();
		int level = 0;
		qn.add(node);
		ql.add(level);
		while(!qn.isEmpty()){
			TreeNode n = qn.peek();
			level = ql.peek();
			qn.remove();
			ql.remove();
			if(n.data == key){
				if(qn.size() == 0 || ql.peek() != level)
					return null;
				else
					return qn.peek();
			}			
			if(n.right!=null){
				qn.add(n.right);
				ql.add(level+1);
			}
			if(n.left!=null){
				qn.add(n.left);
				ql.add(level+1);
			}
		}
		return null;
	}
	
	void createSampleTree(){
		root = new TreeNode(10, new TreeNode(2, new TreeNode(8), new TreeNode(4)), new TreeNode(6, null, new TreeNode(5)));
	}
	
}
