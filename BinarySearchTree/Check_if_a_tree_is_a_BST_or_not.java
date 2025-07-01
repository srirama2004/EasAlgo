
/*
Explanation:
Given the root node of a binary tree. Return true if the given binary tree is a binary search tree(BST) else false.
A valid BST is defined as follows:

The left subtree of a node contains only nodes with key strictly less than the node's key.
The right subtree of a node contains only nodes with key strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

class Solution {
    public boolean isBST(TreeNode root) {
        //your code goes here
         return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean validate(TreeNode node,long min,long max){
        if(node==null)
        return true;
        if(node.data<=min || node.data>=max)
        return false;
        return validate(node.left,min,node.data) && validate(node.right,node.data,max);
    }
}
