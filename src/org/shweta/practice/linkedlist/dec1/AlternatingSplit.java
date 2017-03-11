package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class AlternatingSplit {

	Node head;
	Node head1;
	Node head2;
	
	public static void main(String[] args) {
		AlternatingSplit llist = new AlternatingSplit();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		
		//llist.alternateSplit();

	}
	
/*	void alternateSplit(Node a, Node b){
		Node a = head1;
		Node b = head2;
		Node curr = head.next;
		Node prev = head;
		while(curr!=null){
			a = curr;
			if(curr.next!=null)
				b = curr.next;
			curr = curr.next;
		}
	}
	
	void moveNode(Node node, Node target){
		Node new_node = node;
		node = new_node.next;
		new_node.next = target;
		target = new_node; 
		
		node.next = target;
		target = node;
	}*/

}
