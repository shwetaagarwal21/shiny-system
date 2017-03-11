package org.shweta.graph;

import java.util.Iterator;

public class DetectCycleDirectedGraph {

	public static void main(String[] args) {
		int noOfVertices = 4;
		DirectedGraph g = new DirectedGraph(noOfVertices);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        DetectCycleDirectedGraph cycle = new DetectCycleDirectedGraph();
        if(cycle.isCyclic(g))
        	System.out.println("Graph contains cycle.");
        else
        	System.out.println("Graph doesn't contain cycle.");
	}
	
	public boolean isCyclic(DirectedGraph g){
		int V = g.V;
		boolean visited[] = new boolean[V];
		boolean recStack[] = new boolean[V];
		
		for(int i = 0; i < V; i++)
			if(isCyclicUtil(g, i, visited, recStack))
				return true;
		
		return false;
	}
	
	public boolean isCyclicUtil(DirectedGraph g, int v, boolean visited[], boolean recStack[]){
		if(!visited[v]){
			visited[v] = true;
			recStack[v] = true;
			
			Iterator<Integer> i = g.adj[v].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n] && isCyclicUtil(g, n, visited, recStack))
					return true;
				else if(recStack[n])
					return true;					
			}
		}
		recStack[v] = false;
		return false;
	}

}
