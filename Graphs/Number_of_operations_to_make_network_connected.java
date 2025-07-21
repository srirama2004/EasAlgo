
/*
Explanation:
Given a graph with n vertices and m edges. The graph is represented by an array Edges, where Edge[i] = [a, b] indicates an edge between vertices a and b. One edge can be removed from anywhere and added between any two vertices in one operation. Find the minimum number of operations that will be required to make the graph connected. If it is not possible to make the graph connected, return -1
*/

class Solution {
    public int solve(int n, int[][] Edge) {
      int size=Edge.length;
      if(size<n-1) return -1;
      DisjointSet ds=new DisjointSet(n);
      for(int i=0;i<size;i++){
        ds.unionByRank(Edge[i][0],Edge[i][1]);
      }
      int count=0;
      for(int i=0;i<n;i++){
        if(ds.parent[i]==i) count++;
      }
return count-1;
    }
}
