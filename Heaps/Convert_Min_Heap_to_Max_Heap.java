
/*
Explanation:
Given a min-heap in array representation named nums, convert it into a max-heap and return the resulting array.

A min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary min-heap and the same property is recursively true for all nodes in the Binary Tree.

A max-heap is a complete binary tree where the key at the root is the maximum among all keys present in a binary max-heap and the same property is recursively true for all nodes in the Binary Tree.

Since there can be multiple answers, the compiler will return true if it's correct, else false.
*/

class Solution {
    
    // Function to recursively heapify the array downwards
    private void heapifyDown(int[] arr, int ind) {
        int n = arr.length; // Size of the array

        // To store the index of largest element
        int largestInd = ind;

        // Indices of the left and right children
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;
        
        // If the left child holds larger value, update the largest index
        if(leftChildInd < n && arr[leftChildInd] > arr[largestInd]) {
            largestInd = leftChildInd;
        }

        // If the right child holds larger value, update the largest index
        if(rightChildInd < n && arr[rightChildInd] > arr[largestInd]) {
            largestInd = rightChildInd;
        }

        // If the largest element index is updated
        if(largestInd != ind) {
            // Swap the largest element with the current index
            int temp = arr[largestInd];
            arr[largestInd] = arr[ind];
            arr[ind] = temp;

            // Recursively heapify the lower subtree
            heapifyDown(arr, largestInd);
        }
    }

    // Function to convert a min-heap array to a max-heap array
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        // Iterate backwards on the non-leaf nodes
        for(int i = n/2 - 1; i >= 0; i--) {
            // Heapify each node downwards to ensure max-heap property
            heapifyDown(nums, i);
        }
        return nums;
    }
}
