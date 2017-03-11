package org.shweta.doublelinkedlist.circular;

public class Node {
	int data;
	Node small;
	Node large;
	
	public Node(int data){
		this.data = data;
		this.small = null;
		this.large = null;
	}
}
