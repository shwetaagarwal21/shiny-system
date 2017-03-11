package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class Merge2LinkedListAtAlternatePositions {
	
	Node head1;
	Node head2;
	Node head3;
	
	public static void main(String[] args) {
		Merge2LinkedListAtAlternatePositions llist = new Merge2LinkedListAtAlternatePositions();
		llist.head1 = new Node(1);
		llist.head1.next = new Node(2);
		llist.head1.next.next = new Node(3);
		
		llist.head2 = new Node(4);
		llist.head2.next = new Node(5);
		llist.head2.next.next = new Node(6);
		llist.head2.next.next.next = new Node(7);
		llist.head2.next.next.next.next = new Node(8);
		
		llist.merge(llist.head1, llist.head2);
		System.out.println("First Linked List::");
		llist.printList(llist.head1);
		
		System.out.println();
		System.out.println("Second Linked List::");
		llist.printList(llist.head2);
		
		llist.head3 = new Node(1);
		llist.head3.next = new Node(2);
		llist.head3.next.next = new Node(3);
		llist.head3.next.next.next = new Node(4);
		llist.head3.next.next.next.next = new Node(5);
		llist.head3.next.next.next.next.next = new Node(6);
		llist.head3.next.next.next.next.next.next = new Node(7);
		
		System.out.println();
		Node n = llist.pairwiseSwap(llist.head3);
		llist.printList(n);		
	}
	
	void merge(Node p, Node q){
		Node p_curr = p, q_curr = q;
		Node p_next = null, q_next = null;
		while(p_curr!=null && q_curr!=null){
			p_next = p_curr.next;
			q_next = q_curr.next;
			
			p_curr.next = q_curr;
			q_curr.next = p_next;
			
			p_curr = p_next;
			q_curr = q_next;			
		}
		head2 = q_curr;
	}
	
	//prints the list
	void printList(Node node){
		Node n = node;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	Node pairwiseSwap(Node node){
		if(node == null || node.next == null) return null;
		
		Node prev = node;
		Node curr = node.next;
		
		node = curr;
		
		while(prev!=null && curr!=null){
			Node next = curr.next;
			curr.next = prev;
			
			if(next == null || next.next == null){
				prev.next = next;
				break;
			}
			
			prev.next = next.next;
			
			prev = next;
			curr = prev.next;			
		}
		return node;
	}
	
}
