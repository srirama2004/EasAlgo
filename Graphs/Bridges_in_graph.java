
/*
Explanation:
Given an undirected connected Graph with V vertices (Numbered from 0 to V-1) and E edges. An edge is represented [ai, bi] denoting that there is an edge from vertex ai to bi . An edge is called a bridge if its removal makes some vertex unable to reach another vertex.

Return all bridges in the graph in any order.
*/

class Solution {
    private int timer=1;
    private void dfs(int node,int parent,int[]vis,List<Integer>[] adj,int[]tin,int[]low, List<List<Integer>> bridges){
        vis[node]=1;
        tin[node]=low[node]=timer;
         timer++;
         for(int it:adj[node]){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it,node,vis,adj,tin,low,bridges);
                low[node]=Math.min(low[it],low[node]);
                if(low[it]>tin[node])
                bridges.add(Arrays.asList(it,node));
            }
            else{
                 low[node]=Math.min(low[it],low[node]);
            }
         }

    }
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
        int n=V;
      List<Integer>[]adj=new ArrayList[n];
      for(int i=0;i<n;i++){
        adj[i]=new ArrayList<>();
      }
      for(List<Integer>it:E){
        int u=it.get(0),v=it.get(1);
        adj[u].add(v);
        adj[v].add(u);
      }
        int[]vis=new int[n];
        int[]low=new int[n];
        int[] tin = new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
              return bridges;
    }
}


