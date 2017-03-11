package org.shweta.doublelinkedlist;

public class Node {
	int data;
	Node prev;
	Node next;
	
	Node(int d){
		this.data = d;
		this.prev = this.next = null;
	}
}
