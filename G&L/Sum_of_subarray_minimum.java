
/*
Explanation:
Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.
*/

class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        
        int prevSmaller[] = new int[n];
        int nextSmaller[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = n - 1 ; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            if(st.isEmpty()) nextSmaller[i] = n;
            else nextSmaller[i] = st.peek();
            
            st.push(i);
        }
        st.clear();
        
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) prevSmaller[i] = -1;
            else prevSmaller[i] = st.peek();
            
            st.push(i);
        }
        
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int val = (nextSmaller[i] - i) * (i - prevSmaller[i]);
            ans += val * arr[i];
        }

        return ans;
    }
}
