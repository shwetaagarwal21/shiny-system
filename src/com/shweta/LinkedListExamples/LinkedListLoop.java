package com.shweta.LinkedListExamples;

public class LinkedListLoop {

	Node head;
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		LinkedListLoop list = new LinkedListLoop();
		/*linkedList.head = new Node(8);
		linkedList.head.next = new Node(1);
		linkedList.head.next.next = new Node(9);
		linkedList.head.next.next.next = new Node(4);
		linkedList.head.next.next.next.next = new Node(2);
		linkedList.head.next.next.next.next.next = new Node(3);
		linkedList.head.next.next.next.next.next.next = new Node(7);
		linkedList.head.next.next.next.next.next.next.next = new Node(2);
		linkedList.head.next.next.next.next.next.next.next.next = new Node(9);
		linkedList.head.next.next.next.next.next.next.next.next.next = linkedList.head.next.next.next.next;*/
		
		list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
        
        list.head.next.next.next.next.next = list.head.next.next;
		Node node = list.detectLoopAndReturnStartElement(list.head);
		if(node!=null){
			System.out.println("Loop found at " + node.data);
		}
	}
	
	public Node detectLoopAndReturnStartElement(Node node) {
		Node slow = node;
		Node fast = node;
		boolean loopExist = false;
		
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				loopExist = true;
			}				
		}
		loopExist = false;
		
		System.out.println("loopExist:: " + loopExist);
		
		if(loopExist){
			slow = node;
			while(slow!=null && fast!=null){
				slow = slow.next;
				fast = fast.next;
				
				if(slow == fast){
					return slow;
				}
			}
		}
		
		return null;
	}

}
