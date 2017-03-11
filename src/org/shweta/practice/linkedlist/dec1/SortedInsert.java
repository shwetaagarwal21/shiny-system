package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class SortedInsert {
	
	Node head;

	public static void main(String[] args) {
		SortedInsert llist = new SortedInsert();
		llist.head = new Node(2);
		llist.head.next = new Node(5);
		llist.head.next.next = new Node(7);
		llist.head.next.next.next = new Node(10);
		llist.head.next.next.next.next = new Node(15);
		
		llist.sortedInsert(9);
		llist.printList();

	}
	
	void sortedInsert(int d){
		Node curr;
		if(head == null || head.data > d){
			Node n = new Node(d);
			n.next = head;
			head = n;
		}else{
			curr = head;
			while(curr.next!=null && curr.next.data < d){
				curr = curr.next;
			}
			Node nd = new Node(d);
			nd.next = curr.next;
			curr.next = nd;
		}		
	}
	
	void printList(){
		if(head == null) return;
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
