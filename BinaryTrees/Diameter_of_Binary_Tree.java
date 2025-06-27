
/*
Explanation:
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in the tree. It may or may not pass through the root.
*/


class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        //your code goes here
        int[]diameter=new int[1];
        diameter[0]=0;
        height(root,diameter);
        return diameter[0];
    }
    private int height(TreeNode root,int[]diameter){
      if(root==null)
      return 0;
      int lh=height(root.left,diameter);
      int rh=height(root.right,diameter);
      diameter[0]=Math.max(diameter[0],lh+rh);
      return 1+Math.max(lh,rh);

    }
}
