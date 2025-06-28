
/*
Explanation:
Assuming standing on the right side of a binary tree and given its root, return the values of the nodes visible, arranged from top to bottom.
*/


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursionRight(root, 0, res);
        return res;
    }
    private void recursionRight(TreeNode node,int level,List<Integer>res){
        if(node==null)
        return;
        if(level==res.size())
        res.add(node.data);
        recursionRight(node.right,level+1,res);
          recursionRight(node.left,level+1,res);
    }
}
