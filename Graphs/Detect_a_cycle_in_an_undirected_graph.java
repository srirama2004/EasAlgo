
/*
Explanation:
Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.

Note: The graph does not contain any self-edges (edges where a vertex is connected to itself).
*/

class Solution {
    public boolean dfs(int node,int parent,List<Integer>[] adj,boolean[]vis){
        vis[node]=true;
        for(int adjnode:adj[node]){
            if(!vis[adjnode]){
                if(dfs(adjnode,node,adj,vis))
                return true;
            }
            else if(parent!=adjnode)
            return true;
        }
        return false;
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[]vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
             if(dfs(i,-1,adj,vis))
                return true;
            }
        }
        return false;
    }
}

