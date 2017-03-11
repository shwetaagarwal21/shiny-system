package org.shweta.linkedlist;
/*
1) Get count of the nodes in first list, let count be c1.
2) Get count of the nodes in second list, let count be c2.
3) Get the difference of counts d = abs(c1 – c2)
4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
5) Then we can traverse both the lists in parallel till we come across a common node. 
(Note that getting a common node is done by comparing the address of the nodes)
 */
public class IntersectionPointYType {
	
	Node head1, head2;

	public static void main(String[] args) {
		IntersectionPointYType list = new IntersectionPointYType();
		
		// creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(15);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + list.getNode().data);
	}
	
	Node getNode(){
		int c1 = getLength(head1);
		int c2 = getLength(head2);
		int d;
		if(c1 > c2){
			d = c1 - c2;
			return getIntersectionNode(d, head1, head2);
		}else{
			d = c2 - c1;
			return getIntersectionNode(d, head2, head1);
		}		
	}
	
	Node getIntersectionNode(int d, Node head1, Node head2){
		Node current1 = head1;
		Node current2 = head2;
		for(int i = 0; i < d; i++){
			if(current1 == null)
				return new Node(-1);
			current1 = current1.next;
		}
		while(current1!=null && current2!=null){
			if(current1.data == current2.data)
				return current1;
			current1 = current1.next;
			current2 = current2.next;
		}
		return new Node(-1);
	}
	
	int getLength(Node node){
		int count = 0;
		Node current = node;
		while(current != null){
			count++;
			current = current.next;
		}
		return count;
	}

}
