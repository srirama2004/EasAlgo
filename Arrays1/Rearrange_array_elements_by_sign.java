
/*
Explanation:
Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:
Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int nums1[]=new int[nums.length];
        int k=0;
        int j=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums1[j]=nums[i];
                j=j+2;
            }
            else{
                nums1[k]=nums[i];
                k=k+2;
            }
        }
        return nums1;
    }
}
