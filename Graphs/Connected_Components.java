
/*
Explanation:
Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.
A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
*/

class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
    int E=edges.size();
    List<Integer>adjLs[]=new ArrayList[V];
    for(int i=0;i<V;i++){
      adjLs[i]=new ArrayList<>();
    }
    for(int i=0;i<E;i++){
      adjLs[edges.get(i).get(0)].add(edges.get(i).get(1));
      adjLs[edges.get(i).get(1)].add(edges.get(i).get(0));
    }
    boolean[]vis=new boolean[V];
    int cnt=0;
    for(int i=0;i<V;i++){
      if(!vis[i]){
        cnt++;
        bfs(i,adjLs,vis);
      }
    }
    return cnt;
    }
    private void bfs(int node,List<Integer>adjLs[],boolean[]vis){
      vis[node]=true;
      Queue<Integer>q=new LinkedList<>();
      q.add(node);
      while(!q.isEmpty()){
        int i=q.poll();
        for(int adjNodes:adjLs[i]){
          if(!vis[adjNodes]){
            vis[adjNodes]=true;
            q.add(adjNodes);
          }
        }
      }
    }
}

