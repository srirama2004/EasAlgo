
/*
Explanation:
Given an undirected graph with V vertices. Two vertices u and v belong to a single province if there is a path from u to v or v to u. Find the number of provinces. The graph is given as an n x n matrix adj where adj[i][j] = 1 if the ith city and the jth city are directly connected, and adj[i][j] = 0 otherwise.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
*/

class Solution {
  private void dfs(int node,boolean vis[], List<Integer>adjLs[]){
    vis[node]=true;
    for(int it:adjLs[node]){
      if(!vis[it])
        dfs(it,vis,adjLs);
    }
  }
    public int numProvinces(int[][] adj) {
        int V=adj.length;
       List<Integer>adjLs[]=new ArrayList[V];
       for(int i=0;i<V;i++){
        adjLs[i]=new ArrayList<>();
       }
        for(int i=0;i<V;i++){
          for(int j=0;j<V;j++){
            if(adj[i][j]==1 && i!=j){
            adjLs[i].add(j);
            adjLs[j].add(i);
            }
          }
        }
        boolean []vis=new boolean[V];
        int cnt=0;
        for(int i=0;i<V;i++){
          if(!vis[i]){
            cnt++;
            dfs(i,vis,adjLs);
          }
        }
        return cnt;
    }
}


