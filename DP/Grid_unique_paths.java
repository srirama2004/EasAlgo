
/*
Explanation:
Given two integers m and n, representing the number of rows and columns of a 2d array named matrix. Return the number of unique ways to go from the top-left cell (matrix[0][0]) to the bottom-right cell (matrix[m-1][n-1]).

 Movement is allowed only in two directions from a cell: right and bottom.
*/

class Solution {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = 1;
          continue;
        }
        int up=0;
        int left=0;
        if(i>0)
        up=dp[i-1][j];
        if(j>0)
        left=dp[i][j-1];
        dp[i][j] =up+left;
      }
    }
    return dp[m - 1][n - 1];
  }
}

