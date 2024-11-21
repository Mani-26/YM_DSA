import java.util.LinkedList;
import java.util.Queue;

public class GraphMatBfsDfs {
    private int[][] adjMatrix; // Adjacency matrix
    private int V; // Number of vertices

    // Constructor to initialize the adjacency matrix and number of vertices
    public GraphMatBfsDfs(int V) {
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

    // Recursive function for DFS traversal
    private void DFSRec(int[][] adjMatrix, boolean[] visited, int v) {
        // Mark the current vertex as visited
        visited[v] = true;

        // Print the current vertex
        System.out.print(v + " ");

        // Recur for all adjacent vertices that are not visited
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v][i] == 1 && !visited[i]) {
                DFSRec(adjMatrix, visited, i);
            }
        }
    }

    // Main DFS function that initializes the visited array
    public void DFS(int start) {
        boolean[] visited = new boolean[V]; // To track visited vertices
        DFSRec(adjMatrix, visited, start); // Call the recursive function
    }


    public static void main(String[] args) {
        GraphMatBfsDfs g = new GraphMatBfsDfs(4);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);

        // Perform BFS starting from vertex 0
        System.out.print("BFS Traversal: ");
        g.BFS(0);
        System.out.println();

        // Perform DFS starting from vertex 0
        System.out.print("DFS Traversal: ");
        g.DFS(0);
        System.out.println();
    }
}
