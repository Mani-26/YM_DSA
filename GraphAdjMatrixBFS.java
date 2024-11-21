import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjMatrixBFS {
    private int[][] adjMatrix; // Adjacency matrix
    private int V; // Number of vertices

    // Constructor to initialize the adjacency matrix and number of vertices
    public GraphAdjMatrixBFS(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    // Add an edge between source and destination
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // Since the graph is undirected
    }

    // BFS function
    public void BFS(int start) {
        boolean[] visited = new boolean[V]; // To track visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Mark the start vertex as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Dequeue a vertex and print it
            int current = queue.poll();
            System.out.print(current + " ");

            // Enqueue all unvisited adjacent vertices
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true; // Mark as visited
                    queue.add(i); // Enqueue the adjacent vertex
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjMatrixBFS g = new GraphAdjMatrixBFS(4);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);

        // Perform BFS starting from vertex 0
        System.out.print("BFS Traversal: ");
        g.BFS(0);
    }
}
