
/*
Explanation:
Given an array arr of n integers, where arr[i] represents price of the stock on the ith day. Determine the maximum profit achievable by buying and selling the stock any number of times.

Holding at most one share of the stock at any given time is allowed, meaning buying and selling the stock can be done any number of times, but the stock must be sold before buying it again. Buying and selling the stock on the same day is permitted.
*/

class Solution {
  public int stockBuySell(int[] arr, int n) {
    int[][] dp = new int[n + 1][2];
    dp[n][0] = dp[n][1] = 0;
    int profit = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int buy = 0; buy <= 1; buy++) {
        if (buy == 0) profit = Math.max(0 + dp[i + 1][0], (-1) * arr[i] + dp[i + 1][1]);
        if (buy == 1) profit = Math.max(0 + dp[i + 1][1], arr[i] + dp[i + 1][0]);
        dp[i][buy] = profit;
      }
    }
    return dp[0][0];
  }
}

