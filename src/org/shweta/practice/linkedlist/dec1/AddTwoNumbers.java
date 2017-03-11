package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class AddTwoNumbers {
	
	Node head;
	Node head1;
	Node head2;
	
	public static void main(String[] args) {
		AddTwoNumbers llist = new AddTwoNumbers();
		llist.head1 = new Node(5);
		llist.head1.next = new Node(6);
		llist.head1.next.next = new Node(3);
		
		llist.head2 = new Node(8);
		llist.head2.next = new Node(4);
		llist.head2.next.next = new Node(2);
		
		llist.head = llist.add(llist.head1, llist.head2);
		llist.printList(llist.head);
		
		llist.head = llist.addRec(llist.head1, llist.head2, 0);
		System.out.println();
		llist.printList(llist.head);
	}
	
	Node addRec(Node first, Node second, int carry){
		if(first == null && second == null){
			if(carry > 0){
				return new Node(carry);
			}
			return null;
		}
		
		int sum = 0;
		sum = (carry + (first!=null?first.data:0) + (second!=null?second.data:0))%10;
		carry = (carry + (first!=null?first.data:0) + (second!=null?second.data:0))/10;
		Node res = new Node(sum);
		res.next = addRec(first!=null?first.next:null, second!=null?second.next:null, carry);
		return res;
	}
	
	Node add(Node first, Node second){
		Node res = null, prev = null, temp = null;
		int sum = 0, carry = 0;
		while(first!=null || second!=null){
			sum = (carry + (first!=null?first.data:0) + (second!=null?second.data:0))%10;
			carry = (carry + (first!=null?first.data:0) + (second!=null?second.data:0))/10;
			temp = new Node(sum);
			if(res == null)
				res = temp;
			else
				prev.next = temp;
			prev = temp;
			if(first!=null)
				first = first.next;
			if(second!=null)
				second = second.next;
		}
		if(carry>0)
			temp.next = new Node(carry);
		return res;
	}
	
	void printList(Node node){
		if(node == null) return;
		while(node!=null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

}
