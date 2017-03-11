package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class DeleteNAfterM {
	
	Node head;

	public static void main(String[] args) {
		DeleteNAfterM llist = new DeleteNAfterM();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		llist.head.next.next.next.next.next.next = new Node(7);
		llist.head.next.next.next.next.next.next.next = new Node(8);
		llist.head.next.next.next.next.next.next.next.next = new Node(9);
		llist.head.next.next.next.next.next.next.next.next.next = new Node(10);
		int m = 3, n = 2;
		llist.skipMdeleteN(m,n);
		llist.printList();
	}
	
	void skipMdeleteN(int m, int n){
		Node curr = head;
		Node t = null;
		int count;
		while(curr!=null){
			for(count = 1;count<m && curr!=null; count++){
				curr = curr.next;
			}
			if(curr == null) return;
			t = curr.next;
			for(count = 1;count<=n && t!=null;count++){
				t = t.next;
			}
			curr.next = t;
			curr = t;
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
