package Graph;

import java.util.Arrays;

public class Djikstra {
    public static void main(String[] args) {
        int ar[][] =   {{0,5,10,0},
                        {5,0,3,20},
                        {10,3,0,2},
                        {0,20,2,0}};
        //int[] ans=  djikstra(ar,0);
        System.out.println(Arrays.toString(djikstra(ar,0)));
     }
    static int[] djikstra (int[][] graph, int src) {
        int v=graph.length;
        int[] dist = new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        boolean fin[]=new boolean[v];
        for (int c=0;c<v-1;c++) {
            int u=-1;
            for (int i=0;i<v;i++) {
                if (!fin[i] && (u==-1||dist[i]<dist[u])) u=i;
            }
            fin[u]=true;
            for(int j=0;j<v;j++) {
                if (!fin[j] && graph[u][j]!=0)
                    dist[j]=Math.min(dist[j],dist[u]+graph[u][j]);
            }
        }
        return dist;
    }
}
