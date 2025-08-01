
/*
Explanation:
Given an array arr of n integers, return true if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal else return false.
*/

class Solution {
  public boolean equalPartition(int n, int[] arr) {
    int target=0;
    for(int i=0;i<n;i++){
        target+=arr[i];
    }
    if(target%2==1)
    return false;
    target=target/2;
    boolean[][] dp = new boolean[n][target + 1];
    for (int i = 0; i < n; i++) dp[i][0] = true;
    if (arr[0] <= target) dp[0][arr[0]] = true;
    for (int ind = 1; ind < n; ind++) {
      for (int i = 1; i <= target; i++) {
        boolean nt = dp[ind - 1][i];
        boolean t = false;
        if (arr[ind] <= i) t = dp[ind - 1][i - arr[ind]];
        dp[ind][i] = t || nt;
      }
    }
    return dp[n - 1][target];
  }
}

