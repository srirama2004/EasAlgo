
/*
Explanation:
Given an array nums and an integer k. 
R﻿eturn true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.
*/

class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
         //your code goes here
            int n = nums.length;
        return solve(0, n, nums, k); 
    }
    private boolean solve(int i,int n,int[] nums,int k){
        if(k==0)
        return true;
        if(k<0)
        return false;
        if(i==n){
            return k==0;
        }
        return solve(i+1,n,nums,k-nums[i])|| solve(i+1,n,nums,k);
    }
}
