
/*
Explanation:
Given an array of integers arr of size n, calculate the sum of the minimum value in each (contiguous) subarray of arr. Since the result may be large, return the answer modulo 109 +7.
*/

class Solution {
    private int[] findNSE(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int currEle=arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();
        ans[i]=!st.isEmpty() ? st.peek():n;
        st.push(i);
        }
        return ans;
    }
    private int[] findPSEE(int[]arr){
        int n=arr.length;
        int[]ans=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            int curr=arr[i];
            while(!st.isEmpty()&& arr[st.peek()]>arr[i])
            st.pop();
            ans[i]=!st.isEmpty() ? st.peek():-1;
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
   int[]nse=findNSE(arr);
   int[]psee=findPSEE(arr);
   int n=arr.length;
   int mod=(int)1e9+7;
   int sum=0;
   for(int i=0;i<n;i++){
    int left=i-psee[i];
    int right=nse[i]-i;
    long freq=left*right*1L;
    int val=(int)((freq*arr[i])%mod);
    sum=(sum+val)%mod;
   }
   return sum;
    }
}

