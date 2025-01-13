import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class KruskalAlgorithm {
    private int vertices;
    private List<Edge> edges;

    public KruskalAlgorithm(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    // Add edge to the graph
    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    // Find parent of a node (Union-Find)
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    // Union of two sets
    private void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    // Kruskal's Algorithm
    public void kruskalMST() {
        Collections.sort(edges); // Sort edges by weight
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        // Initialize Union-Find
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int rootSource = find(parent, edge.source);
            int rootDestination = find(parent, edge.destination);

            // If adding this edge doesn't create a cycle
            if (rootSource != rootDestination) {
                mst.add(edge);
                union(parent, rank, rootSource, rootDestination);
            }
        }

        // Print MST
        System.out.println("Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 6);

        graph.kruskalMST();
    }
}
