
/*
Explanation:
Given n, m denoting the row and column of the 2D matrix, and an array A of size k denoting the number of operations. Matrix elements are 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integers A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many islands are there in the matrix after each operation.
*/

class Solution {
      int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};
    boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        return true;
    }
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        DisjointSet ds=new DisjointSet(n*m);
        int[][]vis=new int[n][m];
        for(int[]row:vis) Arrays.fill(row,0);
        int cnt=0;
        List<Integer>ans=new ArrayList<>();
        for(int[]it:A){
            int row=it[0];
            int col=it[1];
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            vis[row][col]=1;
            cnt++;
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                if(isValid(nrow,ncol,n,m) && vis[nrow][ncol]==1){
                    int adjnode=nrow*m+ncol;
                    int node=row*m+col;
                    if(ds.findUPar(adjnode)!=ds.findUPar(node)){
                        ds.unionBySize(node,adjnode);
                        cnt--;
                    }
                }

            }
ans.add(cnt);
        }
        return ans;
    }
}



