package org.shweta.linkedlist;
/*Write a removeDuplicates() function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list. 
 * The list should only be traversed once.
 * Solu - Traverse the list from the head (or start) node. While traversing, compare each node with its next node. 
 * If data of next node is same as current node then delete the next node. 
 * Before we delete a node, we need to store next pointer of the node
 */
public class DuplicateRemoveSortedList {
	
	Node head;

	public static void main(String[] args) {
		DuplicateRemoveSortedList llist = new DuplicateRemoveSortedList();
		llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);
        System.out.println("List before removal of duplicates");
        llist.printList();
        
        llist.removeDuplicates();        
        System.out.println("List after removal of elements");
        llist.printList();

	}
	
	public void removeDuplicates(){
		Node current = head;
		Node next_next = null;
		if(head == null)
			return;
		
		while(current.next!=null){
			if(current.data == current.next.data){
				next_next = current.next.next;
				current.next = next_next;
			}
			else
				current = current.next;
		}
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
