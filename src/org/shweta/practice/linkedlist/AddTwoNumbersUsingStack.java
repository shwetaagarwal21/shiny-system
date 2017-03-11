package org.shweta.practice.linkedlist;

import java.util.Stack;

public class AddTwoNumbersUsingStack {
	
	Node head;
	Node head1;
	Node head2;
	Node tail;

	public static void main(String[] args) {
		AddTwoNumbersUsingStack llist = new AddTwoNumbersUsingStack();
		llist.head1 = new Node(9);
		llist.head1.next = new Node(9);
		llist.head1.next.next = new Node(9);
		llist.head1.next.next.next = new Node(7);
		llist.head1.next.next.next.next = new Node(1);
		
		llist.head2 = new Node(9);
		llist.head2.next = new Node(9);
		llist.head2.next.next = new Node(8);
		
		llist.head = llist.add(llist.head1, llist.head2);
		llist.printList(llist.head);
	}
	
	void printList(Node node){
		if(node == null) return;
		while(node!=null){
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	Node add(Node node1, Node node2){
		if(node1==null)
			return node2;
		if(node2==null)
			return node1;
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		
		while(node1!=null){
			s1.push(node1.data);
			node1 = node1.next;
		}
		while(node2!=null){
			s2.push(node2.data);
			node2 = node2.next;
		}
		int sum = 0;
		int carry = 0;
		int val1 = 0;
		int val2 = 0;
		while(!s1.isEmpty() && !s2.isEmpty()){
			val1 = s1.pop();
			val2 = s2.pop();
			sum = (val1 + val2 + carry)%10;
			carry = (val1 + val2 + carry)/10;
			s3.push(sum);			
		}
		
		while(!s1.isEmpty()){
			val1 = s1.pop();
			sum = (val1 + carry)%10;
			carry = (val1 + carry)/10;
			s3.push(sum);
		}
		
		while(!s2.isEmpty()){
			val2 = s2.pop();
			sum = (val2 + carry)%10;
			carry = (val2 + carry)/10;
			s3.push(sum);
		}
		
		if(carry > 0)
			s3.push(carry);
		
		return createLinkedList(s3);		
	}
	
	Node createLinkedList(Stack<Integer> stack){
		while(!stack.isEmpty()){
			appendNode(stack.pop());
		}
		return head;
	}
	
	void appendNode(int value){
		if(head == null){
			head = new Node(value);
			tail = head;
			return;
		}
		Node n = new Node(value);
		tail.next = n;
		tail = n;
	}
}
