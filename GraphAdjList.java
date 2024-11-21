import java.util.ArrayList;
import java.util.List;

public class GraphAdjList {
    List<List<Integer>> al=new ArrayList<>();
    public GraphAdjList(int V){
        for(int i=0;i<V;i++){
            al.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int s,int d){
        al.get(s).add(d);
        al.get(d).add(s);
    }
    public static void main(String[] args) {
        GraphAdjList g=new GraphAdjList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);
    }
}
