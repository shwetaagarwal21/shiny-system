package org.shweta.linkedlist;

public class InsertionSortedLists {

	Node head1, head2;
	
	public static void main(String[] args) {
		InsertionSortedLists list = new InsertionSortedLists();
		// creating first linked list
        list.head1 = new Node(1);
        list.head1.next = new Node(2);
        list.head1.next.next = new Node(3);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
 
        // creating second linked list
        list.head2 = new Node(2);
        list.head2.next = new Node(4);
        list.head2.next.next = new Node(6);
        list.head2.next.next.next = new Node(8);
        
        Node n = list.sortedInsert();
        System.out.println("Sorted Insert List is :: ");
        while(n != null){
        	System.out.print(n.data + " ");
        	n = n.next;
        }
	}
	
	//print the elements in linked list
/*	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}*/
	
	public Node sortedInsert(){
		Node head3 = null;
		while(head1 != null && head2 != null){
			if(head1.data == head2.data){
				Node n = new Node(head1.data);
				n.next = head3;
				head3 = n;
				head3 = head3.next;
				head1 = head1.next;
				head2 = head2.next;
			}else if(head1.data < head2.data){
				head1 = head1.next;
			}else{
				head2 = head2.next;
			}				
		}
		return head3;
	}

}
