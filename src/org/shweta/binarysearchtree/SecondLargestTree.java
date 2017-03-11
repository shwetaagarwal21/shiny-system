package org.shweta.binarysearchtree;

public class SecondLargestTree {
	
	TreeNode root;
	
	private static int counter;
	private static int counterSmall;

	public static void main(String[] args) {
		SecondLargestTree tree = new SecondLargestTree();
		/*tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);*/
		tree.createSampleTree();
		//tree.secondLargest();
		TreeNode node = tree.findSecondLargest();
		if(node!=null){
			System.out.println("Second largest element is:: " + node.data);
		}
		
		node = tree.findSecondSmallest();
		if(node!=null){
			System.out.println("Second smallest element is:: " + node.data);
		}
	}
	
	void insert(int key){
		root = insertRec(root, key);
	}
	
	TreeNode insertRec(TreeNode root, int key){
		if(root == null){
			root = new TreeNode(key);
			return root;
		}
		
		if(key < root.data)
			root.left = insertRec(root.left, key);
		else
			root.right = insertRec(root.right, key);
		return root;
	}
	
	TreeNode findSecondLargest(){
		return findSecondLargest(root, 2);
	}
	
	TreeNode findSecondLargest(TreeNode rootNode, int k){
		if(rootNode == null)
			return null;
		
		TreeNode node = findSecondLargest(rootNode.right, k);
		if(counter!=k){
			counter++;
			node = rootNode;
		}
		
		if(counter==k)
			return node;
		else
			return findSecondLargest(rootNode.left, k);		
	}
	
	TreeNode findSecondSmallest(){
		return findSecondSmallest(root, 2);
	}
	
	TreeNode findSecondSmallest(TreeNode rootNode, int k){
		if(rootNode == null)
			return null;
		
		TreeNode node = findSecondSmallest(rootNode.left, k);
		if(counterSmall != k){
			counterSmall++;
			node = rootNode;
		}
		
		if(counterSmall == k)
			return node;
		else
			return findSecondSmallest(rootNode.right, k);
			
	}
	
	void secondLargest(){
		int c = 0;
		secondLargestUtil(root, c);
	}
	
	void secondLargestUtil(TreeNode root, int c){
		int k = 0;
		if(root == null || c >= 2)
			return;
		
		secondLargestUtil(root.right, c);
		c++;
		
		if(++k == 2){
			System.out.println("Second largest node is " + root.data);
			return;
		}
		
		secondLargestUtil(root.left, c);		
	}
	
	public void createSampleTree(){
		//root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		root = new TreeNode(50, new TreeNode(30, new TreeNode(20), new TreeNode(40)), new TreeNode(70, new TreeNode(60), new TreeNode(80)));
	}

}
