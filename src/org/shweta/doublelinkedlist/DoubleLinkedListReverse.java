package org.shweta.doublelinkedlist;

public class DoubleLinkedListReverse {
	
	Node head;
	Node tail;
	
	public static void main(String[] args) {
		DoubleLinkedListReverse dLinkedList = new DoubleLinkedListReverse();
		dLinkedList.push(2);
		dLinkedList.push(4);
		dLinkedList.push(8);
		dLinkedList.push(10);
		System.out.println("Created Double Linked List is :: ");
		dLinkedList.printList();
		
		dLinkedList.reverse();
		System.out.println();
		System.out.println("The reversed Linked List is :: ");
		dLinkedList.printList();

	}
	
	public void reverse(){
		Node temp = null;
		Node current = head;
		
		while(current!=null){
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		
		if(temp!=null){
			head = temp.prev;
		}
	}
	
	public void printList(){
		Node current = head;
		Node last = null;
		System.out.println("Traversal in forward direction:: ");
		while(current!=null){
			System.out.print(current.data + " ");
			last = current;
			current = current.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction:: ");
		while(last!=null){
			System.out.print(last.data + " ");
			last=last.prev;
		}
		System.out.println();
	}
	
	//Add a node at the front of the linked list.
	public void push(int new_data){
		Node new_node = new Node(new_data);
		if(head == null){
			new_node.next = null;
			new_node.prev = null;
			head = new_node;
			tail = new_node;
		}else{
			head.prev = new_node;
			new_node.next = head;
			new_node.prev = null;
			head = new_node;
		}
	}
	
}
