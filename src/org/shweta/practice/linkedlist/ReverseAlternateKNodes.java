package org.shweta.practice.linkedlist;

public class ReverseAlternateKNodes {
	
	Node head;
	
	public static void main(String[] args) {
		ReverseAlternateKNodes llist = new ReverseAlternateKNodes();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		llist.head.next.next.next.next.next.next = new Node(7);
		llist.head.next.next.next.next.next.next.next = new Node(8);
		llist.head.next.next.next.next.next.next.next.next = new Node(9);
		llist.head.next.next.next.next.next.next.next.next.next = new Node(10);
		llist.reverseAlternateNodes(3);
		System.out.println("List is :: ");
		llist.printList(llist.head);
	}
	
	void printList(Node node){
		if(node == null) return;
		while(node!=null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	void reverseAlternateNodes(int k){
		if(head == null || head.next == null || k < 2){
			return;
		}
		head = reverseAltKNodes(head, k);
	}
	
	Node reverseAltKNodes(Node head, int k){
	    if(head == null || head.next == null || k < 2)
	        return head;
	    Node temp = head;
	    int count = 0;
	    while(temp != null && count < k){
	        temp = temp.next;
	        count++; 
	    }
	    head = reverseList(head, k);
	    Node next = head;
	    while(next.next!=null)
	        next = next.next;
	    next.next = temp;
	    
	    int i = 0;
	    Node prev = null;
	    while(i<k && temp!=null){
	        prev = temp;
	        temp = temp.next;
	        i++;        
	    }
	    
	    if(temp!=null)
	        prev.next = reverseAltKNodes(temp, k);

	    return head;
	}

	Node reverseList(Node node, int k){
	    Node prev = null;
	    Node curr = null;
	    Node next = node;
	    int i = 0;
	    while(next != null && i < k){
	        curr = next;
	        next = curr.next;
	        curr.next = prev;
	        prev = curr;
	        i++;
	    }
	    head = curr;
	    return head;
	}
	
}
