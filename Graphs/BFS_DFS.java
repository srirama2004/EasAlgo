
/*
Explanation:
Given an undirected connected graph with V vertices numbered from 0 to V-1, the task is to implement both Depth First Search (DFS) and Breadth First Search (BFS) traversals starting from the 0th vertex. The graph is represented using an adjacency list where adj[i] contains a list of vertices connected to vertex i. Visit nodes in the order they appear in the adjacency list.
*/

class Solution {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
      ArrayList<Integer>ans=new ArrayList<>();
       boolean vis[]=new boolean[V];
       for(int i=0;i<V;i++){
        if(!vis[i]){
            dfs(i,adj,vis,ans);
        }
       }
       return ans;
    }
    private void dfs(int node,List<List<Integer>>adj,boolean[]vis,List<Integer>ans){
        vis[node]=true;
        ans.add(node);
        for(int neighbor:adj.get(node)){
            if(!vis[neighbor])
            dfs(neighbor,adj,vis,ans);
        }
        
            }
    
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        ArrayList<Integer>bfs=new ArrayList<>();
        boolean vis[]=new boolean[V];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer it:adj.get(node)){
                if(!vis[it]){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}


