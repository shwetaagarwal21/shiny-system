package org.shweta.graph;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class TopologicalSortDirectedGraph {

	public static void main(String[] args) {
		int noOfVertices = 6;
		DirectedGraph g = new DirectedGraph(noOfVertices);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological sort of the given graph");
        
        TopologicalSortDirectedGraph t = new TopologicalSortDirectedGraph();
        t.topologicalSort(g, noOfVertices);
        
        System.out.println("All Topological sorts of the given graph");
        t.alltopologicalSort(g, noOfVertices);
	}
	
	//The function to do topological sort. It uses recursive topologicalSortUtil
	void topologicalSort(DirectedGraph g, int V){
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++)
			if(!visited[i])
				topologicalSortUtil(g, i, visited, stack);
			
		while(!stack.empty())
			System.out.print(stack.pop() + " ");
	}
	
	//A recursive function used by topological sort
	void topologicalSortUtil(DirectedGraph g, int v, boolean visited[], Stack<Integer> stack){
		visited[v] = true;
		Integer i;
		
		Iterator<Integer> it = g.adj[v].listIterator();
		while(it.hasNext()){
			i = it.next();
			if(!visited[i])
				topologicalSortUtil(g, i, visited, stack);			
		}
		// Push current vertex to stack which stores result
		stack.push(new Integer(v));
	}
	
	//The function does all topological sort. It uses recursive alltopologicalSortUtil
	void alltopologicalSort(DirectedGraph g, int V){
		boolean visited[] = new boolean[V];
		Vector<Integer> res = new Vector<>();
		alltopologicalSortUtil(g, res, visited);				
	}
	
	void alltopologicalSortUtil(DirectedGraph g, Vector<Integer> res, boolean visited[]){
		boolean flag = false;
		
	}
	
}
