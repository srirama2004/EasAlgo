
/*
Explanation:
Given a rod of length N inches and an array price[] where price[i] denotes the value of a piece of rod of length i inches (1-based indexing). Determine the maximum value obtainable by cutting up the rod and selling the pieces. Make any number of cuts, or none at all, and sell the resulting pieces.
*/

class Solution{
    public int RodCutting(int price[], int n) {
      int[][]dp=new int[n][n+1];
      for(int i=0;i<=n;i++)
      dp[0][i]=price[0]*i;
      for(int ind=1;ind<n;ind++){
        for(int len=1;len<n+1;len++){
          int nt=dp[ind-1][len];
          int t=Integer.MIN_VALUE ;
          int rl=ind+1;
          if(rl<=len)
          t=price[ind]+dp[ind][len-rl];
          dp[ind][len]=Math.max(nt,t);
        }
      }
      return dp[n-1][n];
    }
}
