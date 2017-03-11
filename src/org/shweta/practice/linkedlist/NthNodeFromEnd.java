package org.shweta.practice.linkedlist;

public class NthNodeFromEnd {
	
	Node head;

	public static void main(String[] args) {
		NthNodeFromEnd llist = new NthNodeFromEnd();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		llist.head.next.next.next.next.next.next = new Node(7);
		llist.head.next.next.next.next.next.next.next = new Node(8);
		llist.head.next.next.next.next.next.next.next.next = new Node(9);
		llist.head.next.next.next.next.next.next.next.next.next = new Node(10);
		Node n = llist.getNthFromEnd(4);		
		System.out.println("Node is :: " + n.data);
	}
	
	Node getNthFromEnd(int k){
		Node slow = head;
		Node fast = head;
		int count = 0;
		while(count < k && slow!=null){
			slow = slow.next;
			count++;		
		}
		while(slow!=null){
			slow = slow.next;
			fast = fast.next;		
		}
		return fast;
	}

}
