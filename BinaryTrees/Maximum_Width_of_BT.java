
/*
Explanation:
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels. The width of a level is determined by measuring the distance between its end nodes, which are the leftmost and rightmost non-null nodes. The length calculation additionally takes into account the null nodes that would be present between the end nodes if a full binary tree were to stretch down to that level.
*/

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        //your code goes here
        if(root==null)
        return 0;
        int ans=0;
        Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
        q.offer(new Pair<>(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().getValue();
            int first=0,last=0;
            for(int i=0;i<size;i++){
                int cur_id=q.peek().getValue()-mmin;
                TreeNode node=q.peek().getKey();
                q.poll();
                if(i==0) first=cur_id;
                if(i==size-1) last=cur_id;
                if(node.left!=null)
                q.offer(new Pair<>(node.left,cur_id*2 +1));
                 if(node.right!=null)
                q.offer(new Pair<>(node.right,cur_id*2 +2));

            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}
