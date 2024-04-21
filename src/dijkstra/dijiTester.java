package dijkstra;

import java.util.ArrayList;

import dijkstra.dijiAlgo.Graph;


public class dijiTester {
	public static void main(String[] args) {
	// Create vertices
    Vertex A = new Vertex('a');
    Vertex B = new Vertex('b');
    Vertex C = new Vertex('c');
    Vertex D = new Vertex('d');
    Vertex E = new Vertex('e');
    Vertex F = new Vertex('f');
    Vertex G = new Vertex('g');

    // Create the graph
    Graph graph = new dijiAlgo().new Graph();
  
    char[] labels = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
    Vertex[] vertices = new Vertex[labels.length];
    for (int i = 0; i < labels.length; i++) {
        Vertex vertex = new Vertex(labels[i]);
        vertices[i] = vertex;
        graph.addVertex(vertex);
    }
    
    // Add edges
    graph.addEdge(vertices[0], vertices[1], 2);
    graph.addEdge(vertices[0], vertices[2], 5);
    graph.addEdge(vertices[0], vertices[3], 1);
    graph.addEdge(vertices[1], vertices[4], 3);
    graph.addEdge(vertices[2], vertices[3], 2);
    graph.addEdge(vertices[2], vertices[5], 9);
    graph.addEdge(vertices[3], vertices[4], 4);
    graph.addEdge(vertices[4], vertices[5], 6);
    graph.addEdge(vertices[4], vertices[6], 5);
    graph.addEdge(vertices[5], vertices[6], 1);

    // Run Dijkstra's algorithm from vertex A
    graph.dijkstra(vertices[0]);

    // Print the shortest paths from vertex A to all other vertices
    System.out.println("Shortest path from s to every vertex:");
    System.out.print("Vertices: \t");
    for (Vertex v : graph.getVertices())
        System.out.print(v.getLabel() + "\t");
    System.out.println();
    System.out.print("Distances: \t");
    for (Vertex v : graph.getVertices())
        System.out.print(v.getDistance() + "\t");
    System.out.println();
}
}
