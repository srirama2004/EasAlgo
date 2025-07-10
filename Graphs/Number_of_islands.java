
/*
Explanation:
Given a grid of size N x M (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) and ‘1's(Land). Find the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
*/

class Solution {
  private boolean isValid(int i,int j,int n,int m){
    if(i<0 || i>=n)
    return false;
    if(j<0 || j>=m)
    return false;
    return true;
  }
  private void bfs(int i,int j,boolean[][]vis,char[][]grid){
    vis[i][j]=true;
    Queue<int[]>q=new LinkedList<>();
    int n=grid.length;
    int m=grid[0].length;
    q.add(new int[]{i,j});
    while(!q.isEmpty()){
      int[]cell=q.poll();
      int row=cell[0];
      int col=cell[1];
      for(int delrow=-1;delrow<=1;delrow++){
        for(int delcol=-1;delcol<=1;delcol++){
          int newrow=delrow+row;
          int newcol=delcol+col;
          if(isValid(newrow,newcol,n,m) && grid[newrow][newcol]=='1' && !vis[newrow][newcol]){
            vis[newrow][newcol]=true;
            q.add(new int[]{newrow,newcol});
          }
        }
      }
    }
  }
    public int numIslands(char[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       boolean vis[][]=new boolean[n][m];
       int count=0;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
          if(!vis[i][j] && grid[i][j]=='1'){
            count++;
            bfs(i,j,vis,grid);
          }
        }
       }
       return count;
    }
}


