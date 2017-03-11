package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;



public class ReverseEveryKNodes {
	
	Node head;
	
	public static void main(String[] args){
		ReverseEveryKNodes llist = new ReverseEveryKNodes();
		
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		
		llist.reverse(4);
		llist.printList();
		System.out.println();
		
		llist.reverseAlternate(2);
		System.out.println();
		llist.printList();
	}
	
	//reverse alternate k nodes
	void reverseAlternate(int k){
		head = reverseAlternate(head, k);
	}
	
	Node reverseAlternate(Node head, int k){
		Node prev = null, curr = null;
		Node next = head;
		int count = 0;
		while(next!=null && count<k){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			count++;
		}

		if(head!=null){
			head.next = next;
		}
		
		count = 0;
		while(count < k-1 && next!=null){
			count++;
			next = next.next;
		}

		if(next!=null)
			next.next = reverseAlternate(next.next, k);
		return prev;
	}
	
	//reverse a list in groups of k
	void reverse(int k){
		head = reverse(head, k);
	}
	
	Node reverse(Node head, int k){
		Node prev = null, curr = null;
		Node next = head;
		int count = 0;
		while(next!=null && count < k){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			count++;
		}
		if(next!=null)
			head.next = reverse(next, k);
		return prev;
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
