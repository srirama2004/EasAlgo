
/*
Explanation:
Given a circular integer array arr, return the next greater element for every element in arr.
The next greater element for an element x is the first element greater than x that we come across while traversing the array in a clockwise manner.
If it doesn't exist, return -1 for that element element.
*/

class Solution {
    public int[] nextGreaterElements(int[] arr) {
   int n=arr.length;
   int[]ans=new int[n];
   Stack<Integer>st=new Stack<>();
   int curr=0;
   for(int i=2*n-1;i>=0;i--){
    int idx=i%n;
    curr=arr[idx];
    while(!st.isEmpty() && st.peek()<=curr){
        st.pop();
    }
    if(i<n){
        if(st.isEmpty())
        ans[i]=-1;
        else
        ans[i]=st.peek();
    }
    st.push(curr);
   }
   return ans;
    }
}

