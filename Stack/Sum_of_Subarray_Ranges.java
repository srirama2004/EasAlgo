
/*
Explanation:
Given an integer array nums, determine the range of a subarray, defined as the difference between the largest and smallest elements within the subarray. Calculate and return the sum of all subarray ranges of nums.
A subarray is defined as a contiguous, non-empty sequence of elements within the array.
*/

class Solution {
    /* Function to find the sum of 
    subarray ranges in each subarray */
    public long subArrayRanges(int[] arr) {
        
        // Size of array
        int n = arr.length;
        
        // To store the sum
        long sum = 0;
        
        // Traverse on the array
        for (int i = 0; i < n; i++) {
            
            // To store the smallest value of subarray
            int smallest = arr[i];
            
            // To store the largest value of subarray
            int largest = arr[i];
            
            /* Nested loop to get all 
            subarrays starting from index i */
            for (int j = i; j < n; j++) {
                
                // Update the smallest value
                smallest = Math.min(smallest, arr[j]);
                
                // Update the largest value
                largest = Math.max(largest, arr[j]);
                
                // Update the sum
                sum += (largest - smallest);
            }
        }
        
        // Return the computed sum
        return sum;
    }
}
