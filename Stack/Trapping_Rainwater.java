
/*
Explanation:
Given an array of non-negative integers, height representing the elevation of ground. Calculate the amount of water that can be trapped after rain.
*/

class Solution {
    // Function to find the prefix maximum array
    private int[] findPrefixMax(int[] arr, int n) {
        // To store the prefix maximum
        int[] prefixMax = new int[n];
        
        // Initial configuration
        prefixMax[0] = arr[0];
        
        // Traverse the array
        for(int i = 1; i < n; i++) {
            // Store the maximum till ith index
            prefixMax[i] = 
                Math.max(prefixMax[i-1], arr[i]);
        }
        
        // Return the prefix maximum array
        return prefixMax;
    }
    
    // Function to find the suffix maximum array
    private int[] findSuffixMax(int[] arr, int n) {
        // To store the suffix maximum
        int[] suffixMax = new int[n];
        
        // Initial configuration
        suffixMax[n-1] = arr[n-1];
        
        // Traverse the array
        for(int i = n-2; i >= 0; i--) {
            // Store the maximum till ith index
            suffixMax[i] = 
                Math.max(suffixMax[i+1], arr[i]);
        }
        
        // Return the suffix maximum array
        return suffixMax;
    }

    // Function to get the trapped water
    public int trap(int[] height) {
        
        int n = height.length; // Size of array
    
        // To store the total trapped rainwater
        int total = 0;
        
        // Calculate prefix maximum array
        int[] leftMax = 
            findPrefixMax(height, n);
        
        // Calculate suffix maximum array
        int[] rightMax = 
            findSuffixMax(height, n);
        
        // Traverse the array
        for(int i = 0; i < n; i++) {
            
            /* If there are higher grounds 
            on both side to hold water */
            if(height[i] < leftMax[i] && 
               height[i] < rightMax[i]) {
                   
                // Add up the water on top of current height
                total += ( Math.min(leftMax[i], rightMax[i]) 
                           - height[i] );
            }
        }
        return total;
    }
}
