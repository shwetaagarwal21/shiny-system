package com.shweta.LinkedListExamples;

import com.shweta.LinkedListExamples.LinkedList1.Node;

public class SingleLinkedList {
	
	Node head;
	
	static class Node
	{
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	//add an element to front of linked list
	public void push(int d){
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	
	//print the elements in linked list
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	//Inserts a new node after the given prev_node. 
	public void insertAfter(Node prev_node, int data){
		
		if (prev_node == null)
	    {
	        System.out.println("The given previous node cannot be null");
	        return;
	    }
		
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	
	public void append(int d){
		Node new_node = new Node(d);
		
		if(head == null){
			head = new Node(d);
			return;
		}
		
		new_node.next = null;
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		last.next = new_node;
	}
	
	public void deleteNode(int key){
		Node temp = head;
		Node prevNode = null;
		
		if(temp!=null && temp.data == key){
			head = temp.next;
			return;
		}
		
		while(temp!=null && temp.data!=key){
			prevNode = temp;
			temp = temp.next;			
		}
		
		if(temp==null)
			return;
		 
		prevNode.next = temp.next;		
	}
	
	public void deleteNode(String pos, int position){
		Node temp = head;
		Node prevNode = null;
		
		if(head == null)
			return;
		
		if(position == 0){
			head = temp.next;
			return;
		}
		
		// Find previous node of the node to be deleted
		for(int i=0; temp!=null && i<position-1; i++)
			temp = temp.next;
		
		// If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;
        
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;  // Unlink the deleted node from list				
	}
	
	//Returns number of nodes in linked list
	public int getCount(){
		if(head == null)
			return 0;
		Node temp = head;
		int count = 0;
		while(temp!=null){
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	//Returns number of nodes in linked list
	public int getCount(Node head){
		if(head == null)
			return 0;
		return 1 + getCount(head.next);
	}
	
	public boolean search(int key){
		Node n = head;
		while(n!=null){
			if(n.data == key)
				return true;
			n = n.next;
		}		
		return false;
	}
	
	public boolean search(Node head, int key){
		if(head == null)
			return false;
		if(head.data == key)
			return true;
		else 
			return search(head.next, key);
	}
	
	//8 12 7
	public void swap(int x, int y){
		if(x == y)
			return;
		
		Node prevX = null, currX = head;
		Node prevY = null, currY = head;
		
		while(currX!=null && currX.data != x){
			prevX = currX;
			currX = currX.next;
		}
		
		while(currY!=null && currY.data != y){
			prevY = currY;
			currY = currY.next;
		}
		
		if(currX == null || currY == null)
			return;
		
		if(prevX!=null){
			prevX.next = currY;
		}else
			head = currY;
		
		if(prevY!=null){
			prevY.next = currX;
		}else
			head = currX;
		
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;		
	}
	
	public int GetNth(Node node, int index){
		int count = 0;
		while(node!=null){
			if(count == index)
				return node.data;
			else{
				node = node.next;
				count++;
			}
		}
		return 0;
	}
	
	public int findMiddle(Node node){
		int noOfNodes = getCount();
		int index = 0;
		if(noOfNodes%2 == 0)
			index = (noOfNodes/2) + 1;
		else
			index = (int) Math.ceil(noOfNodes/2);
		
		int data = GetNth(node, index);
		return data;		
	}
	
	public int getNthFromLast(Node node, int n){
		int len = getCount();
		
		if(len < n)
			return 0;
		
		int data = GetNth(node, len - n + 1);
		return data;
	}
	
	
	public static void main(String args[]){
		SingleLinkedList linkedList = new SingleLinkedList();
		
		linkedList.push(5);
		linkedList.push(10);
		linkedList.push(8);
		
		linkedList.printList();
		System.out.println(" ");
		
		linkedList.insertAfter(linkedList.head.next, 12);
		//linked list should be now 8 10 12 5
		linkedList.printList();
		System.out.println(" ");
		
		linkedList.append(7);
		//linked list should be now 8 10 12 5 7
		linkedList.printList();
		System.out.println(" ");
		
		linkedList.deleteNode(5);
		//linked list should be now 8 10 12 7
		linkedList.printList();
		System.out.println(" ");
		
		linkedList.deleteNode("position", 1);
		//linked list should be now 8 12 7
		linkedList.printList();
		System.out.println(" ");
		
		int noOfNodes = linkedList.getCount();
		System.out.println("Number of nodes is :: " + noOfNodes);
		
		int noOfNodesRec = linkedList.getCount(linkedList.head);
		System.out.println("Number of nodes Recursive is :: " + noOfNodes);
		
		boolean found = linkedList.search(12);
		System.out.println("Node 12 found :: " + found);
		found = linkedList.search(5);
		System.out.println("Node 5 found :: " + found);
		
		boolean foundRec = linkedList.search(linkedList.head, 12);
		System.out.println("Node 12 found :: " + foundRec);
		foundRec = linkedList.search(linkedList.head, 5);
		System.out.println("Node 5 found :: " + foundRec);
		
		linkedList.swap(8,7);
		linkedList.printList();
		System.out.println(" ");
		
		System.out.println("\nLinked list element at 2nd position is: " + linkedList.GetNth(linkedList.head, 2));
		
		int mid = linkedList.findMiddle(linkedList.head);
		System.out.println("Middle element in linked list is :: " + mid);
		
		int nthFromLast = linkedList.getNthFromLast(linkedList.head, 2);
		System.out.println("1 element from last is :: " + nthFromLast);
	}

	
}
