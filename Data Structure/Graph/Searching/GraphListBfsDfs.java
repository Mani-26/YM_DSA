import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphListBfsDfs {
    static List<List<Integer>> al = new ArrayList<>(); // Adjacency List to store graph

    // Constructor to initialize graph with V vertices
    public GraphListBfsDfs(int V) {
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<>());
        }
    }

    // Method to add an undirected edge between vertices s and d
    public void addEdge(int s, int d) {
        al.get(s).add(d);
        al.get(d).add(s);  // Since it's an undirected graph
    }

    // BFS function using a Queue
    void BFS(int start) {
        boolean[] visited = new boolean[al.size()]; // To track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Mark the start vertex as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        // Perform BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " "); // Print current node

            // Visit all adjacent vertices of the current node
            for (int neighbor : al.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Recursive DFS function for graph traversal
    void DFSRec(boolean[] visited, int node) {
        visited[node] = true; // Mark current node as visited
        System.out.print(node + " "); // Print current node

        // Recursively visit all adjacent vertices not yet visited
        for (int neighbor : al.get(node)) {
            if (!visited[neighbor]) {
                DFSRec(visited, neighbor);
            }
        }
    }

    // Main DFS function which calls the recursive DFS
    void DFS(int start) {
        boolean[] visited = new boolean[al.size()]; // Initialize visited array
        DFSRec(visited, start); // Start DFS from the start node
    }

    public static void main(String[] args) {
        GraphListBfsDfs g = new GraphListBfsDfs(4); // Create a graph with 4 vertices

        // Add edges to the graph (example graph: 0-1, 0-2, 0-3, 2-3)
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);

        // Perform BFS traversal starting from vertex 0
        System.out.print("BFS Traversal: ");
        g.BFS(0);  // BFS from vertex 0
        System.out.println();

        // Perform DFS traversal starting from vertex 0
        System.out.print("DFS Traversal: ");
        g.DFS(0);  // DFS from vertex 0
        System.out.println();
    }
}
