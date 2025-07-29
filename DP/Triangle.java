
/*
Explanation:
Given a 2d integer array named triangle with n rows. Its first row has 1 element and each succeeding row has one more element in it than the row above it. Return the minimum falling path sum from the first row to the last.

Movement is allowed only to the bottom or bottom-right cell from the current cell.
*/

class Solution {
    public int minTriangleSum(int[][] triangle) {
           int n=triangle.length;
           int[][]dp=new int[n][n];
           for(int j=0;j<n;j++){
            dp[n-1][j]=triangle[n-1][j];
           }
           for(int i=n-2;i>=0;i--){
            for(int j=i; j>=0;j--){
                int down=triangle[i][j]+dp[i+1][j];
                int diagonal=triangle[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(down,diagonal);
            }
           }
           return dp[0][0];
    }
}
