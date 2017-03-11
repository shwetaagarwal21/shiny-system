package org.shweta.linkedlist;

public class LinkedList2 {

	Node head;
	
	public static void main(String[] args) {
		LinkedList2 llist = new LinkedList2();
		llist.push(15);
		llist.push(10);
		llist.push(7);
		llist.push(5);
		llist.push(2);
		llist.printList();
		
		llist.sortedInsert(new Node(9));
		System.out.println("Given list is " );
		llist.printList();
		
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
	
	public void sortedInsert(Node new_node){
		Node current;
		if(head == null || head.data >= new_node.data){
			new_node.next = head;
			head = new_node;
		}else{
			current = head;
			while(current.next!=null && current.next.data < new_node.data)
				current = current.next;
			new_node.next = current.next;
			current.next = new_node;
		}
		
	}

}
