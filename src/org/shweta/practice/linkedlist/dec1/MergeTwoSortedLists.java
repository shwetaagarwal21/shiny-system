package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class MergeTwoSortedLists {
	
	Node head;
	Node head1;
	Node head2;
	Node head3;
	Node head4;
	Node head5;

	public static void main(String[] args) {
		MergeTwoSortedLists llist = new MergeTwoSortedLists();
		llist.head1 = new Node(2);
		llist.head1.next = new Node(4);
		llist.head1.next.next = new Node(5);
		llist.head1.next.next.next = new Node(6);
		llist.head1.next.next.next.next = new Node(8);
		llist.head1.next.next.next.next.next = new Node(9);
		
		llist.head2 = new Node(1);
		llist.head2.next = new Node(3);
		llist.head2.next.next = new Node(7);
		
		llist.head = llist.sortedMerge(llist.head1, llist.head2);
		System.out.println("List after merging is :: ");
		llist.printList(llist.head);
		
		llist.head3 = new Node(2);
		llist.head3.next = new Node(4);
		llist.head3.next.next = new Node(5);
		llist.head3.next.next.next = new Node(6);
		llist.head3.next.next.next.next = new Node(8);
		llist.head3.next.next.next.next.next = new Node(9);
		
		llist.head4 = new Node(1);
		llist.head4.next = new Node(3);
		llist.head4.next.next = new Node(7);
		//llist.head  = null;
		llist.sortedMergeIter(llist.head3, llist.head4);
		System.out.println();
		System.out.println("List after merging using recursion is :: ");
		llist.printList(llist.head);
	}
	
	void sortedMergeIter(Node node1, Node node2){
		if(node1 == null && node2 == null) return;
		if(node1 == null) head5 = node2;
		if(node2 == null) head5 = node1;
		Node temp1 = node1, temp2 = node2;
		if(temp1.data < temp2.data){
			head5 = temp1;
			temp1 = temp1.next;
		}else{
			head5 = temp2;
			temp2 = temp2.next;
		}
		Node node = head5;
		while(temp1!=null && temp2!=null){
			if(temp1.data < temp2.data){
				node.next = temp1;
				temp1 = temp1.next;
			}else{
				node.next = temp2;
				temp2 = temp2.next;
			}
		}
		if(temp1!=null)
			node.next = temp1;
		else 
			node.next = temp2;		
	}
	
	
	Node sortedMerge(Node node1, Node node2){
		if(node1 == null && node2 == null) return null;
		if(node1 == null) return node2;
		if(node2 == null) return node1;
		Node node;
		if(node1.data < node2.data){
			node = node1;
			node.next = sortedMerge(node1.next, node2);
		}else{
			node = node2;
			node.next = sortedMerge(node1, node2.next);
		}
		return node;
	}
	
	void printList(Node n){
		if(n == null) return;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
