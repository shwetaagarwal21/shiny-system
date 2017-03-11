package org.shweta.practice.linkedlist;

public class FindLoopLinkedList {
	
	Node head;
	
	public static void main(String[] args) {
		FindLoopLinkedList list = new FindLoopLinkedList();
/*		list.head = new Node(8);
        list.head.next = new Node(1);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next = new Node(3);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next.next.next.next.next = list.head.next.next.next.next;*/
		list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
        
        list.head.next.next.next.next.next = list.head.next.next;
        
        Node n = list.findStartNodeOfLoop();
        if(n!=null)
        	System.out.println("Loop starts at " + n.data);

	}
	
	Node findStartNodeOfLoop(){
		Node slow = head;
		Node fast = head;
		
		boolean foundLoop = false;
		while(slow!=null && fast!=null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			//System.out.println("Slow:: " + slow.data + " Fast:: " + fast.data);
			
			if(slow == fast)
				foundLoop = true;			
		}
		System.out.println(foundLoop);
		if(foundLoop){
			slow = head;
			while(slow!=null && fast!=null){
				slow = slow.next;
				fast = fast.next;
				if(slow == fast)
					return slow;
			}			
		}
		return null;
	}

}
