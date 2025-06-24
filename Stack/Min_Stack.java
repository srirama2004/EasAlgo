
/*
Explanation:
Design a stack that supports the following operations in constant time: push, pop, top, and retrieving the minimum element.
Implement the MinStack class:
*/

class MinStack {
  private Stack<Integer> st;
    private int mini;
    public MinStack() {
        st=new Stack<>();
    }

    public void push(int val) {
   if(st.isEmpty())
   {
    mini=val;
    st.push(val);
   }
   else{
    if(val>mini)
    st.push(val);
    else{
        st.push(2*val-mini);
        mini=val;
    }
   }
    }

    public void pop() {
if(st.isEmpty())
return;
int x=st.pop();
if(x<mini)
mini=2*mini-x;
    }

    public int top() {
    if(st.isEmpty())
    return -1;
    int x=st.peek();
    if(mini<x) return x;
    return mini;
    }

    public int getMin() {
        return mini;
    }
}
