package org.shweta.linkedlist;

public class MergeSortedLists {
	
	Node head;

	public static void main(String[] args) {
		MergeSortedLists list1 = new MergeSortedLists();
		list1.push(7);
		list1.push(3);
		list1.push(1);
		System.out.println("List 1 is ");
		list1.printList();
		System.out.println();
		
		MergeSortedLists list2 = new MergeSortedLists();
		list2.push(9);
		list2.push(8);
		list2.push(6);
		list2.push(5);
		list2.push(4);
		list2.push(2);
		System.out.println("List 2 is ");
		list2.printList();
		System.out.println();
		
		MergeSortedLists mergeList = new MergeSortedLists();
		list1.mergeList(list2);
		//mergeList.merge(list1, list2);
		System.out.println("Merge List is ");
		list1.printList();
		
		
		//Recursive version
		MergeSortedLists list3 = new MergeSortedLists();
		list3.push(7);
		list3.push(3);
		list3.push(1);
		MergeSortedLists list4 = new MergeSortedLists();
		list4.push(9);
		list4.push(8);
		list4.push(6);
		list4.push(5);
		list4.push(4);
		list4.push(2);
		Node merge = list3.merge(list3.head, list4.head);
		System.out.println();
		System.out.println("Merge list using recursion is ");
		while(merge!=null){
			System.out.print(merge.data + " ");
			merge = merge.next;
		}
		
	}
	
	public void mergeList(MergeSortedLists list){
		if(list == null || list.head == null)
			return;
		
		if(head == null){
			head = list.head;
			return;
		}
		
		Node tmp1 = head;
		Node tmp2 = list.head;
		if(tmp1.data < tmp2.data){
			head = tmp1;
			tmp1 = tmp1.next;
		}else{
			head = tmp2;
			tmp2 = tmp2.next;
		}
		
		Node mergedNext = head;
		while(tmp1 != null && tmp2 != null){
			if(tmp1.data < tmp2.data){
				mergedNext.next = tmp1;
				tmp1 = tmp1.next;
			}else{
				mergedNext.next = tmp2;
				tmp2 = tmp2.next;
			}
			mergedNext = mergedNext.next;
		}
		
		if(tmp1!=null){
			mergedNext.next = tmp1;
		}else{
			mergedNext.next = tmp2;
		}
		
	}
	
	public Node merge(Node nodeList1, Node nodeList2){
		if(nodeList1 == null && nodeList2 == null)
			return null;
		if(nodeList1 == null)
			return nodeList2;
		if(nodeList2 == null)
			return nodeList1;
		
		Node mergeListNode;
		if(nodeList1.data < nodeList2.data){
			mergeListNode = nodeList1;
			mergeListNode.next = merge(nodeList1.next, nodeList2);
		}else{
			mergeListNode = nodeList2;
			mergeListNode.next = merge(nodeList1, nodeList2.next);
		}
		return mergeListNode;		
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
