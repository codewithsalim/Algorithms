import java.util.*;
class Edge {
    String destination;
    int weight;

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Node {
    String vertex;
    int cost;

    public Node(String vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}


class Graph {
    private final Map<String, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());
        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // For undirected graph
    }

    public void dijkstra(String startVertex) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            visited.put(vertex, false);
        }

        distances.put(startVertex, 0);
        priorityQueue.add(new Node(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            String currentVertex = currentNode.vertex;

            if (visited.get(currentVertex)) continue;
            visited.put(currentVertex, true);

            for (Edge edge : adjacencyList.get(currentVertex)) {
                String destination = edge.destination;
                int weight = edge.weight;

                if (!visited.get(destination) && distances.get(currentVertex) + weight < distances.get(destination)) {
                    distances.put(destination, distances.get(currentVertex) + weight);
                    priorityQueue.add(new Node(destination, distances.get(destination)));
                }
            }
        }

        printShortestPaths(distances, startVertex);
    }

    private void printShortestPaths(Map<String, Integer> distances, String startVertex) {
        System.out.println("Dijkstra's Shortest Path Algorithm:");
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " from Vertex " + startVertex + " has distance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 4);
        graph.addEdge("D", "E", 2);
        graph.addEdge("E", "F", 6);

        graph.dijkstra("A");
    }
}

