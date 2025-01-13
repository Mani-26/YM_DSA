package ShortestPath;
public class FloydWarshall {
    static int INF =Integer.MAX_VALUE;
    public static void findShortest(int graph[][],int v){
        int dist[][]=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                dist[i][j]=graph[i][j];
            }
        }
        for(int k=0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(dist[i][k]!=INF&&dist[k][j]!=INF&&dist[i][j]>dist[i][k]+dist[k][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        printMatrix(dist,v);
    }
    public static void printMatrix(int dist[][],int v){
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(dist[i][j]==INF) System.out.print("INF ");
                else System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int v=5;
        int graph[][]={{0,1,1,INF,3},{INF,0,INF,INF,INF},{INF,INF,0,0,0},{INF,2,INF,0,INF},{INF,INF,INF,0,0}};
        findShortest(graph,v);
    }
}
