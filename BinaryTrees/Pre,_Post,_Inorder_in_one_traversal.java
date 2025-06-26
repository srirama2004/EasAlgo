
/*
Explanation:
Given a binary tree with root node. Return the In-order,Pre-order and Post-order traversal of the binary tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/
class NodeState{
    TreeNode node;
    int state;
    NodeState(TreeNode node,int state){
        this.node=node;
        this.state=state;
    }
}
class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {
        //your code goes here
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(root==null)
        return Arrays.asList(pre,in,post);
        Stack<NodeState>st=new Stack<>();
        st.push(new NodeState(root,1));
        while(!st.isEmpty()){
              NodeState top=st.pop();
              TreeNode node=top.node;
              int state=top.state;
              if(state==1){
                pre.add(node.data);
                st.push(new NodeState(node,2));
                if(node.left!=null){
                    st.push(new NodeState(node.left,1));
                }
              }
             else if(state==2){
                in.add(node.data);
                st.push(new NodeState(node,3));
                if(node.right!=null){
                    st.push(new NodeState(node.right,1));
                }
              }
              else{
                post.add(node.data);
              }
        }
        return Arrays.asList(in,pre,post);
    }
}
