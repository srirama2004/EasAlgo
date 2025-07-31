
/*
Explanation:
Given an array, arr, of n integers, where arr[i] represents the price of the stock on an ith day, determine the maximum profit achievable by completing at most two transactions in total.

Holding at most one share of the stock at any time is allowed, meaning buying and selling the stock twice is permitted, but the stock must be sold before buying it again. Buying and selling the stock on the same day is allowed.
*/

class Solution {
    public int stockBuySell(int[] arr, int n) {
     int[][][]dp=new int[n+1][2][3];
     for(int ind=n-1;ind>=0;ind--){
        for(int buy=0;buy<=1;buy++){
            for(int cap=1;cap<=2;cap++){
                if(buy==0)
                dp[ind][buy][cap]=Math.max(0+dp[ind+1][0][cap],(-1)*arr[ind]+dp[ind+1][1][cap]);
                if(buy==1)
                dp[ind][buy][cap]=Math.max(0+dp[ind+1][1][cap],arr[ind]+dp[ind+1][0][cap-1]);
            }
        }
     }
     return dp[0][0][2];
    }
}


