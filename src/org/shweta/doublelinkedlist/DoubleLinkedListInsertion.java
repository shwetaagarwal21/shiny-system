package org.shweta.doublelinkedlist;

public class DoubleLinkedListInsertion {
	
	Node head;
	Node tail;
	
	public static void main(String[] args) {
		DoubleLinkedListInsertion dLinkedList = new DoubleLinkedListInsertion();
		dLinkedList.push(6);
		dLinkedList.push(4);
		dLinkedList.append(8);
		dLinkedList.insertAfter(dLinkedList.head.next, 7);
		dLinkedList.insertBefore(dLinkedList.head.next, 5);
		System.out.println("Created Double Linked List is :: ");
		dLinkedList.printList();
		
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
	
	//Add a node at the end of the linked list.
	public void append(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = null;
		if(head==null){
			head = new_node;
			new_node.prev = null;
			return;
		}
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		last.next = new_node;
		new_node.prev = last;
	}
	
	//Adds a node after a given node
	public void insertAfter(Node prev_node, int new_data){
		if(prev_node == null){
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		new_node.prev = prev_node;
		if(new_node.next.prev != null){
			new_node.next.prev = new_node;
		}
	}
	
	//Adds a node before a given node
	public void insertBefore(Node prev_node, int new_data){
		if(prev_node == null){
			System.out.println("The given next node cannot be null");
			return;
		}
		
		Node new_node = new Node(new_data);
		new_node.prev = prev_node.prev;
		prev_node.prev = new_node;
		new_node.next = prev_node;
		if(new_node.prev.next!=null){
			new_node.prev.next = new_node;
		}		
	}
	

}
