package org.shweta.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class QItem{
	TreeNode node;
	int hd;
	QItem(TreeNode n, int h){
		this.node = n;
		this.hd = h;
	}
}

public class BinaryTreeTopBottomView {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeTopBottomView tree = new BinaryTreeTopBottomView();
		tree.createSampleTree();
		System.out.println("Top View is :: ");
		tree.printTopView();
		System.out.println();
		System.out.println("Bottom View is :: ");
		tree.printBottomView();
	}
	
	void printTopView(){
		if(root == null)
			return;
		
		HashSet<Integer> set = new HashSet<>();
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0));
		while(!Q.isEmpty()){
			QItem qi = Q.remove();
			int hd = qi.hd;
			TreeNode n = qi.node;
			
			if(!set.contains(hd)){
				set.add(hd);
				System.out.print(n.data + " ");
			}
			
			if(n.left!=null)
				Q.add(new QItem(n.left, hd - 1));
			if(n.right!=null)
				Q.add(new QItem(n.right, hd + 1));			
		}		
	}
	
	void printBottomView(){
		if(root == null)
			return;
		
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0));
		while(!Q.isEmpty()){
			QItem qi = Q.remove();
			TreeNode n = qi.node;
			int hd = qi.hd;
			map.put(qi.hd, n.data);
			if(n.left!=null)
				Q.add(new QItem(n.left, hd - 1));
			if(n.right!=null)
				Q.add(new QItem(n.right, hd + 1));
		}
		
		Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();		
		while(iterator.hasNext()){
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}
	}
	
	void createSampleTree(){
		//root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))), new TreeNode(3));
		root = new TreeNode(20, new TreeNode(8, new TreeNode(5), new TreeNode(3, new TreeNode(10), new TreeNode(14))), new TreeNode(22, new TreeNode(4), new TreeNode(25)));
	}

}
