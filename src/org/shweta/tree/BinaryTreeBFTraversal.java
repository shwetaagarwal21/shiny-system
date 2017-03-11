package org.shweta.tree;

public class BinaryTreeBFTraversal {

	Node root;
	 
    public BinaryTreeBFTraversal()
    {
        root = null;
    }
	
    /* Driver program to test above functions */
    public static void main(String args[])
    {
    	BinaryTreeBFTraversal tree = new BinaryTreeBFTraversal();
    	tree.root= new Node(1);
    	tree.root.left= new Node(2);
    	tree.root.right= new Node(3);
    	tree.root.left.left= new Node(4);
    	tree.root.left.right= new Node(5);
        
    	System.out.println("Level order traversal of binary tree is ");
    	tree.printLevelOrder();
    }
	
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        System.out.println("Height of tree is :: " + h);
        int i;
        for (i=1; i<=h; i++){
            printGivenLevel(root, i);
        	System.out.println("     ");
        }
    }
	
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
	
	/* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }

}
