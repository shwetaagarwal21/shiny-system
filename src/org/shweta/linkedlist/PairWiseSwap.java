package org.shweta.linkedlist;
/*
 * write a function to swap elements pairwise. 
 * For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5, 
 * and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
 * 
 * Solution: Start from the head node and traverse the list. While traversing swap data of each node with its next node’s data.
 */
public class PairWiseSwap {
	
	Node head;
	
	public static void main(String[] args) {
		PairWiseSwap llist = new PairWiseSwap();
		llist.push(6);
		llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        System.out.println("Linked List before calling pairWiseSwap() ");
        llist.printList();
        
        //llist.pairWiseSwapRec();
        llist.pairWiseSwap();
        
        System.out.println("Linked List after calling pairWiseSwap() ");
        llist.printList();
	}
	
	public void pairWiseSwap(){
		Node temp = head;
		while(temp != null && temp.next != null){
			int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
			temp = temp.next.next;
		}
	}
	
	public void pairWiseSwapRec(){
		pairWiseSwapRecUtil(head);
	}
	
	public void pairWiseSwapRecUtil(Node node){
		if(node!=null && node.next != null){
			swap(node.data, node.next.data);
			if(node.next.next!=null)
				pairWiseSwapRecUtil(node.next.next);
		}
	}
	
	void swap(int x, int y){
		int tmp = x;
		x = y;
		y = tmp;
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
