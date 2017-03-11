package org.shweta.graph;

import java.util.LinkedList;

public class DirectedGraph {
	
	public int V; // No of vertices
	public LinkedList<Integer> adj[]; // Adjacency lists
	
	public DirectedGraph(int v){
		this.V = v;
		this.adj = new LinkedList[v];
		for(int i=0; i<v; ++i){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
}
