import java.util.ArrayList;
import java.util.List;

public class GraphAdjListDFS {
    static List<List<Integer>> al = new ArrayList<>();

    public GraphAdjListDFS(int V) {
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int s, int d) {
        al.get(s).add(d);
        al.get(d).add(s);
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
        GraphAdjListDFS g = new GraphAdjListDFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
        g.DFS(al, 0);
    }
}
