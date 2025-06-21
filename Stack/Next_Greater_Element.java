
/*
Explanation:
Given an array arr of size n containing elements, find the next greater element for each element in the array in the order of their appearance.

The next greater element of an element in the array is the nearest element on the right that is greater than the current element.

If there does not exist a next greater element for the current element, then the next greater element for that element is -1.
*/

class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length; 
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];
            while(!st.isEmpty() && 
                  st.peek() <= currEle) {
                st.pop();
            }
            if(st.isEmpty()) 
                ans[i] = -1;
            else 
                ans[i] = st.peek();
            st.push(currEle);
        }
        
        // Return the result
        return ans;
    }
}
