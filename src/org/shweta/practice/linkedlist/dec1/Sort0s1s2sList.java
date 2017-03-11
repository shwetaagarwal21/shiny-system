package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class Sort0s1s2sList {
	
	Node head;

	public static void main(String[] args) {
		Sort0s1s2sList llist = new Sort0s1s2sList();
		llist.head = new Node(0);
		llist.head.next = new Node(1);
		llist.head.next.next = new Node(0);
		llist.head.next.next.next = new Node(2);
		llist.head.next.next.next.next = new Node(1);
		llist.head.next.next.next.next.next = new Node(1);
		llist.head.next.next.next.next.next.next = new Node(2);
		llist.head.next.next.next.next.next.next.next = new Node(1);
		llist.head.next.next.next.next.next.next.next.next = new Node(2);
		
		llist.sortList();
		llist.printList();		
	}
	
	void sortList(){
		int count[] = new int[]{0,0,0};
		Node ptr = head;
		while(ptr!=null){
			count[ptr.data]++;
			ptr = ptr.next;
		}
		int i = 0;
		ptr = head;
		while(ptr!=null){
			if(count[i] == 0)
				i++;
			else{
				ptr.data = i;
				--count[i];
				ptr = ptr.next;
			}
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
