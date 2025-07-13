
/*
Explanation:
Given a directed graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.
*/

class Solution {
    public boolean dfs(int node,List<List<Integer>> adj,boolean[]vis,boolean[]pvis){
        vis[node]=true;
        pvis[node]=true;
        for(int adjnode:adj.get(node)){
            if(!vis[adjnode]){
                if(dfs(adjnode,adj,vis,pvis))
                return true;
            }
            else if(pvis[adjnode])
            return true;
        }
        pvis[node]=false;
        return false;
    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
      boolean[] vis=new boolean[N];
       boolean[] pvis=new boolean[N];
       for(int i=0;i<N;i++){
        if(!vis[i]){
            if(dfs(i,adj,vis,pvis))
            return true;
        }
       }
       return false;
    }
}

