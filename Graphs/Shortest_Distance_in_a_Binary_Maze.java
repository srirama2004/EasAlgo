
/*
Explanation:
Given an n x m matrix grid where each cell contains either 0 or 1, determine the shortest distance between a source cell and a destination cell. You can move to an adjacent cell (up, down, left, or right) if that adjacent cell has a value of 1. The path can only be created out of cells containing 1. If the destination cell is not reachable from the source cell, return -1.
*/

class Solution {
      private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, -1, 0, 1};
    private boolean isValid(int row, int col, 
                            int n, int m) {
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        return true;
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
         if (source[0] == destination[0] && 
            source[1] == destination[1])
            return 0;
Queue<int[]>q=new LinkedList<>();
int n=grid.length;
int m=grid[0].length;
int[][]dist=new int[n][m];
for(int[]row:dist){
    Arrays.fill(row,Integer.MAX_VALUE);
}
dist[source[0]][source[1]]=0;
q.add(new int[]{0,source[0],source[1]});
while(!q.isEmpty()){
    int[]it=q.poll();
    int dis=it[0];
    int row=it[1];
    int col=it[2];
    for(int i=0;i<4;i++){
        int nrow=delRow[i]+row;
        int ncol=delCol[i]+col;
        if(isValid(nrow,ncol,n,m) && dis+1<dist[nrow][ncol] && grid[nrow][ncol]==1){
            dist[nrow][ncol]=dis+1;
               if (nrow == destination[0] && 
                        ncol == destination[1])
                        return dis + 1;
                q.add(new int[]{dis+1,nrow,ncol});


        }
    }
}
return -1;
    }
}


