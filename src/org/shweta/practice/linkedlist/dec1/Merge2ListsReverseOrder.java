package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class Merge2ListsReverseOrder {
	
	Node head;
	Node a,b;

	public static void main(String[] args) {
		Merge2ListsReverseOrder llist = new Merge2ListsReverseOrder();
		llist.a = new Node(5);
		llist.a.next = new Node(10);
		llist.a.next.next = new Node(15);
		llist.a.next.next.next = new Node(40);
		
		llist.b = new Node(2);
		llist.b.next = new Node(3);
		llist.b.next.next = new Node(20);
		
		Node result = llist.sortedMerge(llist.a, llist.b);
		llist.printList(result);
	}
	
	Node sortedMerge(Node a, Node b){
		if(a == null && b == null) return null;
		
		Node res = null;
		while(a!=null && b!=null){
			if(a.data <= b.data){
				Node tmp = a.next;
				a.next = res;
				res = a;
				a = tmp;				
			}else{
				Node tmp = b.next;
				b.next = res;
				res = b;
				b = tmp;
			}
		}
		while(a!=null){
			Node tmp = a.next;
			a.next = res;
			res = a;
			a = tmp;
		}
		while(b!=null){
			Node tmp = b.next;
			b.next = res;
			res = b;
			b = tmp;
		}
		return res;
	}
	
	//prints the list
	void printList(Node node){
		Node n = node;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
