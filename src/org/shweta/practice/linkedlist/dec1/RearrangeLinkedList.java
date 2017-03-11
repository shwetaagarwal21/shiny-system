package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class RearrangeLinkedList {
	
	Node head;
	Node head1;

	public static void main(String[] args) {
		RearrangeLinkedList llist = new RearrangeLinkedList();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		
		llist.rearrange(llist.head);
		llist.printList(llist.head);
		
		System.out.println();
		llist.head1 = new Node(1);
		llist.head1.next = new Node(2);
		llist.head1.next.next = new Node(3);
		llist.head1.next.next.next = new Node(4);
		llist.head1.next.next.next.next = new Node(5);
		llist.head1 = llist.rearrangeEvenOdd(llist.head1);
		llist.printList(llist.head1);
	}
	
	Node rearrangeEvenOdd(Node head){
		if(head == null) return null;
		Node odd = head;
		Node even = head.next;
		Node even_first = head.next;
		while(true){
			if(odd==null || even==null || even.next==null){
				odd.next = even_first;
				break;
			}
			odd.next = even.next;
			odd = even.next;
			if(odd.next == null){
				even.next = null;
				odd.next = even_first;
				break;
			}
			even.next = odd.next;
			even = odd.next;			
		}
		return head;
	}
	
	void rearrange(Node node){
		Node slow = node, fast = node.next;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node node1 = node;
		Node node2 = slow.next;
		slow.next = null;
		
		node2 = reverse(node2);
		node = new Node(0);
		
		Node curr = node;
		while(node1!=null || node2!=null){
			if(node1!=null){
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}
			if(node2!=null){
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
		}
		node = node.next;
	}
	
	//reverse a linked list
	Node reverse(Node node){
		if(node == null) return null;
		Node curr = null;
		Node prev = null;
		Node next = node;
		while(next!=null){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
		}
		node = prev;
		return node;
	}
	
	//prints the list
	void printList(Node node){
		Node n = node;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}
