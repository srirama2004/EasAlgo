
/*
Explanation:
Given a directed graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes adjacent to node i, meaning there is an edge from node i to each node in adj[i]. A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node. Return an array containing all the safe nodes of the graph in ascending order.
*/

class Solution {
   public boolean dfs(int node,int[][] adj,boolean[]vis,boolean[]pvis,int[]check){
        vis[node]=true;
        pvis[node]=true;
        check[node]=0;
        for(int adjnode:adj[node]){
            if(!vis[adjnode]){
                if(dfs(adjnode,adj,vis,pvis,check))
                return true;
            }
            else if(pvis[adjnode])
            return true;
        }
        check[node]=1;
        pvis[node]=false;
        return false;
    }
    public int[] eventualSafeNodes(int V, int[][] adj) {
        boolean[] vis=new boolean[V];
       boolean[] pvis=new boolean[V];
       int[]check=new int[V];
     
       for(int i=0;i<V;i++){
        if(!vis[i]){
            dfs(i,adj,vis,pvis,check);
        }
       }
       int ind=0;
        List<Integer> temp = new ArrayList<>();
      for(int i=0;i<V;i++){
        if(check[i]==1)
          temp.add(i);
      }
        int[]safe=new int[temp.size()];
     for (int i = 0; i < temp.size(); i++) {
            safe[i] = temp.get(i);
        }
      return safe;
    }
}

