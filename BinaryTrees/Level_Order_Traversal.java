
/*
Explanation:
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //your code goes here
        Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)
        return ans;
        q.add(root);
        while(!q.isEmpty()){
            int len=q.size();
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode node=q.poll();
                level.add(node.data);
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
