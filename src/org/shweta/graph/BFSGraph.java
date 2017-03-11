package org.shweta.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {

	public static void main(String[] args) {
		int noOfVertices = 4;
		DirectedGraph g = new DirectedGraph(noOfVertices);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");
        
        BFS(g, 2, noOfVertices);        
	}
	
	static void BFS(DirectedGraph g, int s, int V){
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0){
			s = queue.poll();
			System.out.print(s + " ");	
		
			Iterator<Integer> i = g.adj[s].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

}
