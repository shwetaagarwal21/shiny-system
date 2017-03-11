class Node {
	int data;
	Node left;
	Node right;
	Node next;
	
	Node(){
		super();
	}
	
	Node(int d){
		super();
		this.data = d;		
	}
	
	Node(int x, Node a, Node b){
		super();
		this.data = x;
		this.left = a;
		this.right = b;
	}
	
}

public class BinaryTreePopulateNext {
	
	Node root;
	
	public static void main(String args[]){
		BinaryTreePopulateNext tree = new BinaryTreePopulateNext();
		tree.createSampleTree();
        tree.traverse();
        Integer s = null;
        s = tree.root.next!=null? tree.root.next.data : null; 
        System.out.println(tree.root.data + ".next = " + s);
        s = tree.root.left.next!=null? tree.root.left.next.data : null;
        System.out.println(tree.root.left.data + ".next = " + s);
        s = tree.root.right.next!=null? tree.root.right.next.data : null;
        System.out.println(tree.root.right.data + ".next = " + s);
        s = tree.root.left.left.next != null ? tree.root.left.left.next.data : null;
        System.out.println(tree.root.left.left.data + ".next = " + s);
        s = tree.root.left.right.next != null ? tree.root.left.right.next.data : null;
        System.out.println(tree.root.left.right.data + ".next = " + s);
        s = tree.root.right.left.next != null ? tree.root.right.left.next.data : null;
        System.out.println(tree.root.right.left.data + ".next = " + s);
        s = tree.root.right.right.next != null ? tree.root.right.right.next.data : null;
        System.out.println(tree.root.right.right.data + ".next = " + s);
    }
	
	public void createSampleTree(){
		root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
	}
	
	public void traverse(){
		populateNext(root);
    }
	
	public void populateNext(Node node){
		if(node == null)
			return;
		
		if(node.left!=null){
			node.left.next = node.right;
	    }		
		
	    if(node.right!=null){
	        if(node.next!=null){
	        	node.right.next = node.next.left;
	        }
	        else{
	        	node.right.next = null;
	        }
	    }
	    populateNext(node.left);
	    populateNext(node.right);		
	}
	
}
