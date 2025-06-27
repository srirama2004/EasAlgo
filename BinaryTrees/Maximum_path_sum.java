
/*
Explanation:
In a binary tree, a path is a list of nodes where there is an edge between every pair of neighbouring nodes. A node may only make a single appearance in the sequence. The total of each node's values along a path is its path sum. Return the largest path sum of all non-empty paths given the root of a binary tree.
Note: The path does not have to go via the root.
*/

class Solution {
    public int maxPathSum(TreeNode root) {
         int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0];
    }
    private int findMaxPathSum(TreeNode root,int[]maxi){
        if(root==null)
        return 0;
        int ls=Math.max(0,findMaxPathSum(root.left,maxi));
        int rs=Math.max(0,findMaxPathSum(root.right,maxi));
        maxi[0]=Math.max(maxi[0],ls+rs+root.data);
        return Math.max(ls,rs)+root.data;
    }
}
