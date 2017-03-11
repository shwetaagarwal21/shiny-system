package org.shweta.linkedlist;

public class DeleteAlternateNodes {
	
	Node head;
	
	public static void main(String[] args) {
		DeleteAlternateNodes llist = new DeleteAlternateNodes();
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		System.out.println("Given list is :: ");
		llist.printList();
		System.out.println();
		System.out.println("List after deleting alternate nodes is :: ");
		llist.removeAlternateNodes();
		llist.printList();
	}
	
	void removeAlternateNodes(){
		if(head == null)
			return;
		
		Node prev = head;
		Node curr = head.next;
		
		while(prev != null && curr != null){
			prev.next = curr.next;
			curr = null;
			prev = prev.next;
			if(prev != null)
				curr = prev.next;
		}
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
