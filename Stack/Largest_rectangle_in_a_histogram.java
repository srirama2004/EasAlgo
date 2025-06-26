
/*
Explanation:
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1 return the area of the largest rectangle in the histogram.
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
       int n=heights.length;
       Stack<Integer>st=new Stack<>();
       int maxArea=0;
       int pse,nse;
       int area=0;
       for(int i=0;i<n;i++){
        while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
            int ind=st.pop();
            pse=st.isEmpty()? -1:st.peek();
            nse=i;
            area=heights[ind]*(nse-pse-1);
            maxArea=Math.max(maxArea,area);
        }
        st.push(i);
       }
       while(!st.isEmpty()){
        nse=n;
        int ind=st.pop();
        pse= st.isEmpty() ? -1:st.peek();
        area=heights[ind]*(nse-pse-1);
            maxArea=Math.max(maxArea,area);
       }
       return maxArea;
    }
}

