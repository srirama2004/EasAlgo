
/*
Explanation:
Given a boolean 2D matrix grid of size N x M. Find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be same if and only if one island is equal to another (not rotated or reflected
*/

class Solution {
     private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};

    /* Helper function to check if a 
    cell is within boundaries */
    private boolean isValid(int i, int j, int n, int m) {
        // Return false if cell is invalid
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= m) return false;
        // Return true if cell is valid
        return true;
    }
    private void dfs(int row,int col,int[][]grid,boolean[][]vis,List<String>path,int baser,int basecol){
        vis[row][col]=true;
        int n = grid.length;
        int m = grid[0].length;
        path.add((row-baser)+","+(col-basecol));
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(isValid(nrow, ncol, n, m) && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                dfs(nrow,ncol,grid,vis,path,baser,basecol);
            }
        }
    }
    public int countDistinctIslands(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      boolean[][] vis=new boolean[n][m];
      Set<List<String>>st=new HashSet<>();
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(!vis[i][j] && grid[i][j]==1){
                vis[i][j]=true;
                List<String>path=new ArrayList<>();
                dfs(i,j,grid,vis,path,i,j);
                st.add(path);
            }
        }
      }
      return st.size();
    }
}

