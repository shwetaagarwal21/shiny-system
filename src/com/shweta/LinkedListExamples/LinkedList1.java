package com.shweta.LinkedListExamples;

public class LinkedList1 {

	Node head;
	
	static class Node{
		
		int data;
		Node next;
		
		Node(int d){
			this.data = d;
			this.next = null;
		}
		
	}	
	
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data +" ");
			n = n.next;
		}
	}
	
	public void push(int newData){
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfter(Node prevNode, int data){
		if(prevNode == null){
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		Node n = new Node(data);
		n.next = prevNode.next;
		prevNode.next = n;		
	}
	
	public void append(int newData){
		Node newNode = new Node(newData);
		if(head == null){
			head = new Node(newData);
			return;
		}
		newNode.next = null;
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		last.next = newNode;
		return;
	}
	
	/* Given a key, deletes the first occurrence of key in linked list */
	public void deleteNode(int key){
		Node temp = head, prev = null;
		if(temp!=null && temp.data == key){
			head = temp.next;
			return;
		}
		
		// Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
		while(temp!=null && temp.data != key){
			prev = temp;
			temp = temp.next;
		}
		
		// If key was not present in linked list
        if (temp == null) return;
        
        // Unlink the node from linked list
        prev.next = temp.next;
		
	}
	
	public void deleteNode(String pos, int position){
		
		// If linked list is empty
        if (head == null)
            return;
        
        // Store head node
        Node temp = head;
        
        if(position == 0){
        	head = temp.next;
        	return;
        }
		
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next = next;  // Unlink the deleted node from list
		
	}
	
	public boolean search(int key){
		Node current = head;
		while(current!=null){
			if(current.data == key)
				return true;
			current = current.next;
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
	
	public void swap(int x, int y){
		if(x == y)
			return;
		
		//Search for x
		Node prevX = null, currX = head;
		while(currX!=null && currX.data != x){
			prevX = currX;
			currX = currX.next;
		}
		
		//Search for y
		Node prevY = null, currY = head;
		while(currY!=null && currY.data != y){
			prevY = currY;
			currY = currY.next;
		}
		
		if(currX == null || currY == null)
			return;
		
		// If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
		
	}
	
	// Should return data of node at given index. The function may
	//  assume that there are at least index+1 nodes in linked list
	public int GetNth(Node node, int index)
	{
		int count = 0;
		Node current = node;
		while(current!=null){
			if (count == index)
				return current.data;
			else{
				current = current.next;
				count++;
			}				
		}
		return 0;
	} 
	
	public static void main(String[] args) {
		LinkedList1 llist = new LinkedList1();
		
		llist.append(6);
		llist.push(7);
		llist.push(1);
		llist.append(4);
		llist.insertAfter(llist.head.next, 8);
		
		System.out.println("\nCreated Linked list is: ");
		
		llist.printList();
		
		llist.deleteNode(6); // Delete node at position 4
		 
        System.out.println("\nLinked List after Deleting given node:");
        llist.printList();
        
        llist.push(5);
        
        System.out.println("\nCreated Linked list is: "); 
        llist.printList();
        llist.deleteNode("position", 3);
        System.out.println("\nLinked List after Deletion at position 3:"); 
        llist.printList();
        
        boolean foundKey = llist.search(7);
        System.out.println("\nKey Found in iterative:: " + foundKey);
        
        boolean searchKey = llist.search(llist.head, 7);
        System.out.println("Key Found in recursive:: " + searchKey);
        
        llist.swap( 1, 4);
        System.out.println("\nLinked list after swap is: "); 
        llist.printList();
        
        System.out.println("\nLinked list element at 2nd position is: " + llist.GetNth(llist.head, 2)); 
        
	}

}
