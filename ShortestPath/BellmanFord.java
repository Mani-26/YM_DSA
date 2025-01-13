package ShortestPath;
public class BellmanFord {
    public static void  findShortest(int graph[][],int v,int e,int src){
        int dist[]=new int[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        for(int i=0;i<v-1;i++){
            for(int j=0;j<e;j++){
                if(dist[graph[j][0]]!=Integer.MAX_VALUE){
                    dist[graph[j][1]]=Math.min(dist[graph[j][0]]+graph[j][2],dist[graph[j][1]]);
                }
            }
        }
        for(int j=0;j<e;j++){
            if(dist[graph[j][0]]!=Integer.MAX_VALUE&&dist[graph[j][0]]+graph[j][2]<dist[graph[j][1]]){
                System.out.println("Negative edge is Present");
            }
        }
        for (int i = 0; i < v; i++) {
        System.out.println(i+" "+dist[i]);
        }
    }
    public static void main(String[] args) {
        int vertices=5;
        int edge=10;
        int graph[][]={{0,1,6},{0,2,7},{1,2,8},{1,3,5},{2,3,-3},{2,4,9},{3,1,-2},{4,0,2},{4,1,-4},{4,3,7}};
        findShortest(graph,vertices,edge,0);
    }
}
