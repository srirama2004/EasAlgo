
/*
Explanation:
Given root of the binary tree, return its maximum depth.
A binary tree's maximum depth is number of nodes along the longest path from from root node down to the farthest node.
*/

class Solution {
    public int maxDepth(TreeNode root) {
        //your code goes here
        if(root==null)
        return 0;
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}
