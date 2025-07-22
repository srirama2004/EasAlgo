
/*
Explanation:
Given an n x n binary matrix grid, it is allowed to change at most one 0 to 1. A group of connected 1s forms an island, where two 1s are connected if they share one of their sides.

Return the size of the largest island in the grid after applying this operation.
*/

class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by rank
    void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
class Solution {
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
        private boolean isValid(int i, int j, int n) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= n) return false;
        return true;
    }
    private void addInitialIslands(int[][]grid,DisjointSet ds,int n){
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0)continue;
                for(int ind=0;ind<4;ind++){
                    
                    int nrow=row+delRow[ind];
                    int ncol=col+delCol[ind];
                    if(isValid(nrow,ncol,n) && grid[nrow][ncol]==1){
                    int nodeno=row*n+col;
                    int adjnode=nrow*n+ncol;
                    ds.unionBySize(nodeno,adjnode);
                    }

                }
            }
        }
    }
    public int largestIsland(int[][] grid) {
       int n=grid.length;
       DisjointSet ds=new DisjointSet(n*n);
       addInitialIslands(grid,ds,n);
       int ans=0;
       for(int row=0;row<n;row++){
        for(int col=0;col<n;col++){
            if(grid[row][col]==1) continue;
            Set<Integer>com=new HashSet<>();
            for(int ind=0;ind<4;ind++){
                int nrow=row+delRow[ind];
                int ncol=col+delCol[ind];
                if(isValid(nrow,ncol,n) && grid[nrow][ncol]==1){
                    int nodeNumber=nrow*n+ncol;
                    com.add(ds.findUPar(nodeNumber));
                }
            }
            int sizeTotal=0;
            for(int parent:com){
                sizeTotal+=ds.size[ds.findUPar(parent)];
            }
            ans=Math.max(ans,sizeTotal+1);
        }
       }
for(int cellNo=0;cellNo<n*n;cellNo++){
    ans=Math.max(ans,ds.size[ds.findUPar(cellNo)]);
}
return ans;
    }
}



