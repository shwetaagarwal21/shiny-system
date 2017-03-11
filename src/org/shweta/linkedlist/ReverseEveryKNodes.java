package org.shweta.linkedlist;

public class ReverseEveryKNodes {
	
	Node head;

	public static void main(String[] args) {
		ReverseEveryKNodes llist = new ReverseEveryKNodes();
		llist.push(8);
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		System.out.println("Given list is :: ");
		llist.printList();
		System.out.println();
		System.out.println("Reversed list is :: ");
		llist.reverse(3);
		llist.printList();
		System.out.println();
/*		System.out.println("Reverse alternate 3 nodes is::");
		llist.reverseAlternate(3);
		llist.printList();*/
	}
	
/*	public void reverseAlternate(int k){
		head = reverseAlternateUtil(head, k);
	}*/
	
	public void reverse(int k){
		head = reverseUtil(head, k);
	}
	
/*	public Node reverseAlternateUtil(Node head, int k){
		Node curr = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		int i = 0;
		if(i < k && next != null){
			i++;
			next = next.next;
		}
		System.out.println(" next data is::  " + next.data);
		
		if(next != null)
			head.next = reverseAlternateUtil(curr.next, k);			
		
		return prev;
	}*/
	
	public Node reverseUtil(Node head, int k){
		Node curr = head;
		Node prev = null;
		Node next = null;
		int count = 0;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null)
			head.next = reverseUtil(next, k);
		
		return prev; 
	}
	
	public void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	//print the elements in linked list
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
