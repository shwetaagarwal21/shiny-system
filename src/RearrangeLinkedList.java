class LNode{
	int data;
	LNode next;
	
	LNode(int d){
		this.data = d;
		this.next = null;
	}
}

public class RearrangeLinkedList {
	
	LNode head;
	
	public static void main(String[] args) {
		RearrangeLinkedList llist = new RearrangeLinkedList();
		llist.push(12);
		llist.push(10);
		llist.push(8);
		llist.push(6);
		llist.push(4);
		llist.push(2);
		llist.push(11);
		llist.push(9);
		llist.push(7);
		llist.push(5);
		llist.push(3);
		llist.push(1);
		System.out.println("Original Linked list is:: ");
		llist.printList();
		System.out.println();
		System.out.println("Rearranged Linked list is:: ");
		llist.reArrange();
		llist.printList();
	}
	
	public void reArrange(){
        if(head == null)
            return;
        
        LNode slow = head;
        LNode fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = head;
        LNode tempFast;
        LNode tempSlow;
        while(slow != null){
            tempFast = fast.next;
            fast.next = slow;
            tempSlow = slow.next;
            slow.next = tempFast;
            slow = tempSlow;
            fast = tempFast;
            tempFast.next = tempSlow;
        }   
    }
	
	public void push(int new_data){
		LNode new_node = new LNode(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	public void printList(){
		LNode n = head;
		while(n != null){
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
