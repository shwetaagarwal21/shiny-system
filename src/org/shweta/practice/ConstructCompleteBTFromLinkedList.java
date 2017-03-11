package org.shweta.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructCompleteBTFromLinkedList {
	
	class ListNode{
		int data;
		ListNode next;
		ListNode(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	class BinaryTreeNode{
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;
		BinaryTreeNode(int d) {
			this.data = d;
			this.left = this.right = null;
		}
	}
	
	ListNode head;
	BinaryTreeNode root;

	public static void main(String[] args) {
		ConstructCompleteBTFromLinkedList tree = new ConstructCompleteBTFromLinkedList();
		tree.createLinkedList();
		BinaryTreeNode node = tree.convertLinkedListToBinary(tree.root);
		tree.printInOrder(node);
	}
	
	BinaryTreeNode convertLinkedListToBinary(BinaryTreeNode node){
		Queue<BinaryTreeNode> Q = new LinkedList<BinaryTreeNode>();
		if(head == null){
			node = null;
			return node;
		}
		node = new BinaryTreeNode(head.data);
		Q.add(node);
		head = head.next;
		BinaryTreeNode left = null; 
		BinaryTreeNode right = null;
		while(head!=null){
			BinaryTreeNode parent = Q.poll();
			left = null; right = null;
			left = new BinaryTreeNode(head.data);
			Q.add(left);
			head = head.next;
			if(head!=null){
				right = new BinaryTreeNode(head.data);
				Q.add(right);
				head = head.next;
			}
			parent.left = left;
			parent.right = right;
		}
		return node;	
	}
	
	void createLinkedList(){
		head = new ListNode(10);
		head.next = new ListNode(12);
		head.next.next = new ListNode(15);
		head.next.next.next = new ListNode(25);
		head.next.next.next.next = new ListNode(30);
		head.next.next.next.next.next = new ListNode(36);
	}
	
	void printInOrder(BinaryTreeNode n){
		if(n == null) return;
		printInOrder(n.left);
		System.out.print(n.data + " ");
		printInOrder(n.right);
	}

}
