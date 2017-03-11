package org.shweta.practice;

public class PopulateRightNeighbour {
	
	TreeNode root;

	public static void main(String[] args) {
		PopulateRightNeighbour tree = new PopulateRightNeighbour();
		tree.createSampleTree();
		tree.populateNext();
		tree.traverseNext();
	}
	
	void populateNext(){
		populateNext(root);		
	}
	
	void populateNext(TreeNode node){
		if(node == null) return;
		
		if(node.left!=null){
			if(node.right!=null)
				node.left.next = node.right;
			else{
				if(node.next!=null)
					node.left.next = node.next.left!=null ? node.next.left : node.next.right;
			}
		}		
		
		if(node.right!=null){
			if(node.next!=null)
				node.right.next = node.next.left!=null ? node.next.left : node.next.right;
		}			
		
		populateNext(node.left);
		populateNext(node.right);		
	}
	
	void populateInOrderSuccessor(TreeNode node){
		TreeNode next = null;
		populateInOrderSuccessorRec(node, next);
	}
	
	void populateInOrderSuccessorRec(TreeNode node, TreeNode next){
		if(node == null) return;
		populateInOrderSuccessorRec(node.right, next);
		
		node.next = next;
		next = node;
		
		populateInOrderSuccessorRec(node.left, next);
	}
	
	void traverseNext(){
		if(root == null) return;
		TreeNode node = root;
		while(node!=null){
			TreeNode temp = node;
			node = null;
			while(temp!=null){
				System.out.print(temp.data + " ");
				if(node == null)
					node = temp.left!=null?temp.left:temp.right;
				temp = temp.next;
			}
			System.out.println();		
		}
	}
	
	int toSumTree(TreeNode node){
		if(node == null) return 0;
		int old_value = node.data;
		node.data = toSumTree(node.left) + toSumTree(node.right);
		return old_value + node.data;
	}
	
	
	void createSampleTree(){
		root = new TreeNode(0, new TreeNode(1, new TreeNode(3)), new TreeNode(2, new TreeNode(5), new TreeNode(6, new TreeNode(7), new TreeNode(8))));
	}
	
}
