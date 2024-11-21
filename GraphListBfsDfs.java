import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphListBfsDfs {
    static List<List<Integer>> al = new ArrayList<>();

    public GraphListBfsDfs(int V) {
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int s, int d) {
        al.get(s).add(d);
        al.get(d).add(s);
    }

    // BFS function
    void BFS(List<List<Integer>> al, int start) {
        boolean[] visited = new boolean[al.size()]; // To track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        // Mark the start vertex as visited and enqueue it
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            // Dequeue a vertex and print it
            int current = queue.poll();
            System.out.print(current + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent has not been visited, mark it visited and enqueue it
            for (int neighbor : al.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Recursive function for DFS traversal
    void DFSRec(List<List<Integer>> al, boolean[] visited, int s) {
        // Mark the current vertex as visited
        visited[s] = true;

        // Print the current vertex
        System.out.print(s + " ");

        // Recursively visit all adjacent vertices that are
        // not visited yet
        for (int i : al.get(s)) {
            if (!visited[i]) {
                DFSRec(al, visited, i);
            }
        }
    }

    // Main DFS function that initializes the visited array
    void DFS(List<List<Integer>> al, int s) {
        boolean[] visited = new boolean[al.size()];
        // Call the recursive DFS function
        DFSRec(al, visited, s);
    }

    public static void main(String[] args) {
        GraphListBfsDfs g = new GraphListBfsDfs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);

        // Perform BFS starting from vertex 0
        System.out.print("BFS Traversal: ");
        g.BFS(al, 0);
        System.out.println();

        // Perform DFS starting from vertex 0
        System.out.print("DFS Traversal: ");
        g.DFS(al, 0);
        System.out.println();
    }
}
