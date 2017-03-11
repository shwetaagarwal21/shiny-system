package org.shweta.practice.linkedlist.dec1;

public class RemoveMiddlePointLineSegments {

	LineSegmentNode head;
	
	public static void main(String[] args) {
		RemoveMiddlePointLineSegments llist = new RemoveMiddlePointLineSegments();
		llist.head = new LineSegmentNode(0, 10);
		llist.head.next = new LineSegmentNode(1, 10);
		llist.head.next.next = new LineSegmentNode(5, 10);
		llist.head.next.next.next = new LineSegmentNode(7, 10);
		llist.head.next.next.next.next = new LineSegmentNode(7, 5);
		llist.head.next.next.next.next.next = new LineSegmentNode(20, 5);
		llist.head.next.next.next.next.next.next = new LineSegmentNode(40, 5);
		
		System.out.println("Given list is ");
		llist.printList();
		
		if(llist.deleteMiddle() != null){
			System.out.println("Modified list is ");
			llist.printList();
		}
	}
	
	LineSegmentNode deleteMiddle(){
		if(head == null || head.next == null || head.next.next == null)
			return null;
		
		LineSegmentNode Next = head.next;
		LineSegmentNode NextNext = head.next.next;
		
		if(head.x == Next.x){
			while(NextNext != null && Next.x == NextNext.x){
				head.next = Next.next;
				Next.next = null;
				
				Next = NextNext;
				NextNext = NextNext.next;
			}
		}
		
		else if(head.y == Next.y){
			while(NextNext != null && Next.y == NextNext.y){
				head.next = Next.next;
				Next.next = null;
				
				Next = NextNext;
				NextNext = NextNext.next;
			}
		}
		else{
			System.out.println("Given list is not valid");
			return null;
		}
		
		LineSegmentNode temp = head;
		head = head.next;
		deleteMiddle();
		head = temp;
		return head;		
	}
	
	
	public void printList(){
		LineSegmentNode n = head;
		while(n!=null){
			System.out.print("(" + n.x + ", " + n.y + ")->");
			n = n.next;
		}
		System.out.println();
	}

}
