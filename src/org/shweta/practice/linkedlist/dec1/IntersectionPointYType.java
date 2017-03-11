package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class IntersectionPointYType {
	Node head1;
	Node head2;
	
	public static void main(String args[]){
		IntersectionPointYType llist = new IntersectionPointYType();
		llist.head1 = new Node(3);
		llist.head1.next = new Node(6);
		llist.head1.next.next = new Node(9);
		llist.head1.next.next.next = new Node(15);
		llist.head1.next.next.next.next = new Node(30);
		
		llist.head2 = new Node(10);
		llist.head2.next = new Node(15);
		llist.head2.next.next = new Node(30);
		
		Node n = llist.getNode();
		if(n!=null)
			System.out.println("Intersection node is :: " +n.data);
	}
	
	Node getNode(){
		int len1 = length(head1);
		int len2 = length(head2);
		int d;
		if(len1 > len2){
			d = len1 - len2;
			return getIntersectionNode(d, head1, head2);
		}else{
			d = len2 - len1;
			return getIntersectionNode(d, head2, head1);
		}
	}
	
	Node getIntersectionNode(int d, Node head1, Node head2){
		Node tmp1 = head1;
		Node tmp2 = head2;
		for(int i=0;i<d;i++){
			tmp1 = tmp1.next;
		}
		while(tmp1!=null && tmp2!=null){
			if(tmp1.data == tmp2.data){
				return tmp1;
			}
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		return null;
	}
	
	int length(Node node){
		if(node == null) return 0;
		int count = 0;
		Node curr = node;
		while(curr!=null){
			curr = curr.next;
			count++;
		}
		return count;
	}
}
