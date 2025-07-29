
/*
Explanation:
Given a 2d array called matrix consisting of integer values. Return the minimum path sum that can be obtained by starting at any cell in the first row and ending at any cell in the last row.

Movement is allowed only to the bottom, bottom-right, or bottom-left cell of the current cell.
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
int n=matrix.length;
int m=matrix[0].length;
int[][]dp=new int[n][m];
for(int i=0;i<m;i++)
dp[0][i]=matrix[0][i];
for(int i=1;i<n;i++){
    for(int j=0;j<m;j++){
        int up=matrix[i][j]+dp[i-1][j];
        int left=matrix[i][j];
        if(j-1>=0)
        left+=dp[i-1][j-1];
        else
        left=Integer.MAX_VALUE;
        int right=matrix[i][j];
        if(j+1<m){
            right+=dp[i-1][j+1];
        }
        else
        right=Integer.MAX_VALUE;
        dp[i][j]=Math.min(up,Math.min(left,right));
  }
}
int mini=Integer.MAX_VALUE;
for(int i=0;i<m;i++){
    mini=Math.min(mini,dp[n-1][i]);
}
return mini;
    }
}
