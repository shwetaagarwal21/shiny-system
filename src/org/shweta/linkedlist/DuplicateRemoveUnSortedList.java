package org.shweta.linkedlist;

import java.util.Hashtable;

/*
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted. 
 * For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.
 * 
 * Solu: Use two loops. 
 * Outer loop is used to pick the elements one by one and inner loop compares the picked element with rest of the elements.
 */
public class DuplicateRemoveUnSortedList {
	
	Node head;
	
	public static void main(String[] args) {
		DuplicateRemoveUnSortedList list = new DuplicateRemoveUnSortedList();
		list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);
 
        System.out.println("Linked List before removing duplicates ");
        list.printList();
        
        //list.remove_duplicatesUsingHashTable();
        list.remove_duplicates();
        System.out.println("");
        System.out.println("Linked List after removing duplicates");
        list.printList();
	}
	
	public void remove_duplicates(){
		Node ptr1 = null, ptr2 = null, dup = null;
		ptr1 = head;
		while(ptr1 != null && ptr1.next != null){
			ptr2 = ptr1;
			
			while(ptr2.next != null){
				if(ptr1.data == ptr2.next.data){
					dup = ptr2.next;
					ptr2.next = ptr2.next.next;
				}else{
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
	}
	
	public void remove_duplicatesUsingHashTable(){
		Hashtable<Integer, Boolean> table = new Hashtable<>();
		Node prev = null;
		Node n = head;
		while(n != null){
			if(table.containsKey(n.data)){
				prev.next = n.next;
			}else{
				table.put(n.data, true);
				prev = n;
			}
			n = n.next;
		}
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
