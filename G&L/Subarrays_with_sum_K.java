
/*
Explanation:
Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.
*/

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        int r=0;
        int l=0;
        int sum=0,cnt=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            int re=sum-k;
            if(sum==k)
            cnt++;
            if(hm.containsKey(re))
            cnt+=hm.getOrDefault(re,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
