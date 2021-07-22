/*
Algorithm: Kahn's Algorithm
1. Find in-degree of all the vertices
2. Push the vertices with indegree 0 in a queue to start BFS
3. Do while queue has element:
4. For current vertex: reduce the indegree of vertices present in its adjacency list
5. if any vertex has now indegree as 0, push it into the queue
6. remove the current vertex from queue, add to answer
*/

import java.util.*;

class Graph {
	int v;
	List<Integer> adj[];
  
	public Graph(int v) {
		this.v = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new ArrayList<Integer>();
  }

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
  
	public void topologicalSort() {
    
  //1. Find in-degree of all the vertices
		int indegree[] = new int[v];
		for (int i = 0; i < v; i++) {
			ArrayList<Integer> currAdj = (ArrayList<Integer>)adj[i];
			for (int node : currAdj ) {
				indegree[node]++;
			}
		}
    
  //2. Push the vertices with indegree 0 in a queue to start BFS
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		int count = 0;

		Vector<Integer> topOrder = new Vector<Integer>();
  //3. Do while queue has element:
		while (!q.isEmpty()) {
			int u = q.poll();
			topOrder.add(u);
      //4. For current vertex: reduce the indegree of vertices present in its adjacency list
			for (int node : adj[u]) {
				if (--indegree[node] == 0)
					q.add(node);
			}
			count++;
		}
    
    // If count is not equal to number of vertices, there is a cycle in the graph
		if (count != V) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}
}
