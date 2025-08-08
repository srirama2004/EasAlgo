
/*
Explanation:
Given two strings str1 and str2, find the length of their longest common subsequence.

A subsequence is a sequence that appears in the same relative order but not necessarily contiguous and a common subsequence of two strings is a subsequence that is common to both strings.
*/

class Solution {
    public int lcs( String str1, String str2) {
     int n=str1.length();
     int m=str2.length();
     int[][]dp=new int[n+1][m+1];
     for(int i=0;i<n+1;i++)
     dp[i][0]=0;
    for(int i=0;i<m+1;i++)
     dp[0][i]=0;
     for(int i=1;i<=n;i++){
      for(int j=1;j<=m;j++){
        if(str1.charAt(i-1)==str2.charAt(j-1))
        dp[i][j]=1+dp[i-1][j-1];
        else
        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
      }
     }
     return dp[n][m];
    }
}


