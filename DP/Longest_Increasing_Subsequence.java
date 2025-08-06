
/*
Explanation:
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3, 6, 2, 7] is a subsequence of [0, 3, 1, 6, 2, 2, 7].

The task is to find the length of the longest subsequence in which every element is greater than the previous one.
*/

class Solution {
    /* Function to find the longest increasing 
    subsequence in the given array */
    public int LIS(int[] nums) {
        int n = nums.length;
        
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        
        // Iterate on the elements of the array
        for (int i = 1; i < n; i++) {
            
            // If the current element can be added to the subsequence
            if (nums[i] > temp.get(temp.size() - 1)) 
                temp.add(nums[i]); 
                
            // Otherwise
            else {
                // Index at which the current element must be placed
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                
                // Place the current element in the subsequence
                temp.set(ind, nums[i]);
            }    
        }
        
        // Return the length of temporary subsequence created so far
        return temp.size();
    }
}
