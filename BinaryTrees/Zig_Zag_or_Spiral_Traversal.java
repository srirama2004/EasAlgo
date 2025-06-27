
/*
Explanation:
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //your code goes here
        Queue<TreeNode>q=new LinkedList<>();
        boolean leftToRight = true;
        List<List<Integer>>res=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>row=new ArrayList<>(Collections.nCopies(size, 0));
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                int index=leftToRight ? i:(size-i-1);
                row.set(index,node.data);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            leftToRight=!leftToRight;
            res.add(row);
        }
        return res;
    }
}
