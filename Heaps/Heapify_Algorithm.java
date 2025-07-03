
/*
Explanation:
Given an array nums representing a min-heap and two integers ind and val, set the value at index ind (0-based) to val and perform the heapify algorithm such that the resulting array follows the min-heap property.

Modify the original array in-place, no need to return anything.
*/

class Solution {
    public void heapify(int[] nums, int ind, int val) {
if(nums[ind]>val){
    nums[ind]=val;
    heapifyUp(nums,ind);
}
else{
    nums[ind]=val;
    heapifyDown(nums,ind);
}
    }
    private void heapifyDown(int[]arr,int ind){
        int n=arr.length;
        int smallest_Ind=ind;
        int lc=2*ind+1;
        int rc=2*ind+2;
        if(lc<n && arr[lc]<arr[smallest_Ind])
        smallest_Ind=lc;
        if(rc<n && arr[rc]<arr[smallest_Ind])
        smallest_Ind=rc;
        if(smallest_Ind!=ind){
            int t=arr[smallest_Ind];
            arr[smallest_Ind]=arr[ind];
            arr[ind]=t;
              heapifyDown(arr,smallest_Ind); 
        }
      
    }
    private void heapifyUp(int[]arr,int ind){
        int parent_Ind=(ind-1)/2;
        if(ind>0 && arr[parent_Ind]>arr[ind]){
            int t=arr[parent_Ind];
            arr[parent_Ind]=arr[ind];
            arr[ind]=t;
            heapifyUp(arr,parent_Ind);
        }
    }
}
