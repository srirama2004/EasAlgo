
/*
Explanation:
Given two integer arrays, val and wt, each of size N, which represent the values and weights of N items respectively, and an integer W representing the maximum capacity of a knapsack, determine the maximum value achievable by selecting a subset of the items such that the total weight of the selected items does not exceed the knapsack capacity W.
Each item can either be picked in its entirety or not picked at all (0-1 property). The goal is to maximize the sum of the values of the selected items while keeping the total weight within the knapsack's capacity.
*/

class Solution {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
  int[][]dp=new int[n][W+1];
  for(int i =wt[0];i<=W;i++)
  dp[0][i]=val[0];
  for(int ind=1;ind<n;ind++){
    for(int cap=0;cap<=W;cap++){
        int nt=dp[ind-1][cap];
        int t=Integer.MIN_VALUE;
        if(wt[ind]<=cap)
        t=val[ind]+dp[ind-1][cap-wt[ind]];
        dp[ind][cap]=Math.max(nt,t);
    }
  }
  return dp[n-1][W];
    }
}

