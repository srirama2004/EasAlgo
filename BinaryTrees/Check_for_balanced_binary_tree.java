
/*
Explanation:
Given a binary tree root, find if it is height-balanced or not.
A tree is height-balanced if the difference between the heights of left and right subtrees is not more than one for all nodes of the tree. 
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        //your code goes here
        if(root==null)
        return true;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        if(Math.abs(lh-rh)<=1 && isBalanced(root.left)&& isBalanced(root.right))
        return true;
        return false;
	}
  private int getHeight(TreeNode root){
    if(root==null)
    return 0;
    int lh=getHeight(root.left);
    int rh=getHeight(root.right);
    return 1+Math.max(lh,rh);
  }
}
