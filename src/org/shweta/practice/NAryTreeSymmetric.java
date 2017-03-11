package org.shweta.practice;

import java.util.ArrayList;

public class NAryTreeSymmetric {
	
	NAryTreeNode root;
	
	class NAryTreeNode{
		int data;
		ArrayList<NAryTreeNode> children;
		
		NAryTreeNode(int data){
			this.data = data;
			children = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {
		NAryTreeSymmetric tree = new NAryTreeSymmetric();
		tree.createSampleTree();
		System.out.print("If given n-ary tree is symmetric tree: "  + tree.checkSymmetry(tree.root, tree.root));
	}
	
	boolean checkSymmetry(NAryTreeNode a, NAryTreeNode b){
		if(a == null && b == null) 
			return true;
		else if(a == null || b == null) return false;
		else if(a.data == b.data){
			int i = 0;
			int j = b.children.size() - 1;
			while(i<a.children.size() && j>= 0){
				if(!checkSymmetry(a.children.get(i), b.children.get(j))){
					break;
				}
				i++;
				j--;
			}
			if(i<a.children.size() || j>= 0){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}

	void createSampleTree(){
		NAryTreeNode n1 = new NAryTreeNode(1);
        
        NAryTreeNode n20 = new NAryTreeNode(2);
        NAryTreeNode n21 = new NAryTreeNode(2);
        
        NAryTreeNode n3 = new NAryTreeNode(3);
        
        NAryTreeNode n50 = new NAryTreeNode(5);
        NAryTreeNode n51 = new NAryTreeNode(5);
        
        NAryTreeNode n60 = new NAryTreeNode(6);
        NAryTreeNode n61 = new NAryTreeNode(6);

        NAryTreeNode n70 = new NAryTreeNode(7);
        NAryTreeNode n71 = new NAryTreeNode(7);

        root = n1;
        
        root.children.add(n20);
        root.children.add(n3);
        root.children.add(n21);
        
        n20.children.add(n50);
        n20.children.add(n60);
        
        n21.children.add(n61);
        n21.children.add(n51);

        n3.children.add(n70);
	}
	
	
}
