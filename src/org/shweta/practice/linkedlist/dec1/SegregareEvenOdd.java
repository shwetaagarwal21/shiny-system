package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class SegregareEvenOdd {
	
	Node head;

	public static void main(String[] args) {
		SegregareEvenOdd llist = new SegregareEvenOdd();
		llist.head = new Node(17);
		llist.head.next = new Node(15);
		llist.head.next.next = new Node(8);
		llist.head.next.next.next = new Node(12);
		llist.head.next.next.next.next = new Node(10);
		llist.head.next.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next.next = new Node(4);
		llist.head.next.next.next.next.next.next.next = new Node(1);
		llist.head.next.next.next.next.next.next.next.next = new Node(7);
		llist.head.next.next.next.next.next.next.next.next.next = new Node(6);
		
		llist.segregateEvenOdd();
		llist.printList();
	}
	
	void segregateEvenOdd(){
		Node end = head, prev = null, curr = head;
		while(end.next!=null)
			end = end.next;
		Node new_end = end;
		
		while(curr.data%2!=0 && curr!=end){
			new_end.next = curr;
			curr = curr.next;
			new_end.next.next = null;
			new_end = new_end.next;
		}
		if(curr.data%2 == 0){
			head = curr;
			while(curr!=end){
				if(curr.data%2==0){
					prev = curr;
					curr = curr.next;
				}else{
					prev.next = curr.next;
					curr.next = null;
					new_end.next = curr;
					new_end = curr;
					curr = prev.next;
				}
			}
		}
		else
			prev = curr;
		
		if(new_end!=end && end.data%2 != 0){
			prev.next = end.next;
			end.next = null;
			new_end.next = end;
		}		
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

