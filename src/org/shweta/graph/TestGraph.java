package org.shweta.graph;

import java.util.Scanner;

import javafx.util.Pair;

public class TestGraph {

	public static void main(String[] args) {
		System.out.println("Enter the number of vertices and edges in graph");
		System.out.println("followed by ");
		System.out.println("Enter the edges in graph Format : <source index> <destination index>");
		Scanner s = new Scanner(System.in);
		
		int vertices = s.nextInt();
		int edges = s.nextInt();
		int u, v, weight;
		weight = 0;
		
		AdjacencyList adjacencyList = new AdjacencyList(vertices);
		int i=0;
		while(i < edges){
			u = s.nextInt() - 1;
			v = s.nextInt() - 1;
			//weight = s.nextInt();
			
			adjacencyList.addEdge(u, v, weight);
			System.out.println("i:: " + i + " u: " + u + "  v: " + v);
			++i;
		}
		
		adjacencyList.printAdjacencyList();
		/*adjacencyList.removeEdge(0, new Pair<>(1,1));
		adjacencyList.printAdjacencyList();*/
	}

}
