
/*
Explanation:
Given a weighted and directed graph of V vertices and E edges. An edge is represented as [ai, bi, wi], meaning there is a directed edge from ai to bi having weight wi. Find the shortest distance of all the vertices from the source vertex S. If a vertex can't be reached from the S then mark the distance as 109.

If the graph contains a negative cycle then return -1 in a list.
*/

class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
    int[]dist=new int[V];
    Arrays.fill(dist,(int)1e9);
    dist[S]=0;
    for(int i=0;i<V-1;i++){
        for(ArrayList<Integer>it:edges){
            int u=it.get(0);
            int v=it.get(1);
            int wt=it.get(2);
            if(dist[u]!=1e9 && dist[u]+wt<dist[v]){
                dist[v]=dist[u]+wt;
            }
        }
    }
      for(ArrayList<Integer>it:edges){
            int u=it.get(0);
            int v=it.get(1);
            int wt=it.get(2);
            if(dist[u]!=1e9 && dist[u]+wt<dist[v]){
              return new int[]{-1};
            }
      }
      return dist;
    }
}
