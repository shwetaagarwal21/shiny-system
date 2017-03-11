package org.shweta.linkedlist;

public class SingleLinkedListQuickSort {
	
	Node head;
	
	public static void main(String[] args) {
		SingleLinkedListQuickSort llist = new SingleLinkedListQuickSort();
		llist.push(5);
		llist.push(20);
		llist.push(4);
		llist.push(3);
		llist.push(50);
		
		System.out.println("Linked List before sorting ");
		llist.printList();
		llist.quickSort(llist.head);
		//System.out.println("Linked List after sorting ");
		//llist.printList();
	}
	
	public void quickSort(Node node){
		Node lastNode = lastNode(node);
		//System.out.println("Last Node is :: " + lastNode.data);
		head = quickSort(node, lastNode);
	}	
	
	Node quickSort(Node head, Node end){
		if(head == null || head == end)
			return head;
		
		Node newHead = null, newEnd = null;
		
		Node pivot = partition(head, end, newHead, newEnd);
		//System.out.println("newHead is :: " + newHead.data + " newEnd is :: " + newEnd.data);
		if(newHead!=pivot){
			Node temp = newHead;
			while(temp.next!=pivot)
				temp = temp.next;
			temp.next = null;
			newHead = quickSort(newHead, temp);
			temp = lastNode(newHead);
			temp.next = pivot;
		}
		pivot.next = quickSort(pivot.next, newEnd);
		return newHead;
		/*if(lastNode!=null && head!=lastNode){
			//Node q = partition(head, lastNode);
			quickSort(head, lastNode);
		}*/
	}
	
	Node partition(Node head, Node end, Node newHead, Node newEnd){
		Node pivot = end;
		Node prev = null, curr = head, tail = pivot;
		while(curr!=pivot){
			if(curr.data < pivot.data){
				if(newHead == null)
					newHead = curr;
				prev = curr;
				curr = curr.next;
			}else{
				if(prev!=null){
					prev.next = curr.next;					
				}
				Node temp = curr.next;
				curr.next = null;
				tail.next = curr;
				tail = curr;
				curr = temp;
			}
		}
		
		if(newHead == null)
			newHead = pivot;
		newEnd = tail;
		return pivot;		
	}
	
	private Node lastNode(Node node){
		while(node.next!=null){
			node = node.next;
		}
		return node;
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
			System.out.println();
		}

}
