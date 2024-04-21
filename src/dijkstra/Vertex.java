package dijkstra;

public class Vertex {
	private int id;
	private int distance;
	private boolean visited;
	public char label;
	
	public Vertex(char label) {
		this.label = label;
		this.distance = Integer.MAX_VALUE;
		this.visited = false;
	}
	public int getId() {
		return id;
		
	}
	public int getDistance() {
		return distance;
		
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public boolean isVisited() {
		return visited;
		
	}
	public void setVisited (boolean visited){
		this.visited = visited;
		
	}
	public String getName() {
		return null;
	}
	public char getLabel() {
	    return label;
	}
}
