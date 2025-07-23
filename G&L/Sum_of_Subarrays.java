
/*
Explanation:
Given an array arr[], find the sum of all the subarrays of the given array.

Note: It is guaranteed that the total sum will fit within a 32-bit integer range.
*/

class Solution {
    public int subarraySum(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i]*(i+1)*(arr.length-i);
        }
        return sum;
    }
}

