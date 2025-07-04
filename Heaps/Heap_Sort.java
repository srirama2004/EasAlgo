
/*
Explanation:
Given an array of integers nums, sort the array in non-decreasing order using the heap sort algorithm. Sort the given array itself, there is no need to return anything.

A sorted array in non-decreasing order is one in which each element is either greater than or equal to all the elements to its left in the array.
*/

class Solution {
    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int last=nums.length-1;
        while(last>0){
            int t=nums[0];
            nums[0]=nums[last];
            nums[last]=t;
            last--;
            if(last>0)
            heapifyDown(nums,last,0);
        }
        return;
    }
    private void heapifyDown(int[]arr,int last,int ind){
        int largestInd=ind;
        int lc=2*ind+1;
        int rc=2*ind+2;
        if(lc<=last && arr[lc]>arr[largestInd])
        largestInd=lc;
        if(rc<=last && arr[rc]>arr[largestInd])
        largestInd=rc;
        if(largestInd!=ind){
            int t=arr[ind];
            arr[ind]=arr[largestInd];
            arr[largestInd]=t;
            heapifyDown(arr,last,largestInd);
        }
        return;
    }
    public void buildMaxHeap(int[]nums){
        int n=nums.length;
        for(int i=n/2-1;i>=0;i--){
            heapifyDown(nums,n-1,i);
        }
        return;
    }
}
