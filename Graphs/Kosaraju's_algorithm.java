
/*
Explanation:
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges. An edge is represented [ai,bi] denoting a directed edge from vertex ai to bi. Find the number of strongly connected components in the graph.
*/

class Solution {
  private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
    vis[node] = 1;
    for (int it : adj.get(node)) {
      if (vis[it] == 0) {
        dfs(it, vis, adj, st);
      }
    }
    st.push(node);
  }

  private void dfs2(int node, int[] vis, ArrayList<ArrayList<Integer>> adj) {
    vis[node] = 1;
    for (int it : adj.get(node)) {
      if (vis[it] == 0) {
        dfs2(it, vis, adj);
      }
    }
  }

  public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] vis = new int[V];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) dfs(i, vis, adj, st);
    }
    ArrayList<ArrayList<Integer>>adjt=new ArrayList<>();
    for(int i=0;i<V;i++){
        adjt.add(new ArrayList<>());
    }
    for(int i=0;i<V;i++){
        vis[i]=0;
        for(int it:adj.get(i)){
            adjt.get(it).add(i);
        }
    }
    int count=0;
    while(!st.isEmpty()){
        int node=st.pop();
        if(vis[node]==0){
            count++;
            dfs2(node,vis,adjt);
        }
    }
    return count;
  }
}

