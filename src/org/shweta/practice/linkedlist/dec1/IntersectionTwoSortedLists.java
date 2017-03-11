package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class IntersectionTwoSortedLists {
	
	Node head1;
	Node head2;
	Node head;
	
	public static void main(String[] args) {
		IntersectionTwoSortedLists llist = new IntersectionTwoSortedLists();
		llist.head1 = new Node(1);
		llist.head1.next = new Node(2);
		llist.head1.next.next = new Node(3);
		llist.head1.next.next.next = new Node(4);
		llist.head1.next.next.next.next = new Node(6);
		
		llist.head2 = new Node(2);
		llist.head2.next = new Node(4);
		llist.head2.next.next = new Node(6);
		llist.head2.next.next.next = new Node(8);
		
		Node n = llist.sortedIntersect(llist.head1, llist.head2);
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	Node sortedIntersect(Node node1, Node node2){
		if(node1 == null || node2 == null)
			return null;
		
		if(node1.data < node2.data)
			return sortedIntersect(node1.next, node2);
		if(node1.data > node2.data)
			return sortedIntersect(node1, node2.next);
		Node temp = new Node(node1.data);
		temp.next = sortedIntersect(node1.next, node2.next);
		return temp;
		
	}
	
	//prints the list
	void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
