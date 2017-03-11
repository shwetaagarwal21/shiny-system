package org.shweta.graph;

import java.util.Iterator;

public class DetectCycleUndirectedGraph {

	public static void main(String[] args) {
		int noOfVertices = 5;
		UndirectedGraph graph1 = new UndirectedGraph(noOfVertices);
		graph1.addEdge(1, 0);
		graph1.addEdge(0, 2);
		//graph1.addEdge(2, 1);
		graph1.addEdge(2, 0);
		graph1.addEdge(0, 3);
		graph1.addEdge(3, 4);
		DetectCycleUndirectedGraph cycle = new DetectCycleUndirectedGraph();
		if (cycle.isCyclic(graph1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
		
		noOfVertices = 3;
		UndirectedGraph graph2 = new UndirectedGraph(noOfVertices);
		graph2.addEdge(0, 1);
		graph2.addEdge(1, 2);
		cycle = new DetectCycleUndirectedGraph();
		if (cycle.isCyclic(graph2))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
	}
	
	public boolean isCyclic(UndirectedGraph g){
		int V = g.V;
		boolean visited[] = new boolean[V];
		
		for(int i = 0; i < V; i++)
			if(!visited[i])
				if(isCyclicUtil(g, i, visited, -1))
					return true;
			
		return false;
	}
	
	public boolean isCyclicUtil(UndirectedGraph g, int v, boolean visited[], int parent){
		visited[v] = true;
		int n;
		Iterator<Integer> it = g.adj[v].listIterator();
		while(it.hasNext()){
			n = it.next();
			if(!visited[n]){
				if(isCyclicUtil(g, n, visited, v))
					return true;
			}
			else if(n != parent)
				return true;
		}
		return false;
	}

}
