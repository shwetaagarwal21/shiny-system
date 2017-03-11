package org.shweta.linkedlist;

public class Palindrome {
	
	Node head;
	Node slow_ptr, fast_ptr, second_half;
	Node left;

	public static void main(String[] args) {
		Palindrome list = new Palindrome();
		list.push(1);
		list.push(2);
		list.push(1);
		list.push(3);
		list.push(1);
		list.push(2);
		list.push(1);
		list.printList();
		if(list.isPalindrome()){
			System.out.println("Is Palindrome");
		}else{
			System.out.println("Not Palindrome");
		}
		list.printList();
		if(list.isPalindromeRec()){
			System.out.println("Is Palindrome");
		}else{
			System.out.println("Not Palindrome");
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
		System.out.println();
	}
	
	public boolean isPalindrome(){
		slow_ptr = head; fast_ptr = head;
		Node prev_of_slow_ptr = head;
		Node midNode = null;
		boolean res = true;
		
		if(head!=null && head.next != null){
			
			while(fast_ptr!=null && fast_ptr.next!=null){
				fast_ptr = fast_ptr.next.next;
				prev_of_slow_ptr = slow_ptr;
				slow_ptr = slow_ptr.next;
			}
			
			if(fast_ptr != null){
				midNode = slow_ptr;
				slow_ptr = slow_ptr.next;
			}
			
			second_half = slow_ptr;
			prev_of_slow_ptr.next = null;
			reverse(); //reverse the second half
			res = compareLists(head, second_half);
			
			reverse(); // construct original list again
			if(midNode != null){
				prev_of_slow_ptr.next = midNode;
				midNode.next = second_half;
			}else
				prev_of_slow_ptr.next = second_half;
			
		}		
		return res;
	}
	
	void reverse(){
		Node prev = null;
        Node current = second_half;
        Node next;
        while (current != null) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
	}
	
	boolean compareLists(Node head1, Node head2){
		Node temp1 = head1;
		Node temp2 = head2;
		while(temp1 != null && temp2 != null){
			if(temp1.data == temp2.data){
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else 
				return false;
		}
		
		if(temp1 == null && temp2 == null)
			return true;
		
		return false;
	}
	
	boolean isPalindromeRec(){
		boolean result = isPalindromeRecUtil(head);
		return result;
	}
	
	boolean isPalindromeRecUtil(Node right){
		left = head;
		if(right == null)
			return true;
		
		boolean isp = isPalindromeRecUtil(right.next);
		if(isp == false)
			return false;
		
		boolean isp1 = (right.data == left.data);
		left = left.next;
		return isp1;
	}

}
