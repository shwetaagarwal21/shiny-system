package org.shweta.linkedlist;
/*
 * Function that moves last element to front in a given Singly Linked List. 
 * For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.
 * 
 * Solution: Traverse the list till last node. 
 * Use two pointers: one to store the address of last node and other for address of second last node. 
 * After the end of loop do following operations.
i) Make second last as last (secLast->next = NULL).
ii) Set next of last as head (last->next = *head_ref).
iii) Make last as head ( *head_ref = last)
 */

public class MoveLastElementInFront {
	Node head;
	
	public static void main(String[] args) {
		MoveLastElementInFront llist = new MoveLastElementInFront();
		
		llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        
        System.out.println("Linked List before moving last to front ");
        llist.printList();
        
        System.out.println();
        llist.moveToFront();
         
        System.out.println("Linked List after moving last to front ");
        llist.printList();
	}
	
	public void moveToFront(){
		if(head == null || head.next == null)
			return;
		
		Node last = head;
		Node secLast = null;
		while(last.next!=null){
			secLast = last;
			last = last.next;
		}
		secLast.next = null;
		last.next = head;
		head = last;
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
