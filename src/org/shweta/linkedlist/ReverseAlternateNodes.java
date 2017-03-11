package org.shweta.linkedlist;
/*
1. Traverse k nodes forward and set temp to the k+1th node
2. Reverse k nodes traversed in step 1. 
3. Set next of the last node in this k length list to temp.
4. Traverse next k nodes which are to be skipped.
5. Recursively call steps 1-3 for reversing next k nodes.
 * */
public class ReverseAlternateNodes {
	
	Node head;

	public static void main(String[] args) {
		ReverseAlternateNodes llist = new ReverseAlternateNodes();
		llist.push(10);
		llist.push(9);
		llist.push(8);
		llist.push(7);
		llist.push(6);
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		System.out.println("Given list is :: ");
		llist.printList();
		System.out.println("Reversed list is :: ");
		llist.reverseAlternateNodes(4);
		llist.printList();
	}
	
	public void reverseAlternateNodes(int k){
		if(head == null || head.next == null || k < 2){
			return;
		}
		head = reverseAlternateNodes(head, k);
	}
	
	public Node reverseAlternateNodes(Node head, int k){
		if(head == null || head.next == null || k < 2){
			return head;
		}
		Node temp = head;
		int i = 0;
		while(i < k && temp!=null){
			i++;
			temp = temp.next;
		}
		head = reverseList(head, k);
		Node next = head;
		while(next.next!=null)
			next = next.next;
		next.next = temp;
		
		i = 0;
		Node prev = null;
		while(i<k && temp!=null){
			i++;
			prev = temp;
			temp = temp.next;
		}
		
		if(temp != null)
			prev.next = reverseAlternateNodes(temp, k);
		
		return head;
	}
	
	public Node reverseList(Node current, int k){
		if(current == null || k < 2)
			return null;
		
		Node prev = null;
		Node curr = current;
		Node next = null;
		int i = 1;
		
		while(i < k && curr.next != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		next = curr.next;
		curr.next = prev;
		return curr;
	}
	
	public void push(int new_data){
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	//print the elements in linked list
	public void printList(){
		Node n = head;
		while(n!=null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
}
