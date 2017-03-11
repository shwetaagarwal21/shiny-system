package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class DetectAndRemoveLoop {
	
	Node head;
	
	public static void main(String[] args) {
		DetectAndRemoveLoop llist = new DetectAndRemoveLoop();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = llist.head.next;
		llist.detectAndRemoveLoop();
		llist.printList();
	}
	
	void detectAndRemoveLoop(){
		Node slow = head;
		Node fast = head.next;
		while(fast!=null && fast.next!=null){
			if(slow == fast)
				break;
			slow = slow.next;
			fast = fast.next.next;			
		}
		if(slow == fast){
			slow = head;
			while(slow!=fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
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
