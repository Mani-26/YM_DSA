public class GraphAdjMatrix {
    boolean adjMatrix[][];
    int vertices;
    public GraphAdjMatrix(int vertices){
        this.vertices=vertices;
        adjMatrix=new boolean[vertices][vertices];
    }
    public void addEdge(int i, int j){
        adjMatrix[i][j]=true;
        adjMatrix[j][i]=true;
    }
    public static void main(String[] args) {
        GraphAdjMatrix graph=new GraphAdjMatrix(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(2,3);
    }
}