package org.shweta.linkedlist;

public class LinkedList {

	Node head;
	
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.push(10);
		llist.push(4);
		llist.push(15);
		llist.push(20);
		llist.push(50);
		
		//llist.head.next.next.next.next = llist.head.next.next;
		boolean loopFound = llist.detectLoop();
		System.out.println("loop exists:: " + loopFound);
		
		Node middle = llist.findMiddle();
		System.out.println("Middle element is " + middle.data);
		
		Node nthFromLast = llist.findNthNodeFromLast(4);
		System.out.println("4th element from last is " + nthFromLast.data);
		
		System.out.println("Given list is " );
		llist.printList();
		
		llist.reverseList();
		System.out.println();
		System.out.println("Reverse list is ");
		llist.printList();
		
		llist.reverseListRecursive();
		System.out.println();
		System.out.println("Reverse list in recursive is ");
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
	
	public boolean detectLoop(){
		Node slow = head;
		Node fast = head;
		
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	public Node findMiddle(){
		Node current = head;
		Node middle = head;
		int length = 0;
		
		while(current.next!=null){
			length++;
			if(length%2 == 0)
				middle = middle.next;
			current = current.next;
		}
		
		if(length%2 == 1)
			middle = middle.next;
		
		return middle;
	}
	
	public Node findNthNodeFromLast(int n){
		Node main_ptr = head;
		Node ref_ptr = head;
		
		int count = 0;
		if(head!=null){
			while(count < n){
				if(ref_ptr == null){
					System.out.println( n + " is greater than number of nodes in the list.");
					return null;
				}
				ref_ptr = ref_ptr.next;
				count++;
			}
			while(ref_ptr!=null){
				ref_ptr = ref_ptr.next;
				main_ptr = main_ptr.next;
			}
			return main_ptr;
		}
		return null;
	}
	
	public void reverseList(){
		Node prev = null;
		Node curr = null;
		Node next = head;
		
		while(next!=null){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
		}
		head = curr;	
	}
	
	public void reverseListRecursive(){
		reverseListRecursive(head);
	}
	
	public void reverseListRecursive(Node curr){
		//Node curr = head;
		if(curr == null)
			return;
		if(curr.next == null){
			head = curr;
			return;
		}
		reverseListRecursive(curr.next);
		curr.next.next = curr;
		curr.next = null;
	}

}
