package dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class dijiAlgo {
	
    public class Edge {
        private Vertex source;
        private Vertex destination;
        private int weight;

        public Edge(Vertex source, Vertex destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public Vertex getSource() {
            return source;
        }

        public void setSource(Vertex source) {
            this.source = source;
        }

        public Vertex getDestination() {
            return destination;
        }

        public void setDestination(Vertex destination) {
            this.destination = destination;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public class Graph {
        private List<Vertex> vertices;
        private Map<Vertex, List<Edge>> adjacencyList;

        public Graph() {
            this.vertices = new ArrayList<>();
            this.adjacencyList = new HashMap<>();
        }

        public void addVertex(Vertex vertex) {
            vertices.add(vertex);
            adjacencyList.put(vertex, new ArrayList<>());
        }

        public void addEdge(Vertex source, Vertex destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList.get(source).add(edge);
        }

        public void dijkstra(Vertex source) {
            // Initialization
            // Set distance of source vertex to 0 and all other vertices to infinity
            // Initialize priority queue (min heap) to store vertices based on their tentative distances
            source.setDistance(0);

            for (Vertex vertex : vertices) {
                if (vertex != source) {
                    vertex.setDistance(Integer.MAX_VALUE);
                }
            }

            PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getDistance));
            pq.add(source);

            while (!pq.isEmpty()) {
                Vertex minVertex = pq.poll();

                List<Edge> edges = adjacencyList.get(minVertex);
                for (Edge edge : edges) {
                    Vertex neighbor = edge.getDestination();
                    int newDistance = minVertex.getDistance() + edge.getWeight();
                    if (newDistance < neighbor.getDistance()) {
                        neighbor.setDistance(newDistance);
                        pq.add(neighbor);
                    }
                }
            }
        }

        public List<Vertex> getVertices() {
            return vertices;
        }

        public void setVertices(List<Vertex> vertices) {
            this.vertices = vertices;
        }
    }
}

    


