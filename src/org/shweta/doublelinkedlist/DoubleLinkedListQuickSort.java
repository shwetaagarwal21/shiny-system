package org.shweta.doublelinkedlist;

public class DoubleLinkedListQuickSort {
	
	Node head;
	Node tail;
	
	public static void main(String[] args) {
		DoubleLinkedListQuickSort dLinkedList = new DoubleLinkedListQuickSort();
		dLinkedList.push(5);
		dLinkedList.push(20);
		dLinkedList.push(4);
		dLinkedList.push(3);
		dLinkedList.push(30);
		System.out.println("Linked List before sorting ");
		dLinkedList.printList();
		dLinkedList.quickSort(dLinkedList.head);
		System.out.println("Linked List after sorting ");
		dLinkedList.printList();
	}
	
	public void quickSort(Node node){
		Node lastNode = lastNode(node);
		quickSort(node, lastNode);
	}
	
	public void quickSort(Node head, Node lastNode){
		if(lastNode!=null && head!=lastNode && head!=lastNode.next){
			Node q = partition(head, lastNode);
			quickSort(head, q.prev);
			quickSort(q.next, lastNode);
		}
	}
	
	public Node partition(Node p, Node r){
		int x = r.data;
		Node i = p.prev;
		for(Node j = p; j!=r; j=j.next){
			if(j.data <= x){
				i = (i==null) ? p: i.next;
				int temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
		}
		i = (i == null) ? p : i.next;
		int temp = i.data;
		i.data = r.data;
		r.data = temp;
		return i;
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
