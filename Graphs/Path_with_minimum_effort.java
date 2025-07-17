
/*
Explanation:
A hiker is preparing for an upcoming hike. Given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of the cell (row, col). The hiker is situated in the top-left cell, (0, 0), and hopes to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,0-indexed). He can move up, down, left, or right. He wishes to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
*/

class Solution {
    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, -1, 0, 1};
    
    boolean isValid(int row, int col, int n, int m) {
        if (row < 0 || row >= n) return false;
        if (col < 0 || col >= m) return false;
        return true;
    }
    public int MinimumEffort(List<List<Integer>> heights) {
        int n = heights.size();
        int m = heights.get(0).size();
        int[][]maxDiff=new int[n][m];
        for(int[]row:maxDiff)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
          PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
          pq.add(new int[]{0,0,0});
          maxDiff[0][0]=0;
          while(!pq.isEmpty()){
            int[]p=pq.poll();
            int diff=p[0];
            int row=p[1];
            int col=p[2];
            if(row==n-1 && col==m-1){
                return diff;
            }
            for(int i=0;i<4;i++){
                int nrow=delRow[i]+row;
                int ncol=delCol[i]+col;
                if(isValid(nrow,ncol,n,m)){
                    int currdiff=Math.abs(heights.get(row).get(col)-heights.get(nrow).get(ncol));
                    if(Math.max(diff,currdiff)<maxDiff[nrow][ncol]){
                        maxDiff[nrow][ncol]=Math.max(diff,currdiff);
                        pq.add(new int[]{Math.max(diff,currdiff),nrow,ncol});
                    }
                }
            }
          }
          return -1;
    }
}

