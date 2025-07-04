
/*
Explanation:
Given an array of integers nums. Check whether the array represents a binary min-heap or not. Return true if it does, otherwise return false.

A binary min-heap is a complete binary tree where the key at the root is the minimum among all keys present in a binary min-heap and the same property is recursively true for all nodes in a Binary Tree.
*/

class Solution {
    public boolean isHeap(int[] nums) {
int n=nums.length;
for(int i=n/2-1;i>=0;i--){
    int lc=2*i+1;
    int rc=2*i+2;
    if(lc<n && nums[lc]<nums[i])
    return false;
    if(rc<n && nums[rc]<nums[i])
    return false;
}
return true;
    }
}
