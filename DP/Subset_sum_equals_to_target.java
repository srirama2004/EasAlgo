
/*
Explanation:
Given an array arr of n integers and an integer target, determine if there is a subset of the given array with a sum equal to the given target.
*/

class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
        int n=arr.length;
      boolean[][]dp=new boolean[n][target+1];
      for(int i=0;i<n;i++)
      dp[i][0]=true;
      if(arr[0]<=target)
      dp[0][arr[0]]=true;
      for(int ind=1;ind<n;ind++){
        for(int i=1;i<=target;i++){
            boolean nt=dp[ind-1][i];
            boolean t=false;
            if(arr[ind]<=i)
            t=dp[ind-1][i-arr[ind]];
            dp[ind][i]= t || nt;

        }
      }
      return dp[n-1][target];
    }
}

