package org.shweta.graph;

import java.util.Iterator;

public class DFSGraph {

	public static void main(String[] args) {
		int noOfVertices = 4;
		DirectedGraph g = new DirectedGraph(noOfVertices);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");
        
        DFS(g, 2, noOfVertices);
	}
	
	static void DFS(DirectedGraph g, int s, int V){
		boolean visited[] = new boolean[V];
		DFSUtil(g, s, visited);				
	}
	
	static void DFSUtil(DirectedGraph g, int v, boolean visited[]){
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = g.adj[v].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n])
				DFSUtil(g, n, visited);
		}
	}
	
}
