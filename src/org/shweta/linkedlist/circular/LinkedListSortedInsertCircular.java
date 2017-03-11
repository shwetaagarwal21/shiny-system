package org.shweta.linkedlist.circular;

import org.shweta.linkedlist.Node;

public class LinkedListSortedInsertCircular {
	
	Node head = null;
	
	public static void main(String[] args) {
		LinkedListSortedInsertCircular llist = new LinkedListSortedInsertCircular();
		
		int arr[] = new int[] {12, 56, 2, 11, 1, 90};
		Node temp = null;
		for (int i = 0; i < 6; i++)
        {
            temp = new Node(arr[i]);
            llist.sortedInsert(temp);
        }
		System.out.println("Circular linked list is:: ");
		llist.printList();

	}
	
	public void sortedInsert(Node new_node){
		Node current = head;
		if(current == null){
			new_node.next = new_node;
			head = new_node;
		}
		
		else if(current.data >= new_node.data){
			while(current.next != head)
				current = current.next;
			current.next = new_node;
			new_node.next = head;
			head = new_node;
		}
		
		else{
			while(current.next != head && current.next.data < new_node.data)
				current = current.next;
			new_node.next = current.next;
			current.next = new_node;
		}
		
	}
	
	//print the elements in linked list
	public void printList(){
		if(head!=null){
			Node n = head;
			do{
				System.out.print(n.data + " ");
				n = n.next;
			}while(n!=head);
		}
		System.out.println();
	}

}
