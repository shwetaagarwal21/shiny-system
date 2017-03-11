package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class SortLinkedList {
	
	Node head;

	public static void main(String[] args) {
		SortLinkedList llist = new SortLinkedList();
		llist.head = new Node(10);
		llist.head.next = new Node(40);
		llist.head.next.next = new Node(53);
		llist.head.next.next.next = new Node(30);
		llist.head.next.next.next.next = new Node(67);
		llist.head.next.next.next.next.next = new Node(12);
		llist.head.next.next.next.next.next.next = new Node(89);
		
		llist.sort();
		llist.printList();
	}
	
	void sort(){
		Node Ahead = new Node(0);
		Node Dhead = new Node(0);
		splitList(Ahead, Dhead);
		Ahead = Ahead.next;
		Dhead = Dhead.next;		
		Dhead = reverse(Dhead);
		head = mergeList(Ahead, Dhead);
	}
	
	void splitList(Node Ahead, Node Dhead){
		Node ascn = Ahead, dscn = Dhead, curr = head;
		while(curr != null){
			ascn.next = curr;
			ascn = ascn.next;
			curr = curr.next;
			if(curr!=null){
				dscn.next = curr;
				dscn = dscn.next;
				curr = curr.next;
			}
		}
		ascn.next = null;
		dscn.next = null;
	}
	
	Node mergeList(Node head1, Node head2){
		if(head1==null) return head2;
		if(head2==null) return head1;
		Node temp = null;
		if(head1.data < head2.data){
			temp = head1;
			head1.next = mergeList(head1.next, head2);
		}else{
			temp = head2;
			head2.next = mergeList(head1, head2.next);
		}
		return temp;
	}

	//reverse a linked list
	Node reverse(Node node){
		if(node == null) return null;
		Node curr = null;
		Node prev = null;
		Node next = node;
		while(next!=null){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
		}
		node = prev;
		return node;
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
