
/*
Explanation:
Given a root of binary tree, find the lowest common ancestor (LCA) of two given nodes (p, q) in the tree.

The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //your code goes here
        if(root==null || root==p || root==q)
        return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
         TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null)
        return right;
         if(right==null)
        return left;
        else
        return root;

    }
}
