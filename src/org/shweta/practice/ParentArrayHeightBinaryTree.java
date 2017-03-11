package org.shweta.practice;

public class ParentArrayHeightBinaryTree {
	
	TreeNode root;
	
	public static void main(String[] args) {
		ParentArrayHeightBinaryTree tree = new ParentArrayHeightBinaryTree();
		int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5}; //{1, 5, 5, 2, 2, -1, 3};
		System.out.println("Height is  " + tree.findHeight(parent, parent.length));
		
		TreeNode node = tree.createTree(parent, parent.length);
	}
	
	TreeNode createTree(int[] parent, int n){
		TreeNode[] created = new TreeNode[n];
		for(int i=0;i<n;i++)
			createNode(parent, i, created);
		
		return root;
	}
	
	void createNode(int[] parent, int i, TreeNode[] created){
		if(created[i] != null) return;
		
		created[i] = new TreeNode(i);
		
		if(parent[i] == -1){
			root = created[i];
			return;
		}
		
		if(created[parent[i]] == null)
			createNode(parent, parent[i], created);
		
		TreeNode p = created[parent[i]];
		if(p.left == null)
			p.left = created[i];
		else
			p.right = created[i];
		
	}
	
	
	//returns height of binary tree represented by parent array
	int findHeight(int[] parent, int n){
		int depth[] = new int[n];
		for(int i=0;i<n;i++){
			fillDepth(parent, i, depth);
		}
		int ht = depth[0];
		for(int i=1;i<n;i++){
			if(ht<depth[i])
				ht = depth[i];
		}
		return ht;
	}
	
	void fillDepth(int[] parent, int i, int depth[]){
		if(depth[i] != 0)
			return;
		
		if(parent[i] == -1){
			depth[i] = 1;
			return;
		}
		
		if(depth[parent[i]] == 0){
			fillDepth(parent, parent[i], depth);
		}
		
		depth[i] = depth[parent[i]] + 1;		
	}

}
