
/*
Explanation:
You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.
*/




class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
         int N = 1000010;
        int n=arr.length;
        int max=1;
        boolean present[]=new boolean[N];
        for(int i=0;i<n;i++){
            if(arr[i]>0){
            present[arr[i]]=true;
            }
            max=Math.max(arr[i],max);
        }
        for(int i=1;i<=max;i++){
            if(present[i]!=true)
            return i;
        }
         return max+1;
    }
}

