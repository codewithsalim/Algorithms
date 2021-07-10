import java.util.*;

class Graph{
  private boolean visited[];
  private LinkedList<Integer> adjList[];
  
  //Graph creation
  Graph(int vertices){
    adjList = new LinkedList[vertices];
    for (int i = 0; i < v; i++){
      adjList[i] = new LinkedList<Integer>();
    }
  }
  
  void addEdge(int source, int destination){
    adjList[source].add(destination);
  }
  
  //Depth first search
  void DFS(int start){
    visited[start] = true;
    Sytem.out.println( start + " ");
    
    Iterator<Integer> it = adjList[vertex].listIteraor();
    while( it.hasNext() ){
      int adj = it.next();
      if (! visited[adj]){
        DFS(adj);
      }      
    }
  }
  
  public static void main(String[] args){
    Graph graph = new Graph(3);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    System.out.println("Depth first traversal: ");
    graph.DFS(0);
  }
  
}
