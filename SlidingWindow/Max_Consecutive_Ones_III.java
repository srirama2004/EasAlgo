
/*
Explanation:
Given a binary array nums and an integer k, flip at most k 0's.
Return the maximum number of consecutive 1's after performing the flipping operation. (Hard)
*/

class Solution {
  public int longestOnes(int[] nums, int k) {
    int n = nums.length;
    int l = 0, r = 0, maxlen = 0, zeros = 0;
    while (r < n) {
      if (nums[r] == 0) zeros++;
      if (zeros > k) {
        if (nums[l] == 0) zeros--;
        l++;
      }
      int len = r - l + 1;
      maxlen = Math.max(maxlen, len);
      r++;
    }
    return maxlen;
  }
}

