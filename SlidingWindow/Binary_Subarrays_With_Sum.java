
/*
Explanation:
Given a binary array nums and an integer goal. Return the number of non-empty subarrays with a sum goal.
A subarray is a continuous part of the array. (Hard)
*/

class Solution {
    public int numSubarraysWithSumLessEqualToGoal(int[] nums, int goal) {
        if(goal<0)
        return 0;
        int l=0,r=0,count=0,sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
      public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }

}
