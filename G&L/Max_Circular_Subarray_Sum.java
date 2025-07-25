
/*
Explanation:
You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.
*/

class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int currMax = arr[0] , maxSum = arr[0];
        int currMin = arr[0] , minSum = arr[0];
        int totalSum = arr[0];
        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            currMax = Math.max(arr[i],currMax+arr[i]);
            maxSum = Math.max(maxSum,currMax);
            
            currMin = Math.min(arr[i],currMin+arr[i]);
            minSum = Math.min(minSum,currMin);
            
            totalSum += arr[i];
        }
        
        if(totalSum == minSum) //all negatives
        return maxSum;
        else
        return Math.max(maxSum,totalSum-minSum);
    }
}
