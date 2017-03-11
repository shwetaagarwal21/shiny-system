package org.shweta.linkedlist;

public class LineSegmentsMiddlePoints {
	
	class Node {
		int dataX;
		int dataY;
		Node next;
		
		Node(int x, int y) {
			this.dataX = x;
			this.dataY = y;
			this.next = null;
		}
	}
	
	Node head;
	
	public static void main(String[] args) {
		LineSegmentsMiddlePoints llist = new LineSegmentsMiddlePoints();
		llist.push(40, 5);
		llist.push(20, 5);
		llist.push(7, 5);
		llist.push(7, 10);
		llist.push(5, 10);
		llist.push(1, 10);
		llist.push(0, 10);
		System.out.println("Given list is :: ");
		llist.printList();
		System.out.println();
		if (llist.deleteMiddle() != null)
        {
            System.out.println("Modified Linked List is");
            llist.printList();
        }
	}
	
	public Node deleteMiddle(){
		if(head == null || head.next == null || head.next.next == null)
			return head;
		
		//Node curr = head;
		Node next = head.next;
		Node next_next = next.next;
		
		if(head.dataX == next.dataX){
			if(next_next != null && next.dataX == next_next.dataX){
				head.next = next_next;
				next.next = null;
				
				next = next_next;
				next_next = next_next.next;
			}else{
				head = head.next;
			}
		}
		else if(head.dataY == next.dataY){
			if(next_next != null && next.dataY == next_next.dataY){
				head.next = next_next;
				next.next = null;
				
				next = next_next;
				next_next = next_next.next;
			}else{
				head = head.next;
			}
		}
		else{
			System.out.println("Given list is not valid");
            return null;
		}
		
		Node temp = head;
		
		deleteMiddle();
		
		head = temp;
		return head;		
	}
	
	public void push(int x, int y){
		Node new_node = new Node(x, y);
		new_node.next = head;
		head = new_node;
	}
	
	//print the elements in linked list
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print("(" + n.dataX + ", " + n.dataY + ")->");
			n = n.next;
		}
	}
	
}
