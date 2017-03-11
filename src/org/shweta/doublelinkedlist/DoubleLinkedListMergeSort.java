package org.shweta.doublelinkedlist;

public class DoubleLinkedListMergeSort {
	
	Node head;
	Node tail;

	public static void main(String[] args) {
		DoubleLinkedListMergeSort dLinkedList = new DoubleLinkedListMergeSort();
		dLinkedList.push(5);
		dLinkedList.push(20);
		dLinkedList.push(4);
		dLinkedList.push(3);
		dLinkedList.push(30);
		System.out.println("Linked List before sorting ");
		dLinkedList.printList();
		dLinkedList.mergeSort(dLinkedList.head);
		System.out.println("Linked List after sorting ");
		dLinkedList.printList();
	}
	
	public void mergeSort(Node node){
		Node lastNode = lastNode(node);
		mergeSort(node, lastNode);
	}
	
	public void mergeSort(Node head, Node lastNode){
		if(lastNode!=null && head!=lastNode){
			Node q = findMiddle(head); 
			//System.out.println("Middle element is " + q.data);
			mergeSort(head, q);
			if(q!=null && q.next!=null){
				mergeSort(q.next, lastNode);
			}
			merge(head, q, lastNode);
		}
	}
	
	public void merge(Node p, Node q, Node r){
		
		if(p == null) return;
		if(q == null) return;
		
		for(Node j = p; j!=r; j=j.next){
			if(p!=null && q!=null){
				if(p.data <= q.data){
					p = p.next;
				}else{
					q = q.next;
				}
			}
		}
	}
	
	public Node findMiddle(Node node){
		Node slow = node;
		Node fast = node;
		
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}
	
	public Node lastNode(Node node){
		while(node.next!=null){
			node = node.next;
		}
		return node;
	}	
	
	public void printList(){
		Node current = head;
		Node last = null;
		System.out.println("Traversal in forward direction:: ");
		while(current!=null){
			System.out.print(current.data + " ");
			last = current;
			current = current.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction:: ");
		while(last!=null){
			System.out.print(last.data + " ");
			last=last.prev;
		}
		System.out.println();
	}
	
	//Add a node at the front of the linked list.
	public void push(int new_data){
		Node new_node = new Node(new_data);
		if(head == null){
			new_node.next = null;
			new_node.prev = null;
			head = new_node;
			tail = new_node;
		}else{
			head.prev = new_node;
			new_node.next = head;
			new_node.prev = null;
			head = new_node;
		}
	}
	
}
