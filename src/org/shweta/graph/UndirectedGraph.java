package org.shweta.graph;

import java.util.LinkedList;

public class UndirectedGraph {
	public int V;
	public LinkedList<Integer> adj[];
	
	public UndirectedGraph(int v){
		this.V = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;++i){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
}
