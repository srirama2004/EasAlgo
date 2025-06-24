
/*
Explanation:
Given an array of integers arr, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.(Hard)
*/

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
    int n=arr.length;
    int[]ans=new int[n-k+1];
    int ansidx=0;
    Deque<Integer>dq=new LinkedList<>();
    for(int i=0;i<n;i++){
        if(!dq.isEmpty()&& dq.peekFirst()<=(i-k))
        dq.pollFirst();
        while(!dq.isEmpty()&& arr[dq.peekLast()]<=arr[i])
        dq.pollLast();
        dq.offerLast(i);
        if(i>=(k-1))
        ans[ansidx++]=arr[dq.peekFirst()];
    }
    return ans;
    }
}

