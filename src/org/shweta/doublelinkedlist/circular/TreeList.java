package org.shweta.doublelinkedlist.circular;

public class TreeList {
	
	
	
	public static void main(String[] args) {
		Node root = new Node(4);
		treeInsert(root, 2);
        treeInsert(root, 1);
        treeInsert(root, 3);
        treeInsert(root, 5);
        
        System.out.println("tree:");
        printTree(root); // 1 2 3 4 5 
        System.out.println();
        
        System.out.println("list:");
       // Node head = treeToList(root);
       // printList(head);
	}
	
/*	public static Node treeToList(Node root){
		if(root == null)
			return null;
		
		
	}*/
	
	public static void treeInsert(Node root, int newData){
		if(newData <= root.data){
			if(root.small!=null)
				treeInsert(root.small, newData);
			else
				root.small = new Node(newData);
		}else{
			if(root.large!=null)
				treeInsert(root.large, newData);
			else
				root.large = new Node(newData);
		}
	}
	
	public static void printTree(Node root){
		if(root == null) 
			return;
		printTree(root.small);
		System.out.print(root.data + " ");
		printTree(root.large);
	}
	
	public static void printList(Node head){
		Node current = head;
		while(current!=null){
			System.out.println(current.data + " ");
			current = current.large;
			if(current == head)
				break;
		}
		System.out.println();
	}
	
	public static void join(Node a, Node b){
		a.large = b;
		b.small = a;
	}

}
