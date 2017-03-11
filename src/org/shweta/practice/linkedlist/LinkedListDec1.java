package org.shweta.practice.linkedlist;

public class LinkedListDec1 {
	
	Node head;
	Node second_half;
	
	public static void main(String[] args) {
		LinkedListDec1 llist = new LinkedListDec1();
		//create a list with 3 nodes
		llist.createListWith3Nodes();
		//prints the created list
		llist.printList();
		//adds a node at the front
		llist.push(4);
		//adds a node after node 4
		llist.insertAfter(llist.head,5);
		//adds a node at the end
		llist.append(6);
		System.out.println();
		llist.printList();
		//delete a node 1
		llist.delete(1);
		System.out.println();
		llist.printList();
		//delete a node with position
		llist.deletePosition(1);
		System.out.println();
		llist.printList();
		//find length of linked list
		int noOfNodes = llist.getCount();
		System.out.println();
		System.out.println("Count of nodes is :: " + noOfNodes);
		System.out.println();
		System.out.println("Count of nodes using recursion is :: " + llist.getCountRec());
		System.out.println();
		System.out.println("Check if 3 is present :: " + llist.search(3));
		System.out.println("Check if 3 is present using recursion :: " + llist.search(3));
		llist.swapNodes(2, 3);
		System.out.println();
		llist.printList();
		Node n = llist.getNthNode(2);
		System.out.println();
		System.out.println("Nth Node is :: " + n.data);
		
		Node mid = llist.getMiddle();
		System.out.println();
		System.out.println("Middle element is :: " + mid.data);
		
		Node nthFromEnd = llist.getNthNodeFromLast(2);
		System.out.println();
		System.out.println("2nd Node from last is :: " + nthFromEnd.data);
		
		System.out.println();
		System.out.println("3 occurs number of times :: " + llist.getOccurrencesOf(3));
		
		llist.reverse();
		System.out.println("Reversed list is :: ");
		llist.printList();
		
		llist.reverseRec();
		System.out.println();
		System.out.println("Reversed list using recursion is :: ");
		llist.printList();
		System.out.println();
		System.out.println("Loop in linked list:: " + llist.findLoop());
		/*System.out.println("List after deleting alternate nodes is :: ");
		llist.deleteAlternateNodes();
		System.out.println();
		llist.printList();*/
		System.out.println("List is now:: ");
		llist.printList();
		
		System.out.println();
		llist.head = llist.reverse(2);
		llist.printList();
	}
	
	
	//create a list with 3 nodes
	void createListWith3Nodes(){
		head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		head.next = second;
		second.next = third;
	}
	
	//prints the list
	void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	//adds a node at the front
	void push(int d){
		Node n = new Node(d);
		n.next = head;
		head = n;
	}
	
	//adds a node after a given node
	void insertAfter(Node n, int d){
		if(n == null){
			System.out.println("The given previous node cannot be null");
	        return;
		}
		Node nd = new Node(d);
		nd.next = n.next;
		n.next = nd;		
	}
	
	//adds a node at the end
	void append(int d){
		Node n = new Node(d);
		if(head == null){
			head = n;
			return;
		}
		n.next = null;
		Node last = head;
		while(last.next!=null){
			last = last.next;
		}
		last.next = n;
	}
	
	//delete a node
	void delete(int d){
		Node temp = head, prev = null;
		while(temp != null && temp.data != d){
			prev = temp;
			temp = temp.next;
		}
		if(temp == null) return;
		prev.next = temp.next;
	}
	
	//delete a node with position
	void deletePosition(int pos){
		if(head == null) return;
		
		Node temp = head;
		if(pos == 0){
			head = temp.next;
			return;
		}
		
		for(int i=0; i<pos-1 && temp!=null; i++){
			temp = temp.next;
		}
		Node next = temp.next.next;
		temp.next = next;		
	}

	//find length of linked list, using recursion
	int getCountRec(){
		return getCountRec(head);
	}
	
	int getCountRec(Node node){
		if(node == null) return 0;
		return 1 + getCountRec(node.next);
	}
	
	//find length of linked list
	int getCount(){
		if(head == null) return 0;
		Node tmp = head;
		int count = 0;
		while(tmp!=null){
			tmp = tmp.next;
			count++;
		}
		return count;
	}
	
	//search a node in linked list, using recursion
	boolean searchRec(int x){
		return searchRec(head, x);
	}
	
	boolean searchRec(Node n, int x){
		if(n == null) return false;
		if(n.data == x) return true;
		return searchRec(n.next, x);
	}
	
	//search a node in linked list
	boolean search(int x){
		if(head == null) return false;
		Node temp = head;
		while(temp!=null){
			if(temp.data == x) return true;
			temp = temp.next;
		}
		return false;
	}
	
	//swap nodes, without swapping data
	void swapNodes(int x, int y){
		if(x == y) return;
		Node prevX = null, currX = head;
		Node prevY = null, currY = head;
		while(currX != null && currX.data != x){
			prevX = currX;
			currX = currX.next;
		}
		while(currY != null && currY.data != y){
			prevY = currY;
			currY = currY.next;
		}
		
		if(currX == null || currY == null) return;
		
		if(prevX != null)
			prevX.next = currY;
		else
			head = currY;
		
		if(prevY != null)
			prevY.next = currX;
		else
			head = currX;
		
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;		
	}
	
	//get nth Node in linked list
	Node getNthNode(int n){
		if(head == null) return null;
		int count = 0;
		Node temp = head;
		while(temp!=null){
			if(count == n) return temp;
			count++;
			temp = temp.next;
		}
		return null;
	}
	
	//find middle element in linked list
	Node getMiddle(){
		Node slow = head;
		Node fast = head;
		if(head!=null){
			while(fast!=null && fast.next!=null){
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return slow;
	}
	
	//to find nth node from end
	Node getNthNodeFromLast(int n){
		if(head == null) return null;
		
		int count = 0;
		Node slow = head;
		Node fast = head;
		if(head != null){
			while(fast!=null && count < n){
				fast = fast.next;
				count++;
			}
		}
		while(fast!=null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;		
	}
	
	//find number of times x occurs in linked list
	int getOccurrencesOf(int x){
		if(head == null) return 0;
		Node temp = head;
		int count = 0;
		while(temp != null){
			if(temp.data == x)
				count++;
			temp = temp.next;
		}
		return count;
	}
	
	//reverse a linked list, using recursion
	void reverseRec(){
		reverseRec(head);
	}
	
	void reverseRec(Node node){
		if(node == null) return;
		if(node.next == null) {
			head = node;
			return;
		}
		reverseRec(node.next);
		node.next.next = node;
		node.next = null;		
	}
	
	//reverse a linked list
	void reverse(){
		if(head == null) return;
		Node curr = null;
		Node prev = null;
		Node next = head;
		while(next!=null){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
		}
		head = prev;
	}
	
	boolean findLoop(){
		if(head == null) return false;
		Node slow = head;
		Node fast = head;
		while(slow!=null && fast!=null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	//remove duplicated from an unsorted linked list
	void removeDuplicatesUnsorted(){
		Node ptr1 = head, ptr2, dup;
		while(ptr1!=null && ptr1.next!=null){
			ptr2 = ptr1;
			while(ptr2.next!=null){
				if(ptr1.data == ptr2.next.data){
					dup = ptr1;
					ptr2.next = ptr2.next.next;
				}else
					ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
		}
	}
		
	//remove duplicates from a sorted linked list
	void removeDuplicates(){
		Node curr = head;
		Node next;
		while(curr.next!=null){
			if(curr.data == curr.next.data){
				next = curr.next.next;
				curr.next = next;
			}else
				curr = curr.next;
		}
	}
	
	//move last element to front of linked list
	void moveToFront(){
		if(head == null || head.next == null) return;
		Node last = head;
		Node second_last = null;
		while(last.next!=null){
			second_last = last;
			last = last.next;
		}
		second_last.next = null;
		last.next = head;
		head = last;
	}
		
	//pairwise swap elements of linked list
	void pairWiseSwap(){
		Node temp = head;
		while(temp!=null && temp.next!=null){
			int tmp = temp.data;
			temp.data = temp.next.data;
			temp.next.data = tmp;
			temp = temp.next.next;
		}
	}
	
	//remove alternate nodes
	void deleteAlternateNodes(){
		if(head == null) return;
		Node curr = head.next;
		Node prev = head;
		while(prev!=null && curr!=null){
			prev.next = curr.next;
			curr = null;
			prev = prev.next;
			if(prev!=null)
				curr = prev.next;
		}
	}
	
	//check is two linked lists are identical, iterative
	boolean isIdenticalIter(Node a, Node b){
		if(a == null && b == null) return true;
		while(a!=null && b!=null){
			if(a.data != b.data)
				return false;
			a = a.next;
			b = b.next;
		}
		return (a == null && b == null);
	}
	
	//check is two linked lists are identical, using recursion
	boolean isIdentical(Node a, Node b){
		if(a == null && b == null) return true;
		if(a!= null && b!=null){
			return(a.data == b.data && isIdentical(a.next, b.next));
		}
		return false;
	}
	
	//reverse a list in groups of k
	Node reverse(int k){
		return reverse(head, k);
	}
	
	//reverse every k nodes
	Node reverse(Node head, int k){
		Node prev = null, curr = null;
		Node next = head;
		int count = 0;
		while(next!=null && count < k){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			count++;
		}
		if(next!=null)
			head.next = reverse(next, k);
		return prev;
	}	

}
