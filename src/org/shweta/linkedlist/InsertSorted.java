package org.shweta.linkedlist;

public class InsertSorted {
	
	Node head;

	public static void main(String[] args) {
		InsertSorted list = new InsertSorted();
		list.push(15);
		list.push(10);
		list.push(7);
		list.push(5);
		list.push(2);
		System.out.println("Linked list is ");
		list.printList();
		Node n = new Node(9);
		list.sortedInsert(n);
		System.out.println("Linked list after insertion is");
		list.printList();
	}
	
	void sortedInsert(Node new_node){
		Node current;
		if(head == null || head.data >= new_node.data){
			new_node.next = head;
			head = new_node;
		}else{
			current = head;
			while(current.next != null && current.next.data < new_node.data)
				current = current.next;
			new_node.next = current;
			current.next = new_node;
		}		
	}
	
	public void push(int new_data){
		Node n = new Node(new_data);
		n.next = head;
		head = n;
	}
	
	public void printList(){
		Node n = head;
		while(n != null){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

}
