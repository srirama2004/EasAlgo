
/*
Explanation:
Given an undirected graph with V vertices and adjacency list adj. Find all the vertices removing which (and edges through it) would increase the number of connected components in the graph. The graph may be initially disconnected.. Return the vertices in ascending order. If there are no such vertices then returns a list containing -1.

Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might be loops present in the graph.
*/

class Solution {
    private int timer=1;
    private void dfs(int node,int parent,boolean[]vis,int[]tin,int[]low,boolean[] mark,ArrayList<ArrayList<Integer>>adj){
        vis[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        int child=0;
        for(int it:adj.get(node)){
            if(it==parent) continue;
            if(!vis[it]){
                dfs(it,node,vis,tin,low,mark,adj);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>=tin[node] && parent!=-1)
                mark[node]=true;
                child++;
            }
            else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }
        if(child>1 && parent==-1)
        mark[node]=true;

    }
    public ArrayList<Integer> articulationPoints(int n,
            ArrayList<ArrayList<Integer>> adj) {
       boolean[]vis=new boolean[n];
       int[]tin=new int[n];
       int[]low=new int[n];
       boolean[]mark=new boolean[n];
       for(int i=0;i<n;i++){
        if(!vis[i]){
            dfs(i,-1,vis,tin,low,mark,adj);
        }
       }
       ArrayList<Integer>ans=new ArrayList<>();
       for(int i=0;i<n;i++){
        if(mark[i])
        ans.add(i);
       }
       if(ans.size()==0)
       return new ArrayList<>(Arrays.asList(-1));
       return ans;
    }
}


