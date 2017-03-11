package org.shweta.doublelinkedlist;

public class DoubleLinkedListDeletion {
	
	Node head;
	Node tail;
	
	public static void main(String[] args) {
		DoubleLinkedListDeletion dLinkedList = new DoubleLinkedListDeletion();
		dLinkedList.push(2);
		dLinkedList.push(4);
		dLinkedList.push(8);
		dLinkedList.push(10);
		System.out.println("Created Double Linked List is :: ");
		dLinkedList.printList();
		dLinkedList.deleteNode(dLinkedList.head);
		dLinkedList.deleteNode(dLinkedList.head.next);
		dLinkedList.deleteNode(dLinkedList.head.next);
		System.out.println("Modified Double Linked List is :: ");
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
	
	//deletes a node
	public void deleteNode(Node node){
		if(head == null || node == null)
			return;
		if(head == node)
			head = node.next;
		if(node.next!=null)
			node.next.prev = node.prev;
		if(node.prev!=null)
			node.prev.next = node.next;
	}

}
