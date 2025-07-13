
/*
Explanation:
Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph is bipartite or not.

A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
*/

class Solution {
    private boolean bfs(int node,int[]col,List<List<Integer>> adj){
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        col[node]=0;
        while(!q.isEmpty()){
             node=q.poll();
            for(int adjnode:adj.get(node)){
                if(col[adjnode]==-1){
                    col[adjnode]=1-col[node];
                    q.add(adjnode);
                }
                else if(col[adjnode]==col[node])
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int V, List<List<Integer>> adj) {
      int col[]=new int[V];
       Arrays.fill(col, -1);
      for(int i=0;i<V;i++){
        if(col[i]==-1){
        if(!bfs(i,col,adj))
        return false;
        }
      }
      return true;
    }
}

