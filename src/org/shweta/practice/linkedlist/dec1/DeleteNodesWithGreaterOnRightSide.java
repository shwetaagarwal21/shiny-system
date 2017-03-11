package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class DeleteNodesWithGreaterOnRightSide {
	
	Node head;

	public static void main(String[] args) {
		DeleteNodesWithGreaterOnRightSide llist = new DeleteNodesWithGreaterOnRightSide();
		llist.head = new Node(12);
		llist.head.next = new Node(15);
		llist.head.next.next = new Node(10);
		llist.head.next.next.next = new Node(11);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		llist.head.next.next.next.next.next.next = new Node(2);
		llist.head.next.next.next.next.next.next.next = new Node(3);
		
		llist.delLesserNodes();
		llist.printList();

	}
	
	void delLesserNodes(){
		reverse();
		_delLesserNodes();
		reverse();
	}
	
	void _delLesserNodes(){
		Node curr = head, max = head, tmp = null;
		while(curr!=null && curr.next!=null){
			if(max.data > curr.next.data){
				tmp = curr.next;
				curr.next = tmp.next;
				tmp = null;
				//curr.next = curr.next.next;
			}else{
				curr = curr.next;
				max = curr;
			}			
		}
	}

	//reverse a linked list
	void reverse(){
		if(head == null) return;
		Node curr = null;
		Node prev = null;
		Node next = head;
		while(next!=null){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
		}
		head = prev;
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
