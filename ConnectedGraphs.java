// Java program to print connected components in
// an undirected graph
import java.util.ArrayList;
class Graph {
  
	int V;
	ArrayList<ArrayList<Integer> > adjListArray;

	Graph(int V) {
		this.V = V;
		adjListArray = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adjListArray.add(i, new ArrayList<>());
		}
	}

	// Adds an edge to an undirected graph
	void addEdge(int src, int dest) {
		adjListArray.get(src).add(dest);
		adjListArray.get(dest).add(src);
	}

	void DFSUtil(int v, boolean[] visited) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		for (int x : adjListArray.get(v)) {
			if (!visited[x])
				DFSUtil(x, visited);
		}
	}
  
	void connectedComponents() {
		// Mark all the vertices as not visited
		boolean[] visited = new boolean[V];
		for (int v = 0; v < V; ++v) {
			if (!visited[v]) {
				DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	// Driver code
	public static void main(String[] args)
	{
		Graph g = new Graph(5); 
		g.addEdge(1, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
    
		System.out.println("Following are connected components");
		g.connectedComponents();
	}
}
