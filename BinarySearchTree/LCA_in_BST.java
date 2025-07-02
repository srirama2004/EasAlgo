
/*
Explanation:
Given the root node of a binary search tree (BST) and two node values p,q.
Return the lowest common ancestors(LCA) of the two nodes in BST.
*/

class Solution {
    public TreeNode lca(TreeNode root, int p, int q) {
        if(root==null)
        return null;
        int curr=root.data;
        if(curr<p && curr<q)
        return lca(root.right,p,q);
        if(curr>p && curr>q)
        return lca(root.left,p,q);
        return root;
    }
}
