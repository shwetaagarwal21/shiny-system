package org.shweta.practice.linkedlist.dec1;

import org.shweta.practice.linkedlist.Node;

public class Palindrome {
	
	Node head, second_half;
	Node left;
	
	public static void main(String args[]){
		Palindrome list = new Palindrome();
		list.head = new Node(2);
		list.head.next = new Node(5);
		list.head.next.next = new Node(7);
		list.head.next.next.next = new Node(7);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(2);
		
		System.out.println("IS PALINDROME :: " + list.isPalindrome());
		
		list.isPalindromeRec();
	}
	
	boolean isPalindromeRec(){
		return isPalindromeRecUtil(head);
	}
	
	boolean isPalindromeRecUtil(Node right){
		left = head;
		if(right == null) return true;
		boolean isp = isPalindromeRecUtil(right.next);
		if(isp == false)
			return false;
		
		boolean isp1 = (right.data == left.data);
		left = left.next;
		return isp1;
	}

	boolean isPalindrome(){
		Node slow_ptr = head, fast_ptr = head;
		Node prev_of_slow_ptr = head;
		Node mid = null;
		boolean res = true;
		
		while(fast_ptr!=null && fast_ptr.next!=null){
			prev_of_slow_ptr = slow_ptr;
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		if(fast_ptr!=null){
			mid = slow_ptr;
			slow_ptr = slow_ptr.next;
		}
		second_half = slow_ptr;
		prev_of_slow_ptr.next = null;
		reverse();
		res = compareLists(head, second_half);
		
		reverse();
		if(mid!=null){
			prev_of_slow_ptr.next = mid;
			mid.next = second_half;
		}else{
			prev_of_slow_ptr.next = second_half;
		}		
		return res;
	}
	
	boolean compareLists(Node head1, Node head2){
		Node temp1 = head1, temp2 = head2;
		while(temp1 != null && temp2 != null){
			if(temp1.data == temp2.data){
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else
				return false;
		}
		return true;
	}
	
	void reverse(){
		Node curr = null;
		Node prev = null;
		Node next = second_half;
		while(next!=null){
			curr = next;
			next = curr.next;
			curr.next = prev;
			prev = curr;
		}
		second_half = prev;
	}
	
}
