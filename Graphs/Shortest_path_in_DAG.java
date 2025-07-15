
/*
Explanation:
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and M edges and a 2D Integer array edges, where there is a directed edge from vertex edge[i][0] to vertex edge[i][1] with a distance of edge[i][2] for all i.



Find the shortest path from source vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex. The source vertex is assumed to be 0.
*/

class Solution {
    static class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    private void topoSort(int node,List<List<Pair>> adj,boolean[] vis, Stack<Integer> st){
        vis[node]=true;
        for(Pair adjnode:adj.get(node)){
            int v=adjnode.first;
            if (!vis[v]) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
  public int[] shortestPath(int N, int M, int[][] edges) {
     List<List<Pair>>adj=new ArrayList<>();
     for(int i=0;i<N;i++){
        adj.add(new ArrayList<>());
     }
     for(int i=0;i<M;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int wt=edges[i][2];
        adj.get(u).add(new Pair(v,wt));
     }
     boolean[]vis=new boolean[N];
      Stack<Integer> st = new Stack<>();
      for(int i=0;i<N;i++){
        if(!vis[i])
        topoSort(i,adj,vis,st);
      }
       int[] dist = new int[N];
        Arrays.fill(dist, (int)1e9);
        dist[0]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            for(Pair it:adj.get(node)){
                int v=it.first;
                int wt=it.second;
                if(dist[node]+wt<dist[v])
                dist[v]=wt+dist[node];
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i]==(int)1e9)
            dist[i]=-1;
        }
        return dist;
  }
}
