package org.shweta.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrder {
	
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeVerticalOrder tree = new BinaryTreeVerticalOrder();
		tree.createSampleTree();
		System.out.println("Tree in Vertical Order is :: ");
		tree.printVerticalOrder();
		System.out.println();
		System.out.println("Vertical Sum in Tree is :: ");
		tree.printVerticalSum();

	}
	
	void printVerticalOrder(){
		if(root == null)
			return;
		
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		ArrayList<Integer> mapEntry;
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0));
		while(!Q.isEmpty()){
			QItem qi = Q.remove();
			TreeNode n = qi.node;
			int hd = qi.hd;
			mapEntry = (ArrayList<Integer>)map.get(hd);
			if(mapEntry != null){
				mapEntry.add(n.data);
				map.put(hd, mapEntry);
			}else{
				mapEntry = new ArrayList<>();
				mapEntry.add(n.data);
				map.put(hd, mapEntry);			
			}
			if(n.left!=null)
				Q.add(new QItem(n.left, hd - 1));
			if(n.right!=null)
				Q.add(new QItem(n.right, hd + 1));
		}
		
		Iterator<Entry<Integer, ArrayList<Integer>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, ArrayList<Integer>> mapEntry2 = iterator.next();
			ArrayList<Integer> nodeList = mapEntry2.getValue();
			for(Integer i: nodeList){
				System.out.print(i + " ");
			}
			/*for (int i = 0; i < nodeList.size(); i++)
            {
				System.out.print(nodeList.get(i) + "  ");
			}*/
			System.out.println();
		}
	}
	
	void printVerticalSum(){
		if(root == null)
			return;
		
		Map<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> mapEntry;
		Queue<QItem> Q = new LinkedList<QItem>();
		Q.add(new QItem(root, 0));
		while(!Q.isEmpty()){
			QItem qi = Q.remove();
			TreeNode n = qi.node;
			int hd = qi.hd;
			Integer in = map.get(hd);
			if(in != null){
				map.put(hd, n.data + in.intValue());
			}else{
				map.put(hd, n.data);
			}
			//mapEntry = (ArrayList<Integer>)map.get(hd);
			/*if(mapEntry != null){
				mapEntry.add(n.data);
				map.put(hd, mapEntry);
			}else{
				mapEntry = new ArrayList<>();
				mapEntry.add(n.data);
				map.put(hd, mapEntry);			
			}*/
			if(n.left!=null)
				Q.add(new QItem(n.left, hd - 1));
			if(n.right!=null)
				Q.add(new QItem(n.right, hd + 1));
		}
		
		/*Iterator<Entry<Integer, ArrayList<Integer>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Integer, ArrayList<Integer>> mapEntry2 = iterator.next();
			ArrayList<Integer> nodeList = mapEntry2.getValue();
			for(Integer i: nodeList){
				System.out.print(i + " ");
			}
			for (int i = 0; i < nodeList.size(); i++)
            {
				System.out.print(nodeList.get(i) + "  ");
			}
			System.out.println();
		}*/
		/*Set<Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = set.iterator();		
		while(iterator.hasNext()){
			Map.Entry<Integer, Integer> me = iterator.next();
			System.out.print(me.getValue() + " ");
		}*/
		if(map!=null)
			System.out.println(map.entrySet());
	}
	
	void createSampleTree(){
		root = new TreeNode(3, new TreeNode(4, new TreeNode(6), new TreeNode(7, null, new TreeNode(1))), new TreeNode(5, new TreeNode(8), new TreeNode(9)));
	}
	
}
