import java.util.Arrays;

public class Prims {
    static final int V = 6; 

    static int selectMinVertex(int[] value, boolean[] setMST) {
        int minimum = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < V; i++) {
            if (!setMST[i] && value[i] < minimum) {
                vertex = i;
                minimum = value[i];
            }
        }
        return vertex;
    }

    static void findMST(int[][] graph) {
        int[] parent = new int[V];  // Array to store MST
        int[] value = new int[V];   // Array to store minimum edge weights
        boolean[] setMST = new boolean[V];  // Array to track vertices included in MST

        Arrays.fill(value, Integer.MAX_VALUE);  // Initialize all values to infinity
        value[0] = 0;  // Start from the first vertex, setting its value to 0
        parent[0] = -1;  // Start node has no parent

        // Form MST with (V-1) edges
        for (int i = 0; i < V - 1; i++) {
            // Select best vertex by applying greedy method
            int U = selectMinVertex(value, setMST);
            setMST[U] = true;  // Include new vertex in MST

            // Relax adjacent vertices not yet included in MST
            for (int j = 0; j < V; j++) {
                /* 3 conditions for relaxing:
                   1. There is an edge from U to j
                   2. Vertex j is not included in MST
                   3. The edge weight is less than the current edge weight
                */
                if (graph[U][j] != 0 && !setMST[j] && graph[U][j] < value[j]) {
                    value[j] = graph[U][j];
                    parent[j] = U;
                }
            }
        }

        // Print MST
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[parent[i]][i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = { 
            { 0, 4, 6, 0, 0, 0 },
            { 4, 0, 6, 3, 4, 0 },
            { 6, 6, 0, 1, 8, 0 },
            { 0, 3, 1, 0, 2, 3 },
            { 0, 4, 8, 2, 0, 7 },
            { 0, 0, 0, 3, 7, 0 }
        };

        findMST(graph);
    }
}
